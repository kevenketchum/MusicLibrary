
import java.util.ArrayList;
//PLaylist needs to add and remove songs from it so I removed the extend from libraryItem to make it its own Object
public class Playlist {

	protected final String name;
    protected  ArrayList<Song> songs;
    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }
    
    public void addSong(Song song) {
    	songs.add(song);
    }
    
    public void removeFirstSong() {
    	songs.remove(0);
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
    
    
    //Figure out a better way of changin the value of the playlist
    public void replacePlaylist(ArrayList<Song> replacement) {
    	this.songs = replacement;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public ArrayList<Song> getSongs(){
    	return new ArrayList<Song>(songs);
    }
 
    public void printItem() {
        System.out.println("Playlist: " + name+"\n");
        for (Song song : songs) {
            song.printItem();
        }
        System.out.println();
    }
}

