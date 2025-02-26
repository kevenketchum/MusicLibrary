import static org.junit.jupiter.api.Assertions.*;


public class MusicStoreTest {
	    @Test
	    void testAddAlbum() {
	    	MusicStore store = new MusicStore();

	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");

	        List<Song> album1Songs = new ArrayList<>();
	        album1Songs.add(song1);
	        Album album1 = new Album("A Night at the Opera", "Queen", album1Songs);

	        List<Song> album2Songs = new ArrayList<>();
	        album2Songs.add(song2);
	        Album album2 = new Album("Imagine", "John Lennon", album2Songs);

	        store.addAlbum(album1);
	        store.addAlbum(album2);
	        
	        List<Album> albums = store.getAlbums();
	        assertEquals(2, albums.size());
	        assertTrue(albums.contains(album1));
	        assertTrue(albums.contains(album2));
	    }

	    @Test
	    void testSearchSongByTitle() {MusicStore store = new MusicStore();
        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
        List<Song> album1Songs = new ArrayList<>();
        album1Songs.add(song1);
        Album album1 = new Album("A Night at the Opera", "Queen", album1Songs);

        store.addAlbum(album1);
        
	    store.searchSongByTitle("Bohemian Rhapsody");
	    store.searchSongByTitle("Nonexistent Song");
	    }

	    @Test
	    void testSearchAlbumByTitle() {
	    	Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        List<Song> album1Songs = new ArrayList<>();
	        album1Songs.add(song1);
	        Album album1 = new Album("A Night at the Opera", "Queen", album1Songs);
	        
	        store.addAlbum(album1);


	        store.searchAlbumByTitle("A Night at the Opera");
	        store.searchAlbumByTitle("Nonexistent Album");
	    }

	    @Test
	    void testSearchSongByArtist() {
	    	MusicStore store = new MusicStore();

	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Don't Stop Me Now", "Jazz", "Queen");
	        Song song3 = new Song("Imagine", "Imagine", "John Lennon");

	        List<Song> album1Songs = new ArrayList<>();
	        album1Songs.add(song1);
	        Album album1 = new Album("A Night at the Opera", "Queen", album1Songs);

	        List<Song> album2Songs = new ArrayList<>();
	        album2Songs.add(song2);
	        Album album2 = new Album("Jazz", "Queen", album2Songs);

	        List<Song> album3Songs = new ArrayList<>();
	        album3Songs.add(song3);
	        Album album3 = new Album("Imagine", "John Lennon", album3Songs);

	        store.addAlbum(album1);
	        store.addAlbum(album2);
	        store.addAlbum(album3);
	        
	        store.searchSongByArtist("Queen");

	        store.searchSongByArtist("John Lennon");

	        store.searchSongByArtist("Nonexistent Artist");
	    }

	    @Test
	    void testSearchAlbumByArtist() {
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
