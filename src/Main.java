import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for album directory
        System.out.print("Enter the path to the albums directory: ");
        String albumDirectory = scanner.nextLine().trim();
        
        List<String> albumFiles = getAlbumFiles(albumDirectory);
        MusicStore musicStore = new MusicStore(albumFiles);
        LibraryModel libraryModel = new LibraryModel(musicStore);

        boolean running = true;

        System.out.println("Welcome to the Music Library!");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Search for a song by title");
            System.out.println("2. Search for an album by title");
            System.out.println("3. Search for a song by artist");
            System.out.println("4. Search for an album by artist");
            System.out.println("5. Add a song to your library");
            System.out.println("6. Add an album to your library");
            System.out.println("7. Create a playlist");
            System.out.println("8. Add or Remove a song to a playlist");
            System.out.println("9. Rate a song or add to favorites");
            System.out.println("10. Search in your library");
            System.out.println("11. View your library");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter song title: ");
                    String songTitle = scanner.nextLine().trim();
                    musicStore.searchSongByTitle(songTitle);
                }
                case "2" -> {
                    System.out.print("Enter album title: ");
                    String albumTitle = scanner.nextLine().trim();
                    musicStore.searchAlbumByTitle(albumTitle);
                }
                case "3" -> {
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine().trim();
                    musicStore.searchSongByArtist(artist);
                }
                case "4" -> {
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine().trim();
                    musicStore.searchAlbumByArtist(artist);
                }
                case "5" -> {
                    System.out.print("Enter the song title to add: ");
                    String songTitle = scanner.nextLine().trim();
                    System.out.println(libraryModel.addSong(songTitle) ? "Song added to library." : "Song not found."); // return song addeed to library if true song not found otherwise
                }
                case "6" -> {
                    System.out.print("Enter the album title to add: ");
                    String albumTitle = scanner.nextLine().trim();
                    System.out.println(libraryModel.addAlbum(albumTitle) ? "Album added to library." : "Album not found."); // return album added to library if true album not found otherwise
                }
                case "7" -> {
                    System.out.print("Enter the name of the new playlist: ");
                    String playlistName = scanner.nextLine().trim();
                    libraryModel.addPlaylist(playlistName);
                    System.out.println("Playlist '" + playlistName + "' created.");
                }
                case "8" -> {
                    System.out.println("1. Add a Song");
                    System.out.println("2. Remove a Song");
                    String addOrRemove = scanner.nextLine().trim();
                    if(addOrRemove.equals("1")) {
                        System.out.print("Enter the playlist name: ");
                        String playlistName = scanner.nextLine().trim();
                        System.out.print("Enter the song title to add: ");
                        String songTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.addSongToPlaylist(playlistName, songTitle) ? "Song added to playlist." : "Playlist or song not found."); // return song added to playlist if true
                    } else if(addOrRemove.equals("2")) {
                        System.out.print("Enter the playlist name: ");
                        String playlistName = scanner.nextLine().trim();
                        System.out.print("Enter the song title to remove: ");
                        String songTitle = scanner.nextLine().trim();
                        libraryModel.removeSongFromPlaylist(playlistName, songTitle);
                    }
                }
                case "9" -> {
                    System.out.println("1. Rate a Song");
                    System.out.println("2. Set song as favorite");
                    String rateOrFav = scanner.nextLine().trim();
                    if(rateOrFav.equals("1")) {
                        System.out.print("Enter the song title to rate: ");
                        String songTitle = scanner.nextLine().trim();
                        System.out.print("Enter a rating (1-5): ");
                        int rating = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println(libraryModel.setRating(songTitle, rating) ? "Rating updated." : "Song not found or invalid rating.");
                    } else if(rateOrFav.equals("2")) {
                        System.out.print("Enter the song title to add to favorites: ");
                        String songTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.setFavorite(songTitle) ? "Song added to favorites." : "Song not found or already a favorite.");
                    }
                }
                case "10" -> {
                    System.out.println("Search your library by:");
                    System.out.println("1. Song title");
                    System.out.println("2. Album title");
                    System.out.println("3. Playlist name");
                    System.out.print("Enter your choice: ");
                    String searchChoice = scanner.nextLine().trim();

                    if (searchChoice.equals("1")) {
                        System.out.print("Enter song title: ");
                        String songTitle = scanner.nextLine().trim();
                        libraryModel.librarySearchSongByTitle(songTitle);
                    } else if (searchChoice.equals("2")) {
                        System.out.print("Enter album title: ");
                        String albumTitle = scanner.nextLine().trim();
                        libraryModel.librarySearchAlbumByTitle(albumTitle);
                    } else if (searchChoice.equals("3")) {
                        System.out.print("Enter Playlist name: ");
                        String playlistName = scanner.nextLine().trim();
                        libraryModel.getPlaylistInfo(playlistName);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
                case "11" -> {
                    System.out.println("\n--- Your Library ---");
                    System.out.println(libraryModel.getAllLibraryItems());
                }
                case "12" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }

    private static List<String> getAlbumFiles(String directoryPath) {
        List<String> albumFiles = new ArrayList<>();
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    albumFiles.add(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("ERROR: Albums directory not found!");
        }
        return albumFiles;
    }
}