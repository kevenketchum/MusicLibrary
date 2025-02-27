import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
public class SongTest {

    @Test
    void testInitializer() {
    	Song song = new Song("name", "album", "author");
        assertEquals("name", song.getName());
        assertEquals("album", song.getAlbum());
        assertEquals("author", song.getAuthor());
        assertEquals(0, song.getRating());
        assertFalse(song.isFavorite());
        assertFalse(song.isInLibrary());
    }

    @Test
    void testSetRating() {
    	Song song = new Song("name", "album", "author");
    	//Valid inputs
        song.setRating(3);
        assertEquals(3, song.getRating());
        assertFalse(song.isFavorite());

        song.setRating(5);
        assertEquals(5, song.getRating());
        assertTrue(song.isFavorite());
        
        //Invalid inputs
        song.setRating(6);
        assertNotEquals(6, song.getRating());
        assertEquals(5, song.getRating());
        
        song.setRating(0);
        assertNotEquals(0, song.getRating());
        assertEquals(5, song.getRating());
    }


    @Test
    void testSetFavorite() {
    	Song song = new Song("name", "album", "author");
        assertFalse(song.isFavorite());
        song.setFavorite();
        assertTrue(song.isFavorite());
        
    }

    @Test
    void testAddToLibrary() {
    	Song song = new Song("name", "album", "author");
        assertFalse(song.isInLibrary());
        song.addToLibrary();
        assertTrue(song.isInLibrary());
    }

}
