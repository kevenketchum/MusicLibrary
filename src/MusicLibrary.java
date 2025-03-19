
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MusicLibrary {
    private final ArrayList<Song> musicLibrary;
    private final ArrayList<Album> albumList;
    private final ArrayList<Playlist> allPlaylists;

    public MusicLibrary() {
        this.musicLibrary = new ArrayList<>();
        this.albumList = new ArrayList<>();
        this.allPlaylists = new ArrayList<>();
        Playlist recentPlayed = new Playlist("recently played");
        Playlist frequentPlayed = new Playlist("frequently played");
        allPlaylists.add(recentPlayed);
        allPlaylists.add(frequentPlayed);
    }

    public List<Song> getMusicLibrary() {
        return musicLibrary;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public List<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    public void addSong(Song song) {
    	if(!musicLibrary.contains(song)) {
    		musicLibrary.add(song);
    	}
    	else {
    		System.out.println("Song already on library\n");
    	}
    }
    
    public void removeSong(Song song) {
    	musicLibrary.remove(song);
    	song.removeFromLibrary();
    }

    public void addAlbum(Album album) {
    	if(!albumList.contains(album)) {
    		albumList.add(album);
    	}
    	else {
    		System.out.println("Album already on library\n");
    	}
    }
    
    public void removeAlbum(Album album) {
    	albumList.remove(album);
    	album.removeFromLibrary();
    }

    public void addPlaylist(Playlist playlist) {
        allPlaylists.add(playlist);
    }
        
    //Search in Users Library By name
    
    public void searchSongByTitle(String title) {
    	boolean found = false;
    	for (Song song : musicLibrary) {
    		if (song.getName().equalsIgnoreCase(title)) {
    			song.printItem();
    			found = true;
    			}
            }
    	
    	if(!found) {
    		System.out.println("Song not found in User's Library.");
    	}
    }

    public void searchAlbumByTitle(String title) {
    	boolean found = false;
        for (Album album : albumList) {
            if (album.getName().equalsIgnoreCase(title)) {
            	album.printItem();
            	found = true;
            	}
            }
    if(!found){
    	System.out.println("Album not found in user's Library.");
    	}    
    }
    
    //Search in Users Library by Artist
    
    
    public void searchSongByArtist(String artist) {
    	boolean found = false;
    	for (Song song : musicLibrary) {
    		if (song.getAuthor().equalsIgnoreCase(artist)) {
    			song.printItem();
    			found = true;
    			}
            }
    	if(!found) {
    		System.out.println("Artist not found in User's Library.");
    	}
    }

    public void searchAlbumByArtist(String artist) {
    	boolean found = false;
        for (Album album : albumList) {
            if (album.getArtist().equalsIgnoreCase(artist)) {
            	album.printItem();
            	found = true;
            }
        }
        if(!found) {
        	System.out.println("Artist not found in user's Library.");
        }
    }
    
    //PlayList operations
    public Playlist getPlaylist(String name) {
    	for(Playlist play : allPlaylists) {
    		if(play.getName().equalsIgnoreCase(name)) {
    			return play;
    		}
    	}
    	return null;
    }
    
    
    //Returns false when PLayList not found in users Library
    public void getPlaylistInfo(String playList) {
    	boolean found = false;
    	for(Playlist play : allPlaylists) {
    		if(play.getName().equalsIgnoreCase(playList)) {
    			play.printItem();
    			found = true;
    		}
    	}
    	if(!found) {
    		System.out.println("Playlist with name: "+playList+" not found.");
    	}
    }
    
    //Doesnt check if the list is of 10 elements
    public void updateRecent(Song song) {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equals("recently played")) {
    			playlist.removeFirstSong();
    			playlist.addSong(song);
    		}
    	}
    }
    
    public void updateFrequent() {
    	
    }
    /*
    private ArrayList<Song> getTopFrequent(){
    	if(musicLibrary.size() <= 10) {
        	ArrayList<Song> top = musicLibrary;
    		return sortByPlays(top);
    	}
    	int min = Integer.MIN_VALUE;
    	int max = Integer.MAX_VALUE;
    	ArrayList<Song> top = new ArrayList<Song>();
    	for(Song song : musicLibrary) {
    		if(song.getFrequency() > min) {
    			top.add(song);
    			if(max < min) {
    				max = min;
    			}
    		}
    	}
    	
    	return top;
    }
    */
    
    private ArrayList<Song> getTopFrequent() {
        if (musicLibrary.size() <= 10) {
            ArrayList<Song> top = new ArrayList<>(musicLibrary);
            return sortByPlays(top);
        }

        // Min-heap to keep the top 10 most frequent songs
        PriorityQueue<Song> minHeap = new PriorityQueue<>(10, Comparator.comparingInt(Song -> Song.getFrequency()));

        for (Song song : musicLibrary) {
            if (minHeap.size() < 10) {
                minHeap.offer(song); // Add to heap if we haven't reached size 10
            }
            else if (song.getFrequency() > minHeap.peek().getFrequency()) {
                minHeap.poll(); // Remove the least frequent
                minHeap.offer(song);
            }
        }

        // Create a list from the heap and sort in descending order of frequency
        ArrayList<Song> top = new ArrayList<>(minHeap);
        while (!minHeap.isEmpty()) {
            top.add(minHeap.poll());
        }

        // Sort the extracted top elements using the same function
        return sortByPlays(top);
    }
    
    private ArrayList<Song> sortByPlays(ArrayList<Song> songs){
        Song temp;
        for(int i = 0; i < songs.size(); i++) {
        	for(int j = 0; j < songs.size() - i - 1; j++) {
        		if(songs.get(j).getFrequency() < songs.get(j + 1).getFrequency()) {
            		temp = songs.get(j);
            		songs.add(j, songs.get(j + 1));
            		songs.add(j + 1, temp);
        		}

        	}
        }
    	return songs;
    }
    
}
