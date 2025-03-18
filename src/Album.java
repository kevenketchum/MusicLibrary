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
    
    
    public String libraryStatus() {
    	if(this.inLibrary) {
    		return " It is currently on the library";
    	}
    	else {
    		return " not currently on library";
    	}
    }

    @Override
    public void printItem() {
        System.out.println("Album: " + name + " by " + artist+ libraryStatus()+"\n");
        for (Song song : songs) {
            System.out.println("- " + song.getName());
        }
        System.out.println();
    }
}

