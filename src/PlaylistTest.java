import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class PlaylistTest {
    
    @Test
    void testPlaylistInitialization() {
        Playlist playlist = new Playlist("My Playlist");
        assertEquals("My Playlist", playlist.getName());
        assertTrue(playlist.getSongs().isEmpty());
    }

    @Test
    void testAddSong() {
        Playlist playlist = new Playlist("My Playlist");
        Song song = new Song("New Song", "Album", "Artist", "Genre");
        playlist.addSong(song);
        assertEquals(1, playlist.getSongs().size());
        assertEquals("New Song", playlist.getSongs().get(0).getTitle());
    }

    @Test
    void testRemoveFirstSong() {
        Playlist playlist = new Playlist("My Playlist");
        Song song1 = new Song("Song1", "Album", "Artist", "Genre");
        Song song2 = new Song("Song2", "Album", "Artist", "Genre");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.removeFirstSong();
        assertEquals(1, playlist.getSongs().size());
        assertEquals("Song2", playlist.getSongs().get(0).getTitle());
    }

    @Test
    void testRemoveSongByTitle() {
        Playlist playlist = new Playlist("My Playlist");
        Song song = new Song("Song1", "Album", "Artist", "Genre");
        playlist.addSong(song);
        assertTrue(playlist.removeSong("Song1"));
        assertFalse(playlist.removeSong("Nonexistent Song"));
    }

    @Test
    void testReplacePlaylist() {
        Playlist playlist = new Playlist("My Playlist");
        Song song1 = new Song("Song1", "Album", "Artist", "Genre");
        Song song2 = new Song("Song2", "Album", "Artist", "Genre");
        ArrayList<Song> newSongs = new ArrayList<>();
        newSongs.add(song1);
        newSongs.add(song2);
        playlist.replacePlaylist(newSongs);
        assertEquals(2, playlist.getSongs().size());
        assertEquals("Song1", playlist.getSongs().get(0).getTitle());
    }
    
    @Test
    void testPrintItem() {
    	Playlist playlist = new Playlist("My Playlist");
        Song song1 = new Song("Song1", "Album", "Artist", "Genre");
        Song song2 = new Song("Song2", "Album", "Artist", "Genre");
        ArrayList<Song> newSongs = new ArrayList<>();
        newSongs.add(song1);
        newSongs.add(song2);
        playlist.replacePlaylist(newSongs);
        playlist.printItem();
    	
    }
}