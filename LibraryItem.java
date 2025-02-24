package music;

import java.util.ArrayList;
import java.util.List;

public abstract class LibraryItem {
    protected final String name;
    protected final List<Song> songs;
    protected boolean inLibrary;

    public LibraryItem(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.inLibrary = false;
    }

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

    public void addSong(Song song) {
        songs.add(song);
    }

    public abstract void printItem();
}
