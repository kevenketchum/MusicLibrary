package music;

import java.util.ArrayList;
import java.util.List;

public class MusicStore {
    private final List<Album> albums;

    public MusicStore() {
        this.albums = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public String searchSongByTitle(String title) {
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                    return song.getName() + " by " + song.getAuthor() + " from album " + song.getAlbum();
                }
            }
        }
        return "Song not found.";
    }

    public String searchAlbumByTitle(String title) {
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(title)) {
                return "Album: " + album.getName() + " by " + album.getArtist();
            }
        }
        return "Album not found.";
    }
}

