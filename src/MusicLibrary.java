
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
        Playlist favorites = new Playlist("favorites");
        Playlist topRated = new Playlist("top rated");
        allPlaylists.add(recentPlayed);
        allPlaylists.add(frequentPlayed);
        allPlaylists.add(favorites);
        allPlaylists.add(topRated);
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
    
    public void updateGenre() {
    	HashMap<String, Integer> genres = new HashMap<String, Integer>();
    	for(Song song : musicLibrary) {
    		if(!genres.containsKey(song.getGenre())) {
    			genres.put(song.getGenre(), 1);
    		}
    		else {
    			genres.replace(song.getGenre(), genres.get(song.getGenre() + 1));
    		}
    	}
    	ArrayList<String> topGenres = getTopGenre(genres);
    	for(String top : topGenres) {
    		Playlist foundPlaylist = genrePlaylistExits(top);
    		if(foundPlaylist != null) {
    			foundPlaylist.replacePlaylist(getGenreSongs(top));
    		}
    		else {
    			Playlist newPlaylist = new Playlist(top);
    			for(Song song : musicLibrary) {
    	    		if(song.getGenre().equalsIgnoreCase(top)) {
    	    			newPlaylist.addSong(song);
    	    			}
    	    		}
    			allPlaylists.add(newPlaylist);
    		}
    	}
    }
    
    private ArrayList<Song> getGenreSongs(String genre){
    	ArrayList<Song> answer = new ArrayList<Song>();
    	for(Song song : musicLibrary) {
    		if(song.getGenre().equalsIgnoreCase(genre)) {
    			answer.add(song);
    		}
    	}
    	return answer;
    }
    
    private Playlist genrePlaylistExits(String genre) {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equalsIgnoreCase(genre)) {
    			return playlist;
    		}
    	}
    	return null;
    }
    
    //hAVENT FINISHED FUNCTION gotta check if it works and modify some things so it actually wokrs in our model
    private ArrayList<String> getTopGenre(HashMap<String, Integer> genres) {
        // Min-heap to store the top 10 genres based on song count
        PriorityQueue<HashMap.Entry<String, Integer>> minHeap = new PriorityQueue<>(10, Comparator.comparingInt((entry) -> entry.getValue()));

        // Iterate through the HashMap entries
        for (HashMap.Entry<String, Integer> entry : genres.entrySet()) {
            minHeap.add(entry);

            // Keep the heap size to 10 by removing the smallest element if it exceeds size 10
            if (minHeap.size() > 10) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // Build the result list (in descending order of frequency)
        ArrayList<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey()); // Add to the front to reverse order
        }

        return result;
    }


    
    
    public void updateFavorites() {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equalsIgnoreCase("favorites")) {
    			playlist.replacePlaylist(getFavorites());
    			break;
    		}
    	}
    }
    
    private ArrayList<Song> getFavorites(){
    	ArrayList<Song> favorites = new ArrayList<>();
    	for(Song song : musicLibrary) {
    		if(song.isFavorite()) {
    			favorites.add(song);
    		}
    	}
    	return favorites;
    }
    
    public void updateTop() {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equalsIgnoreCase("top rated")) {
    			playlist.replacePlaylist(getTop());
    			break;
    		}
    	}
    }
    
    private ArrayList<Song> getTop() {
    	ArrayList<Song> top = new ArrayList<>();
    	for(Song song : musicLibrary) {
    		if(song.getRating() == 4 || song.getRating() == 5) {
    			top.add(song);
    		}
    	}
    	return top;
    }
    
    //Doesnt check if the list is of 10 elements
    public void updateRecent(Song song) {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equalsIgnoreCase("recently played")) {
    			if(playlist.getSongs().size() < 10) {
    				playlist.addSong(song);
        			break;
    			}
    			playlist.removeFirstSong();
    			playlist.addSong(song);
    			break;
    		}
    	}
    }
    
    //Further checking if its corrent and valid
    
    public void updateFrequent() {
    	for(Playlist playlist : allPlaylists) {
    		if(playlist.getName().equalsIgnoreCase("frequenlt played")) {
    			playlist.replacePlaylist(getTopFrequent());
    			break;
    		}
    	}
    }
    
    
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
