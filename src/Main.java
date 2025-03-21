import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        // User authentication
        String username = null;
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println("1. Register\n2. Login\n3. quit\nChoose an option: ");
            String option = scanner.nextLine().trim();

            System.out.print("Enter username: ");
            username = scanner.nextLine().trim();
            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (option.equals("1")) {
                if (userManager.registerUser(username, password)) {
                    System.out.println("Registration successful. Please log in.");
                }
            } else if (option.equals("2")) {
                if (userManager.loginUser(username, password)) {
                    System.out.println("Login successful. Welcome, " + username + "!");
                    authenticated = true;
                } else {
                    System.out.println("Invalid username or password. Try again.");
                }
            } 
            else if(option.equals("3")) {
                System.out.println("Good Bye!.\n");
                System.exit(0);
            }
            else {
                System.out.println("Invalid option. Try again.");
            }
        }

        // Load user-specific library data
        LibraryDataManager libraryDataManager = new LibraryDataManager(username);

        // Prompt user for album directory
        System.out.print("Enter the path to the albums directory: ");
        String albumDirectory = scanner.nextLine().trim();

        List<String> albumFiles = getAlbumFiles(albumDirectory);
        MusicStore musicStore = new MusicStore(albumFiles);
        LibraryModel libraryModel = new LibraryModel(musicStore);

        // Load the user's saved library
        libraryModel.setMusicLibrary(libraryDataManager.loadLibrary());

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
            System.out.println("7. Play a song from your library");
            System.out.println("8. Create a playlist");
            System.out.println("9. Add or Remove a song to a playlist");
            System.out.println("10. Rate a song or add to favorites");
            System.out.println("11. Search in your library");
            System.out.println("12. View your library");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter song title: ");
                        String songTitle = scanner.nextLine().trim();
                        musicStore.searchSongByTitle(songTitle);
                        break;

                    case "2":
                        System.out.print("Enter album title: ");
                        String albumTitle = scanner.nextLine().trim();
                        musicStore.searchAlbumByTitle(albumTitle);
                        break;

                    case "3":
                        System.out.print("Enter artist name: ");
                        String artist = scanner.nextLine().trim();
                        musicStore.searchSongByArtist(artist);
                        break;

                    case "4":
                        System.out.print("Enter artist name: ");
                        artist = scanner.nextLine().trim();
                        musicStore.searchAlbumByArtist(artist);
                        break;

                    case "5":
                        System.out.print("Enter the song title to add: ");
                        songTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.addSong(songTitle) ? "Song added to library." : "Song not found.");
                        break;

                    case "6":
                        System.out.print("Enter the album title to add: ");
                        albumTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.addAlbum(albumTitle) ? "Album added to library." : "Album not found.");
                        break;

                    case "7":
                        System.out.print("Enter the song title to play: ");
                        String playTitle = scanner.nextLine().trim();
                        libraryModel.playSongfromLibrary(playTitle);
                        break;

                    case "8":
                        System.out.print("Enter the name of the new playlist: ");
                        String playlistName = scanner.nextLine().trim();
                        libraryModel.addPlaylist(playlistName);
                        System.out.println("Playlist '" + playlistName + "' created.");
                        break;

                    case "9":
                        System.out.print("Enter playlist name: ");
                        String plName = scanner.nextLine().trim();
                        System.out.print("Add or Remove a song? (a/r): ");
                        String action = scanner.nextLine().trim();
                        System.out.print("Enter song name: ");
                        String songName = scanner.nextLine().trim();
                        if (action.equalsIgnoreCase("a")) {
                            boolean added = libraryModel.addSongToPlaylist(plName, songName);
                            System.out.println(added ? "Song added to playlist." : "Failed to add song.");
                        } else if (action.equalsIgnoreCase("r")) {
                            libraryModel.removeSongFromPlaylist(plName, songName);
                        } else {
                            System.out.println("Invalid action.");
                        }
                        break;

                    case "10":
                        System.out.print("Enter song title: ");
                        String rateTitle = scanner.nextLine().trim();
                        System.out.print("Enter rating (1-5): ");
                        int rating = Integer.parseInt(scanner.nextLine().trim());
                        boolean rated = libraryModel.setRating(rateTitle, rating);
                        System.out.println(rated ? "Rating applied." : "Song not found.");

                        System.out.print("Would you like to mark it as favorite? (y/n): ");
                        String fav = scanner.nextLine().trim();
                        if (fav.equalsIgnoreCase("y")) {
                            boolean favResult = libraryModel.setFavorite(rateTitle);
                            System.out.println(favResult ? "Marked as favorite." : "Already favorite or song not found.");
                        }
                        break;

                    case "11":
                        System.out.println("Search Library by: 1) Title 2) Artist 3) Album");
                        String searchOption = scanner.nextLine().trim();
                        switch (searchOption) {
                            case "1":
                                System.out.print("Enter song title: ");
                                libraryModel.librarySearchSongByTitle(scanner.nextLine().trim());
                                break;
                            case "2":
                                System.out.print("Enter artist: ");
                                libraryModel.librarySearchSongByArtist(scanner.nextLine().trim());
                                break;
                            case "3":
                                System.out.print("Enter album: ");
                                libraryModel.librarySearchAlbumByTitle(scanner.nextLine().trim());
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                        break;

                    case "12":
                        System.out.println(libraryModel.getAllLibraryItems());
                        break;

                    case "13":
                        running = false;
                        System.out.println("Goodbye!");
                        libraryDataManager.saveLibrary(libraryModel.getMusicLibrary());
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
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
