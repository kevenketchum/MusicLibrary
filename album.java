package music;

public class Album extends LibraryItem {
    private final String artist;

    public Album(String name, String artist) {
        super(name);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void printItem() {
        System.out.println("Album: " + name + " by " + artist);
        for (Song song : songs) {
            System.out.println("- " + song.getName());
        }
    }
}
