package music;

public class LibraryModel {
    private final MusicStore musicStore;
    private final MusicLibrary musicLibrary;

    public LibraryModel(MusicStore musicStore) {
        this.musicStore = musicStore;
        this.musicLibrary = new MusicLibrary();
    }

    public boolean addSong(String title) {
        for (Album album : musicStore.albums) {
            for (Song song : album.getSongs()) {
                if (song.getName().equalsIgnoreCase(title)) {
                    song.addToLibrary();
                    musicLibrary.addSong(song);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAlbum(String title) {
        for (Album album : musicStore.albums) {
            if (album.getName().equalsIgnoreCase(title)) {
                album.addToLibrary();
                musicLibrary.addAlbum(album);
                return true;
            }
        }
        return false;
    }

    public String getAllLibraryItems() {
        StringBuilder sb = new StringBuilder();
        for (Song song : musicLibrary.getMusicLibrary()) {
            song.printSong();
        }
        for (Album album : musicLibrary.getAlbumList()) {
            album.printItem();
        }
        for (Playlist playlist : musicLibrary.getAllPlaylists()) {
            playlist.printItem();
        }
        return sb.toString();
    }
}

