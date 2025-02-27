import java.util.ArrayList;

public class MusicStore {
    private final ArrayList<Album> albums;

    public MusicStore() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }
    
    public ArrayList<Album> getAlbums() {
    	return new ArrayList<Album>(albums);
    }

    public void searchSongByTitle(String title) {
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
    
    
    
    public void searchSongByArtist(String artist) {
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

