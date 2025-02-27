import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class PlaylistTest {

	    @Test
	    void testInitialization() {
	    	Playlist playlist = new Playlist("My Favorites");
	        assertEquals("My Favorites", playlist.getName());
	        assertTrue(playlist.getSongs().isEmpty());
	    }

	    @Test
	    void testAddSong() {
	    	Playlist playlist = new Playlist("My Favorites");
	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
	        playlist.addSong(song1);
	        playlist.addSong(song2);

	        List<Song> songs = playlist.getSongs();
	        assertEquals(2, songs.size());
	        assertEquals("Bohemian Rhapsody", songs.get(0).getName());
	        assertEquals("Imagine", songs.get(1).getName());
	    }

	    @Test
	    void testRemoveSong() {
	    	Playlist playlist = new Playlist("My Favorites");
	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
	        Song song3 = new Song("Stairway to Heaven", "Led Zeppelin IV", "Led Zeppelin");
	        playlist.addSong(song1);
	        playlist.addSong(song2);
	        playlist.addSong(song3);

	        playlist.removeSong("Imagine");

	        List<Song> songs = playlist.getSongs();
	        assertEquals(2, songs.size());
	        assertFalse(songs.contains(song2));
	        assertTrue(songs.contains(song1));
	        assertTrue(songs.contains(song3));
	    }

	    @Test
	    void testRemoveSongCaseInsensitive() {
	    	Playlist playlist = new Playlist("My Favorites");
	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
	        playlist.addSong(song1);
	        playlist.addSong(song2);

	        playlist.removeSong("imagine");

	        List<Song> songs = playlist.getSongs();
	        assertEquals(1, songs.size());
	        assertFalse(songs.contains(song2));
	    }

	    @Test
	    void testRemoveNonExistingSong() {
	    	Playlist playlist = new Playlist("My Favorites");
	        Song song1 = new Song("Bohemian Rhapsody", "A Night at the Opera", "Queen");
	        Song song2 = new Song("Imagine", "Imagine", "John Lennon");
	        playlist.addSong(song1);
	        playlist.addSong(song2);

	        playlist.removeSong("Song");

	        List<Song> songs = playlist.getSongs();
	        assertEquals(2, songs.size());
	    }
}
