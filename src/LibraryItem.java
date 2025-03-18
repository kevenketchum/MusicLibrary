
/* 
 * Class LibraryItem.Java, Parameters: Name, List of Songs, and inLibrary
 * This class represents the Users Library, containing the Albums and the songs of the user
 * */
import java.util.ArrayList;

public abstract class LibraryItem {
    //Instance variables
	protected final String name;
    protected final ArrayList<Song> songs;
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

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean isInLibrary() {
        return inLibrary;
    }


    public void addToLibrary() {
        this.inLibrary = true;
    }
    
    public void removeFromLibrary() {
    	this.inLibrary = false;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public abstract void printItem();
}
