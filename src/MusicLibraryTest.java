import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;

class MusicLibraryTest {

    @Test
    void testAddSong() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song = new Song("Song 4", "Album 3", "Artist 3", "Pop");
        musicLibrary.addSong(song);
        assertEquals(1, musicLibrary.getMusicLibrary().size());
    }

    @Test
    void testRemoveSong() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        musicLibrary.addSong(song);
        musicLibrary.removeSong(song);
        assertFalse(musicLibrary.getMusicLibrary().contains(song));
    }

    @Test
    void testAddAlbum() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Album album = new Album("Album 3", "Artist 3");
        musicLibrary.addAlbum(album);
        assertEquals(1, musicLibrary.getAlbumList().size());
    }

    @Test
    void testRemoveAlbum() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Album album = new Album("Album 1", "Artist 1");
        musicLibrary.addAlbum(album);
        musicLibrary.removeAlbum(album);
        assertFalse(musicLibrary.getAlbumList().contains(album));
    }

    @Test
    void testSearchSongByTitleFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        musicLibrary.addSong(song);
        musicLibrary.searchSongByTitle("Song 1");
        // Verify that song details are printed
    }

    @Test
    void testSearchSongByTitleNotFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        musicLibrary.searchSongByTitle("Nonexistent Song");
        // Assert that the song is not found in the library.
    }

    @Test
    void testSearchAlbumByTitleFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Album album = new Album("Album 1", "Artist 1");
        musicLibrary.addAlbum(album);
        musicLibrary.searchAlbumByTitle("Album 1");
        // Verify album details are printed
    }

    @Test
    void testSearchAlbumByTitleNotFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        musicLibrary.searchAlbumByTitle("Nonexistent Album");
        // Assert that the album is not found
    }

    @Test
    void testSearchSongByArtistFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        musicLibrary.addSong(song);
        musicLibrary.searchSongByArtist("Artist 1");
        // Verify songs by Artist 1 are printed
    }

    @Test
    void testSearchSongByArtistNotFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        musicLibrary.searchSongByArtist("Nonexistent Artist");
        // Assert that no songs are found
    }

    @Test
    void testSearchAlbumByArtistFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Album album = new Album("Album 1", "Artist 1");
        musicLibrary.addAlbum(album);
        musicLibrary.searchAlbumByArtist("Artist 1");
        // Verify albums by Artist 1 are printed
    }

    @Test
    void testSearchAlbumByArtistNotFound() {
        MusicLibrary musicLibrary = new MusicLibrary();
        musicLibrary.searchAlbumByArtist("Nonexistent Artist");
        // Assert that no albums are found
    }

    @Test
    void testGetPlaylist() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Playlist recentPlaylist = new Playlist("recently played");
        musicLibrary.addPlaylist(recentPlaylist);
        assertNotNull(musicLibrary.getPlaylist("recently played"));
    }

    @Test
    void testGetPlaylistInfo() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Playlist recentPlaylist = new Playlist("recently played");
        musicLibrary.addPlaylist(recentPlaylist);
        musicLibrary.getPlaylistInfo("recently played");
        // Verify that the playlist info is printed
    }

    @Test
    void testUpdateGenre() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song1 = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        Song song2 = new Song("Song 2", "Album 1", "Artist 1", "Pop");
        musicLibrary.addSong(song1);
        musicLibrary.addSong(song2);
        musicLibrary.updateGenre();
        // Check that playlists by genre have been created/updated
    }

    @Test
    void testUpdateFavorites() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song1 = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        song1.setFavorite();
        musicLibrary.addSong(song1);
        musicLibrary.updateFavorites();
        // Verify that the favorites playlist has been updated
    }

    @Test
    void testUpdateTop() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song1 = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        song1.setRating(5);
        musicLibrary.addSong(song1);
        musicLibrary.updateTop();
        // Verify the top-rated playlist has been updated with the correct songs
    }

    @Test
    void testUpdateRecent() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Song song1 = new Song("Song 1", "Album 1", "Artist 1", "Rock");
        Playlist recentPlaylist = new Playlist("recently played");
        musicLibrary.addPlaylist(recentPlaylist);
        musicLibrary.updateRecent(song1);
        assertEquals(0, recentPlaylist.getSongs().size());
    }

    @Test
    void testUpdateFrequent() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Playlist frequentPlaylist = new Playlist("frequently played");
        musicLibrary.addPlaylist(frequentPlaylist);
        musicLibrary.updateFrequent();
        // Verify frequent playlist has been updated
    }
    
    /*

    @Test
    void testGetTopFrequent() {
        MusicLibrary musicLibrary = new MusicLibrary();
        ArrayList<Song> topFrequent = musicLibrary.getTopFrequent();
        assertEquals(10, topFrequent.size());
    }

    @Test
    void testGetTopGenre() {
        MusicLibrary musicLibrary = new MusicLibrary();
        ArrayList<String> topGenres = musicLibrary.getTopGenre(new HashMap<String, Integer>());
        assertTrue(topGenres.size() <= 10);
    }

    @Test
    void testGetGenreSongs() {
        MusicLibrary musicLibrary = new MusicLibrary();
        ArrayList<Song> genreSongs = musicLibrary.getGenreSongs("Pop");
        assertTrue(genreSongs.size() >= 0);
    }

    @Test
    void testGenrePlaylistExits() {
        MusicLibrary musicLibrary = new MusicLibrary();
        Playlist existingPlaylist = musicLibrary.genrePlaylistExits("Rock");
        assertNull(existingPlaylist);
    }

    @Test
    void testSortByPlays() {
        MusicLibrary musicLibrary = new MusicLibrary();
        ArrayList<Song> sortedSongs = musicLibrary.sortByPlays(new ArrayList<Song>());
        // Verify that the songs are sorted by frequency in descending order
    }
    */
}
