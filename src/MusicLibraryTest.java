import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class MusicLibraryTest {
    @Test
    public void testAddSong() {
    	MusicLibrary library = new MusicLibrary();
    	Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
        library.addSong(song1);
        library.addSong(song2);

        List<Song> songs = library.getMusicLibrary();
        assertEquals(2, songs.size());
        assertTrue(songs.contains(song1));
        assertTrue(songs.contains(song2));
    }

    @Test
    public void testAddAlbum() {
    	MusicLibrary library = new MusicLibrary();
    	Album album1 = new Album("A Night at the Opera", "Queen");
        Album album2 = new Album("Imagine", "John Lennon");
        library.addAlbum(album1);
        library.addAlbum(album2);

        List<Album> albums = library.getAlbumList();
        assertEquals(2, albums.size());
        assertTrue(albums.contains(album1));
        assertTrue(albums.contains(album2));
    }

    @Test
    public void testAddPlaylist() {
    	MusicLibrary library = new MusicLibrary();
    	Playlist playlist1 = new Playlist("Rock Classics");
        Playlist playlist2 = new Playlist("Chill Vibes");
        library.addPlaylist(playlist1);
        library.addPlaylist(playlist2);

        List<Playlist> playlists = library.getAllPlaylists();
        assertEquals(2, playlists.size());
        assertTrue(playlists.contains(playlist1));
        assertTrue(playlists.contains(playlist2));
    }

    @Test
    public void testSearchSongByTitle() {
    	MusicLibrary library = new MusicLibrary();
        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
        
        library.addSong(song1);
        library.searchSongByTitle("Bohemian Rhapsody");
        library.searchSongByTitle("Nonexistent Song");
    }

    @Test
    public void testSearchAlbumByTitle() {
    	MusicLibrary library = new MusicLibrary();
    	Album album1 = new Album("A Night at the Opera", "Queen");

        library.addAlbum(album1);
        library.searchAlbumByTitle("A Night at the Opera");

        library.searchAlbumByTitle("Nonexistent Album");
    }

    @Test
    public void testSearchSongByArtist() {
    	MusicLibrary library = new MusicLibrary();
    	Song song1 = new Song("Oh My Love", "Imagine", "John Lennon");
        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
    	
        library.addSong(song1);
        library.addSong(song2);
        library.searchSongByArtist("John Lennon");
        
        library.searchSongByArtist("Nonexistent Artist");
    }

    @Test
    public void testSearchAlbumByArtist() {
    	MusicLibrary library = new MusicLibrary();
    	Album album1 = new Album("Double Fantasy", "John Lennon");
        Album album2 = new Album("Imagine", "John Lennon");
    	
        library.addAlbum(album1);
        library.addAlbum(album2);
        library.searchAlbumByArtist("John Lennon");

        library.searchAlbumByArtist("Nonexistent Artist");
    }

    @Test
    public void testGetPlaylist() {
    	MusicLibrary library = new MusicLibrary();
        Playlist playlist1 = new Playlist("Rock Classics");

        library.addPlaylist(playlist1);
        Playlist result = library.getPlaylist("Rock Classics");
        assertEquals(playlist1, result);

        result = library.getPlaylist("Nonexistent Playlist");
        assertNull(result);
    }

    @Test
    public void testGetPlaylistInfo() {
    	MusicLibrary library = new MusicLibrary();
        Playlist playlist1 = new Playlist("Rock Classics");
    	
        library.addPlaylist(playlist1);
        library.getPlaylistInfo("Rock Classics");
        library.getPlaylistInfo("Nonexistent Playlist");
    }
}
