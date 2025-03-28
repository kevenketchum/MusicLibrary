import java.util.ArrayList;
import java.util.List;

public class MusicStore {
    private final ArrayList<Album> albums;

    public MusicStore(List<String> fileNames) {
        this.albums = new ArrayList<>();
        for(String fileName : fileNames) {
            loadAlbumsFromFile(fileName);    	
        }
    }
    
    public MusicStore() {
    	this.albums = new ArrayList<>();
    }

    private void loadAlbumsFromFile(String fileName) {
        List<String> music = TextParser.readFile(fileName);
        
        if (music.isEmpty()) {
            System.out.println("ERROR: File " + fileName + " is empty or could not be read.");
            return;
        }

        // Parse the first line for album details
        String[] albumDetails = TextParser.parseCSV(music.get(0));
        if (albumDetails.length < 4) {
            System.out.println("ERROR: Invalid album format in " + fileName);
            return;
        }

        String albumTitle = albumDetails[0];
        String artist = albumDetails[1];
        String genre = albumDetails[2];
        // Create an empty album and add songs to it
        Album album = new Album(albumTitle, artist);
        
        // Add songs from the remaining lines
        for (int i = 1; i < music.size(); i++) {
            String songTitle = music.get(i).trim();
            if (!songTitle.isEmpty()) {
                Song song = new Song(songTitle, albumTitle, artist, genre);
                album.addSong(song);
            }
        }

        // Store the album in the list
        albums.add(album);
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
    
    public ArrayList<Album> getAlbums() {
    	return new ArrayList<Album>(albums);
    }
    
    public Song getSongByTitle(String title) {
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                	return song;
                }
            }
        }
        return null;
    }
    
    public void searchSongByGenre(String genre) {
    	ArrayList<Song> genreSongs = new ArrayList<>();
    	for(Album album : albums) {
    		for(Song song : album.getSongs()) {
    			if(song.getGenre().equalsIgnoreCase(genre)) {
    				genreSongs.add(song);
    			}
    		}
    	}
    	if(genreSongs.size() == 0) {
    		System.out.println("No songs with the genre "+genre+".\n");
    	}
    	else {
    		for(Song song : genreSongs) {
    			song.printItem();
    		}
    	}
    }

    public Song searchSongByTitle(String title) {
    	boolean found = false;
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                	song.printItem(); 
                	found = true;
                	return song;
                }
            }
        }
        if(!found) {
        	System.out.println("Song not found.");
        }
        return null;
    }

    public void searchAlbumByTitle(String title) {
    	boolean found = false;
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(title)) {
            	album.printItem();
            	found = true;
            }
        }
        if(!found) {
        	System.out.println("Album not found.");
        }
    }
    
    
    
    public Song searchSongByArtist(String artist) {
    	boolean found = false;
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getAuthor().equalsIgnoreCase(artist)) {
                	song.printItem();
                	found = true;
                	return song;
                }
            }
        }
        if(!found) {
        	System.out.println("Artist not found.");
        }
        return null;
    }
    
    public void searchAlbumByArtist(String artist) {
    	boolean found = false;
        for (Album album : albums) {
            if (album.getArtist().equalsIgnoreCase(artist)) {
            	album.printItem();
            	found = true;
            }
        }
        if(!found) {
        	System.out.println("Artist not found.");
        }
    }
}

