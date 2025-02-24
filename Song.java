package music;

public class Song {
    private final String name;
    private final String album;
    private final String author;
    private int rating;
    private boolean favorite;
    private boolean inLibrary;

    public Song(String name, String album, String author) {
        this.name = name;
        this.album = album;
        this.author = author;
        this.rating = 0;
        this.favorite = false;
        this.inLibrary = false;
    }

    public String getName() {
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

    public boolean isInLibrary() {
        return inLibrary;
    }

    public void setRating(int rate) {
        if (rate == 5) {
            setFavorite();
        }
        if (rate >= 1 && rate <= 5) {
            this.rating = rate;
        }
    }

    public void setFavorite() {
        this.favorite = true;
    }

    public void addToLibrary() {
        this.inLibrary = true;
    }

    public void printSong() {
        System.out.println(name + " by " + author + " from album " + album + " | Rating: " + rating + " | Favorite: " + favorite);
    }
}
