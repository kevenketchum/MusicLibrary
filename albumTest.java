import static org.junit.jupiter.api.Assertions.*;

public class albumTest {

    @Test
    void testInitialization() {
    	Album album = new Album("Thriller", "Michael Jackson");
    	Song song1 = new Song("Billie Jean", "Thriller", "Michael Jackson");
        Song song2 = new Song("Beat It", "Thriller", "Michael Jackson");
        assertEquals("Thriller", album.getName());
        assertEquals("Michael Jackson", album.getArtist());
        assertFalse(album.isInLibrary());
        assertTrue(album.getSongs().isEmpty());
    }

    @Test
    void testAddToLibrary() {
    	Album album = new Album("Thriller", "Michael Jackson");
        assertFalse(album.isInLibrary());
        album.addToLibrary();
        assertTrue(album.isInLibrary());
    }

    @Test
    void testRemoveFromLibrary() {
    	Album album = new Album("Thriller", "Michael Jackson");
        album.addToLibrary();
        assertTrue(album.isInLibrary());

        album.removeFromLibrary();
        assertFalse(album.isInLibrary());
    }

    @Test
    void testAddSong() {
    	Album album = new Album("Thriller", "Michael Jackson");
    	Song song1 = new Song("Billie Jean", "Thriller", "Michael Jackson");
        Song song2 = new Song("Beat It", "Thriller", "Michael Jackson");
        album.addSong(song1);
        album.addSong(song2);
        
        List<Song> songs = album.getSongs();
        assertEquals("Billie Jean", songs.get(0).getName());
        assertEquals("Beat It", songs.get(1).getName());
    }
}
