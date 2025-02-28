import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;


public class MusicStoreTest {
	    @Test
	    public void testAddAlbum() {
	    	MusicStore store = new MusicStore();

	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");

	        Album album1 = new Album("A Night at the Opera", "Queen");
	        album1.addSong(song1);


	        Album album2 = new Album("Imagine", "John Lennon");
	        album2.addSong(song2);

	        store.addAlbum(album1);
	        store.addAlbum(album2);
	        
	        List<Album> albums = store.getAlbums();
	        assertEquals(2, albums.size());
	        assertTrue(albums.contains(album1));
	        assertTrue(albums.contains(album2));
	    }

	    @Test
	    public void testSearchSongByTitle() {
	    MusicStore store = new MusicStore();
        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
        Album album1 = new Album("A Night at the Opera", "Queen");
        album1.addSong(song1);

        store.addAlbum(album1);
        
	    store.searchSongByTitle("bohemian rhapsody");
	    store.searchSongByTitle("Nonexistent Song");
	    }

	    @Test
	    public void testSearchAlbumByTitle() {
	    	MusicStore store = new MusicStore();
	    	Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");

	        Album album1 = new Album("A Night at the Opera", "Queen");
	        album1.addSong(song1);
	        
	        store.addAlbum(album1);


	        store.searchAlbumByTitle("A Night at the Opera");
	        store.searchAlbumByTitle("Nonexistent Album");
	    }

	    @Test
	    public void testSearchSongByArtist() {
	    	MusicStore store = new MusicStore();

	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Don't Stop Me Now", "Jazz", "Queen");
	        Song song3 = new Song("Imagine", "Imagine", "John Lennon");


	        Album album1 = new Album("A Night at the Opera", "Queen");
	        album1.addSong(song1);


	        Album album2 = new Album("Jazz", "Queen");
	        album2.addSong(song2);

	        Album album3 = new Album("Imagine", "John Lennon");
	        album3.addSong(song3);

	        store.addAlbum(album1);
	        store.addAlbum(album2);
	        store.addAlbum(album3);
	        
	        store.searchSongByArtist("Queen");

	        store.searchSongByArtist("John Lennon");

	        store.searchSongByArtist("Nonexistent Artist");
	    }

	    @Test
	    public void testSearchAlbumByArtist() {
	    	MusicStore store = new MusicStore();

	        Album album1 = new Album("A Night at the Opera", "Queen");
	        Album album2 = new Album("Jazz", "Queen");
	        Album album3 = new Album("Imagine", "John Lennon");

	        store.addAlbum(album1);
	        store.addAlbum(album2);
	        store.addAlbum(album3);

	        store.searchAlbumByArtist("Queen");
	        store.searchAlbumByArtist("John Lennon");
	        store.searchAlbumByArtist("Nonexistent Artist");
	    }
}
