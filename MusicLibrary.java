package music;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private final List<Song> musicLibrary;
    private final List<Album> albumList;
    private final List<Playlist> allPlaylists;

    public MusicLibrary() {
        this.musicLibrary = new ArrayList<>();
        this.albumList = new ArrayList<>();
        this.allPlaylists = new ArrayList<>();
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
        musicLibrary.add(song);
    }

    public void addAlbum(Album album) {
        albumList.add(album);
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
    
    //PLayList operations
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
    		System.out.println("Playlist with name: "+playlist+" not found.");
    	}
    	return false;
    }
    
}
