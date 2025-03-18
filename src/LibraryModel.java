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
        for (Album album : musicStore.getAlbums()) {
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
        for (Album album : musicStore.getAlbums()) {
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
    	musicLibrary.addPlaylist(add);
    }
    
    public void librarySearchSongByTitle(String title) {
    	musicLibrary.searchSongByTitle(title);
    }
    
    public void librarySearchAlbumByTitle(String title) {
    	musicLibrary.searchAlbumByTitle(title);
    }
    
    public void librarySearchSongByArtist(String artist) {
    	musicLibrary.searchSongByArtist(artist);
    }
    
    public void librarySearchAlbumByArtist(String artist) {
    	musicLibrary.searchAlbumByArtist(artist);
    }

    
    //Add remove Songs from Playlist
    //kinda shitty remove/add from playlist, might change later
    public boolean addSongToPlaylist(String playlistName, String songName) {
    	Playlist play = musicLibrary.getPlaylist(playlistName);
    	for (Album album : musicStore.getAlbums()) {
    		for (Song song : album.getSongs()) {
    			if (song.getName().equalsIgnoreCase(songName)) {
    				play.addSong(song);
    				return true;
    	                }   
    		}
    	}
    	return false;
   }
    
    public void removeSongFromPlaylist(String playlistName, String songName) {
    	Playlist play = musicLibrary.getPlaylist(playlistName);
    	if(play == null) {
    		System.out.println("Playlist: "+playlistName+" Does not exist.");
    	}
    	boolean answer = play.removeSong(songName);
    	if(!answer) {
    		System.out.println("Song: "+songName+" does not exist on MusicLibrary");
    	}
    	else {
    		System.out.println("Succesfully removed "+songName+" from "+playlistName+".");
    	}
   }
    
    public void getPlaylistInfo(String name) {
    	musicLibrary.getPlaylistInfo(name);
    }
    
    public String getAllLibraryItems() {
        StringBuilder sb = new StringBuilder();
        for (Song song : musicLibrary.getMusicLibrary()) {
            song.printItem();
        }
        for (Album album : musicLibrary.getAlbumList()) {
            album.printItem();
        }
        for (Playlist playlist : musicLibrary.getAllPlaylists()) {
            playlist.printItem();
        }
        return sb.toString();
    }
    
    public boolean setRating(String songName, int rating) {
    	boolean found = false;
    	for(Album album : musicStore.getAlbums()) {
    		for(Song song : album.getSongs()) {
    			if(song.getName().equalsIgnoreCase(songName)) {
    				song.setRating(rating);
    				found = true;
    			}
    		}
    	}
    	return found;
    }
    
    public boolean setFavorite(String songName) {
    	for(Album album : musicStore.getAlbums()) {
    		for(Song song : album.getSongs()) {
    			if(song.getName().equalsIgnoreCase(songName)) {
    				if(song.isFavorite()) {
    					return false;
    				}
    				else {
    					song.setFavorite();
        				return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public void getFavorites() {
    	for(Album album : musicStore.getAlbums()) {
    		for(Song song : album.getSongs()) {
    			if(song.isFavorite()) {
    				song.printItem();
    			}
    		}
    	}
    }
}

