package music;

/* 
 * Class LibraryItem.Java, Parameters: Name, List of Songs, and inLibrary
 * This class represents the Users Library, containing the Albums and the songs of the user
 * */
import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem {
    //Instance variables
	protected final String name;
    protected final List<Song> songs;
    protected boolean inLibrary;
    
    //LibraryItem Initializer
    public LibraryItem(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.inLibrary = false;
    }
    
    //Getters/Setters
    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public boolean isInLibrary() {
        return inLibrary;
    }

    public void addToLibrary() {
        this.inLibrary = true;
    }
    
    public voide removeFromLibrary() {
    	this.inLibrary = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public abstract void printItem();
}
