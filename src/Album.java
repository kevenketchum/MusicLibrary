/* 
 * Class album.java, parameters: name, artist
 * Creates Album Object that extends LibraryItem : Class LibraryItem.Java, Parameters: Name, List of Songs, and inLibrary
 *  it takes a name and a artist
 * */

public class Album extends LibraryItem {
    private final String artist;
    
    //ALbum Object Initializer
    public Album(String name, String artist) {
        super(name);
        this.artist = artist;
    }
    
    //Getter
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

