package music;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private final List<Song> musicLibrary;
    private final List<Album> albumList;
    private final List<Playlist> allPlaylists;

    public MusicLibrary() {
        this.musicLibrary = new ArrayList<>();
        this.albumList = new ArrayList<>();
        this.allPlaylists = new ArrayList<>();
    }

    public List<Song> getMusicLibrary() {
        return musicLibrary;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public List<Playlist> getAllPlaylists() {
        return allPlaylists;
    }

    public void addSong(Song song) {
        musicLibrary.add(song);
    }

    public void addAlbum(Album album) {
        albumList.add(album);
    }

    public void addPlaylist(Playlist playlist) {
        allPlaylists.add(playlist);
    }
}
