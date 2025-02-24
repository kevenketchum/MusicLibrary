package music;

public class Playlist extends LibraryItem {

    public Playlist(String name) {
        super(name);
    }

    @Override
    public void printItem() {
        System.out.println("Playlist: " + name);
        for (Song song : songs) {
            System.out.println("- " + song.getName());
        }
    }
}

