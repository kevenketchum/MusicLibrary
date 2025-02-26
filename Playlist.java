package music;

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
    
    public void removeSong(String tittle) {
    	Song remove;
    	for(Song s : songs) {
    		if(s.getName().equalsIgnoreCase(tittle)) {
    			remove = s;
    		}
    	}
    	if(remove == null) {
    		System.out.println("Song does not exist on playlist");
    	}
    	else {
    		songs.remove(remove);
    	}
    }
    
    public String getName() {
    	return this.name;
    }
    
 
    @Override
    public void printItem() {
        System.out.println("Playlist: " + name);
        for (Song song : songs) {
            System.out.println("- " + song.getName());
        }
    }
}

