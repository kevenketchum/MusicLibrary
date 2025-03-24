import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
class MusicStoreTest {
    
    @Test
    void testAddAlbum() {
        MusicStore store = new MusicStore();
        Album album = new Album("Test Album", "Test Artist");
        store.addAlbum(album);
        assertEquals(1, store.getAlbums().size());
    }

    @Test
    void testGetSongByTitle() {
        MusicStore store = new MusicStore();
        Album album = new Album("Test Album", "Test Artist");
        Song song = new Song("Test Song", "Test Album", "Test Artist", "Rock");
        album.addSong(song);
        store.addAlbum(album);
        assertEquals(song, store.getSongByTitle("Test Song"));
        assertNull(store.getSongByTitle("Nonexistent Song"));
    }

    @Test
    void testSearchSongByGenre() {
        MusicStore store = new MusicStore();
        store.searchSongByGenre("Rock");
        store.searchSongByGenre("");
    }

    @Test
    void testSearchAlbumByTitle() {
        MusicStore store = new MusicStore();
        store.searchAlbumByTitle("Test Album");
        store.searchAlbumByTitle("");
    }

    @Test
    void testSearchAlbumByArtist() {
        MusicStore store = new MusicStore();
        store.searchAlbumByArtist("Test Artist");
        store.searchAlbumByArtist("");
    }

    @Test
    void testSearchSongByArtist() {
        MusicStore store = new MusicStore();
        store.searchSongByArtist("Test Artist");
        store.searchSongByArtist("");
    }
}