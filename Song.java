public class Song{
	//Instance variables
	final private String name;
	final private String album;
	final private String author;
	private int rating;
	private boolean favorite;
	
	//Constructor
	public Song(String name, String album, String author) {
		this.name = name;
		this.album = album;
		this.author = author;
		rating = 0;
		favorite = false;
	}
	
	//Getters/Setters
	String getName() {
		return name;
	}
	
	String getAlbum() {
		return album;
	}
	
	String getAuthor() {
		return author;
	}
	
	String getRating() {
		return rating;
	}
	
	String getFavorite() {
		return favorite;
	}
	
	void setRating(int rate) {
		if(rate >= 1 && rate <= 5) {
			rating = rate;
		}
	}
	
	void setFavorite() {
		favorite = !favorite;
	}
	
	
	
}