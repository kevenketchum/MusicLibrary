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
    
    public String searchSongByTitle(String title) {
    	for (Song song : musicLibrary) {
    		if (song.getName().equalsIgnoreCase(title)) {
    			return song.getName() + " by " + song.getAuthor() + " from album " + song.getAlbum();
    			}
            }
        return "Song not found in User's Library.";
    }

    public String searchAlbumByTitle(String title) {
        for (Album album : albumList) {
            if (album.getName().equalsIgnoreCase(title)) {
            	album.printItem();
            	}
                return "Album: " + album.getName() + " by " + album.getArtist();
            }
        }
        return "Album not found in user's Library.";
    }
    
    //Search in Users Library by Artist
    
    
    public String searchSongByArtist(String artist) {
    	for (Song song : musicLibrary) {
    		if (song.getAuthor().equalsIgnoreCase(artist)) {
    			return song.getName() + " by " + song.getAuthor() + " from album " + song.getAlbum();
    			}
            }
        return "Artist not found in User's Library.";
    }

    public String searchAlbumByArtist(String artist) {
        for (Album album : albumList) {
            if (album.getArtist().equalsIgnoreCase(artist)) {
            	album.printItem();
                return "Album: " + album.getName() + " by " + album.getArtist();
            }
        }
        return "Artist not found in user's Library.";
    }
    
    //PLayList operations
    public Playlist getPlaylist(String name) {
    	for(Playlist play : allPlaylists) {
    		if(play.getName().equalsIgnoreCase(name)) {
    			return play;
    		}
    	}
    }
    
    
    //Returns false when PLayList not found in users Library
    public boolean searchForPlaylist(String playList) {
    	for(Playlist play : allPlaylists) {
    		if(play.getName().equalsIgnoreCase(playList)) {
    			play.printItem();
    			return true;
    		}
    	}
    	return false;
    }
    
}
