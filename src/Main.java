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
            System.out.println("1. Register\n2. Login\nChoose an option: ");
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
            } else {
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
            System.out.println("7. Create a playlist");
            System.out.println("8. Add or Remove a song to a playlist");
            System.out.println("9. Rate a song or add to favorites");
            System.out.println("10. Search in your library");
            System.out.println("11. View your library");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

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
                    System.out.print("Enter the name of the new playlist: ");
                    String playlistName = scanner.nextLine().trim();
                    libraryModel.addPlaylist(playlistName);
                    System.out.println("Playlist '" + playlistName + "' created.");
                    break;

                case "8":
                    System.out.println("Feature not implemented yet.");
                    break;

                case "9":
                    System.out.println("Feature not implemented yet.");
                    break;

                case "10":
                    System.out.println("Feature not implemented yet.");
                    break;

                case "11":
                    System.out.println("Feature not implemented yet.");
                    break;
                    
                case "12":
                    running = false;
                    System.out.println("Goodbye!");
                    // Save user library data before exiting
                    libraryDataManager.saveLibrary(libraryModel.getMusicLibrary());
                    break;
                    
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
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
