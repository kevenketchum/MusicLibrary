

/* 
 * Class Song.java, Parameters: name, album, author, rating, favorite, inLibrary
 * Creates Object Song with a name, author, which album its from, user's rating, is favorite? and inLibrary?
 * Speacial characteristics: If a song has a ratinng of 5 it automatically becomes a favorite, can add a song to user library,
 * and prints()
 * */

public class Song extends LibraryItem {
	
	//Instance Variables
    private final String album;
    private final String author;
    private int rating;
    private boolean favorite;
    private int frequency;
    private final String genre;
    
    //Song Object Initializer
    public Song(String name, String album, String author, String genre) {
        super(name);
        this.album = album;
        this.author = author;
        this.rating = 0;
        this.favorite = false;
        this.frequency = 0;
        this.genre = genre;
    }

    //Getters/Setters

    public String getGenre() {
    	return genre;
    }
    
    public String getTitle() {
    	return name;
    }
    
    public String getAlbum() {
        return album;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public boolean isFavorite() {
        return favorite;
    }
    
    public int getFrequency() {
    	return frequency;
    }
    
    public void playSong() {
    	frequency += 1;
    	System.out.println("Currently playing: "+this.name+"\n");
    }


    //If rating is 5 automatically set to favorites
    public void setRating(int rate) {
        if (rate == 5) {
            setFavorite();
            this.rating = rate;
        }
        if (rate >= 1 && rate < 5) {
        	unFavorite();
            this.rating = rate;
        }
    }

    public void setFavorite() {
        this.favorite = true;
    }
    
    public void unFavorite() {
    	this.favorite = false;
    }


    public void printItem() {
        System.out.println(name + " by " + author + " from album " + album + " | Rating: " + rating + " | Favorite: " + favorite);
    }
}
