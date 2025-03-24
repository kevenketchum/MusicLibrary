import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class SongTest {
    
    @Test
    void testSongInitialization() {
        Song song = new Song("Test Song", "Test Album", "Test Author", "Rock");
        assertEquals("Test Song", song.getTitle());
        assertEquals("Test Album", song.getAlbum());
        assertEquals("Test Author", song.getAuthor());
        assertEquals("Rock", song.getGenre());
        assertEquals(0, song.getRating());
        assertFalse(song.isFavorite());
        assertEquals(0, song.getFrequency());
    }

    @Test
    void testSetRating() {
        Song song = new Song("Test Song", "Test Album", "Test Author", "Rock");
        song.setRating(3);
        assertEquals(3, song.getRating());
        assertFalse(song.isFavorite());

        song.setRating(5);
        assertEquals(5, song.getRating());
        assertTrue(song.isFavorite());
    }

    @Test
    void testPlaySong() {
        Song song = new Song("Test Song", "Test Album", "Test Author", "Rock");
        song.playSong();
        assertEquals(1, song.getFrequency());
    }

    @Test
    void testFavoriteToggle() {
        Song song = new Song("Test Song", "Test Album", "Test Author", "Rock");
        song.setFavorite();
        assertTrue(song.isFavorite());
        song.unFavorite();
        assertFalse(song.isFavorite());
    }
    
    @Test
    void testPrintItem() {
    	Song song = new Song("Test Song", "Test Album", "Test Author", "Rock");
    	song.printItem();
    }
}