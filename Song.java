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
	public String getName() {
		return name;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getFavorite() {
		return favorite;
	}
	
	public void setRating(int rate) {
		if(rate >= 1 && rate <= 5) {
			rating = rate;
		}
	}
	
	public void setFavorite() {
		favorite = !favorite;
	}
	
	
	
}
