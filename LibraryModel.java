package music;
/*
 *Class LibraryModel, Parameters: musicStore, musicLibrary
 *This class represents the model and functionality of adding songs from the musicStore to
 *the users Library
 *Special functionality: Add song or album by title from the musicStore to the users Library
 * return all items from user Library
 */
public class LibraryModel {
    //Instance Variables
	private final MusicStore musicStore;
    private final MusicLibrary musicLibrary;

    //Initializer
    public LibraryModel(MusicStore musicStore) {
        this.musicStore = musicStore;
        this.musicLibrary = new MusicLibrary();
    }
    
    //Adds song from the musicStore to the musicLibrary (User's)
    public boolean addSong(String title) {
        for (Album album : musicStore.albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                    song.addToLibrary();
                    musicLibrary.addSong(song);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAlbum(String title) {
        for (Album album : musicStore.albums) {
            if (album.getName().equalsIgnoreCase(title)) {
                album.addToLibrary();
                musicLibrary.addAlbum(album);
                
                //When an album is added, all the songs should be added to the users Library?
                for(Song s : album.getSongs()) {
                	s.addToLibrary();
                	musicLibrary.addSong(s);
                }
                return true;
            }
        }
        return false;
    }
    
    public void addPlaylist(String name) {
    	Playlist add = new Playlist(name);
    	musicLibray.addPLaylist(add);
    }

    
    //Add remove Songs from Playlist
    //kinda shitty remove/add from playlist, might change later
    public boolean addSongToPlaylist(String playlistName, String songName) {
    	for(Playlist play : musicLibrary.allPlayLists) {
    		if(play.getName().equalsIgnoreCase(playlistName)) {
    			for (Album album : musicStore.albums) {
    	            for (Song song : album.getSongs()) {
    	                if (song.getName().equalsIgnoreCase(songName)) {
    	                	play.addSong(song);
    	                }   
    	            }
    			}
    		return true;
    		}
    	}
    	return false;
   }
    
    public boolean removeSongFromPlaylist(String playlistName, String songName) {
    	for(Playlist play : musicLibrary.allPlayLists) {
    		if(play.getName().equalsIgnoreCase(playlistName)) {
    			for (Album album : musicStore.albums) {
    	            for (Song song : album.getSongs()) {
    	                if (song.getName().equalsIgnoreCase(songName)) {
    	                	play.removeSong(song);
    	                }   
    	            }
    			}
    		return true;
    		}
    	}
    	return false;
   }
    
    public String getAllLibraryItems() {
        StringBuilder sb = new StringBuilder();
        for (Song song : musicLibrary.getMusicLibrary()) {
            song.printSong();
        }
        for (Album album : musicLibrary.getAlbumList()) {
            album.printItem();
        }
        for (Playlist playlist : musicLibrary.getAllPlaylists()) {
            playlist.printItem();
        }
        return sb.toString();
    }
    
    public void setRating(String songName, int rating) {
    	for(Album album : musicStore.albums) {
    		for(Song song : album.getSOngs()) {
    			if(song.getName().equalsIgnoreCase(songName)) {
    				song.setRating(rating);
    			}
    		}
    	}
    }
    
    public void getFavorites() {
    	for(Album album : musicStore.albums) {
    		for(Song song : album.getSongs()) {
    			if(song.isFavorite()) {
    				song.printItem();
    			}
    		}
    	}
    }
}

