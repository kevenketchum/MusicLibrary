package music;

import java.util.ArrayList;
import java.util.List;

public class MusicStore {
    private final List<Album> albums;

    public MusicStore() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public String searchSongByTitle(String title) {
    	boolean found = false;
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                	song.printItem();
                	found = true;
                }
            }
        }
        if(!found) {
        	System.out.println("Song not found.");
        }
    }

    public String searchAlbumByTitle(String title) {
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
    
    
    
    public String searchSongByArtist(String artist) {
    	boolean found = false;
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getAuthor().equalsIgnoreCase(artist)) {
                	song.printItem();
                	found = true;
                }
            }
        }
        if(!found) {
        	System.out.println("Artist not found.");
        }
    }
    
    public String searchAlbumByArtist(String artist) {
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

