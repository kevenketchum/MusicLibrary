
import java.util.ArrayList;
//PLaylist needs to add and remove songs from it so I removed the extend from libraryItem to make it its own Object
public class Playlist {

	protected final String name;
    protected final ArrayList<Song> songs;
    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }
    
    public void addSong(Song song) {
    	songs.add(song);
    }
    
    public boolean removeSong(String tittle) {
    	Song remove = null;
    	for(Song s : songs) {
    		if(s.getName().equalsIgnoreCase(tittle)) {
    			remove = s;
    		}
    	}
    	if(remove == null) {
    		return false;
    	}
    	else {
    		songs.remove(remove);
    		return true;
    	}
    }
    
    public String getName() {
    	return this.name;
    }
    
 
    public void printItem() {
        System.out.println("Playlist: " + name);
        for (Song song : songs) {
            System.out.println("- " + song.getName());
        }
    }
}

