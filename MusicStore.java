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

    //For the song search we don't want to return the results since we don't want the algorithm to stop
    //We want all instances found to print
    public String searchSongByTitle(String title) {
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                    return song.getName() + " by " + song.getAuthor() + " from album " + song.getAlbum();
                }
            }
        }
        return "Song not found.";
    }
    
    //Changed it to print instead of returning since when album search we need to print all Songs on album
    //Album class has a printItem function so we should probably switch it to that
    public String searchAlbumByTitle(String title) {
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(title)) {
            	System.out.println("Album: " + album.getName() + " by " + album.getArtist());
            	for(Song song : album.getSongs) {
            		System.out.println("- "+song);
            	}
                return "Album: " + album.getName() + " by " + album.getArtist();
            }
        }
        return "Album not found.";
    }
    
    
    
    public String searchSongByArtist(String artist) {
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getAuthor().equalsIgnoreCase(artist)) {
                    return song.getName() + " by " + song.getAuthor() + " from album " + song.getAlbum();
                }
            }
        }
        return "Artist not found.";
    }
    
    //Changed it to print instead of returning since when album search we need to print all Songs on album
    public String searchAlbumByArtist(String artist) {
        for (Album album : albums) {
            if (album.getArtist().equalsIgnoreCase(artist)) {
            	System.out.println("Album: " + album.getName() + " by " + album.getArtist());
            	for(Song song : album.getSongs) {
            		System.out.println("- "+song);
            	}
                return "Album: " + album.getName() + " by " + album.getArtist();
            }
        }
        return "Artist not found.";
    }
}

