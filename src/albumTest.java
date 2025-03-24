import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class AlbumTest {
    
    @Test
    void testAlbumInitialization() {
        Album album = new Album("Test Album", "Test Artist");
        assertEquals("Test Album", album.getName());
        assertEquals("Test Artist", album.getArtist());
        assertFalse(album.isInLibrary());
    }

    @Test
    void testLibraryStatus() {
        Album album = new Album("Test Album", "Test Artist");
        assertEquals(" not currently on library", album.libraryStatus());
        album.addToLibrary();
        assertEquals(" It is currently on the library", album.libraryStatus());
    }

    @Test
    void testAddSong() {
        Album album = new Album("Test Album", "Test Artist");
        Song song1 = new Song("Song One", "Test Album", "Test Artist", "Pop");
        Song song2 = new Song("Song Two", "Test Album", "Test Artist", "Jazz");
        
        album.addSong(song1);
        album.addSong(song2);
        ArrayList<Song> songs = album.getSongs();
        assertEquals(2, songs.size());
        assertEquals("Song One", songs.get(0).getTitle());
        assertEquals("Song Two", songs.get(1).getTitle());
    }
}