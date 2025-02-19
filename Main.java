package music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instantiate the MusicStore and LibraryModel.
        // (Assuming you have constructors or placeholder implementations.)
        MusicStore musicStore = new MusicStore();
        LibraryModel libraryModel = new LibraryModel(musicStore);
        
        // Create a Scanner for user input.
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        System.out.println("Welcome to the Music Library!");
        
        while (running) {
            // Display menu options.
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Search for a song by title");
            System.out.println("2. Search for an album by title");
            System.out.println("3. Add a song to your library");
            System.out.println("4. Add an album to your library");
            System.out.println("5. View your library");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter song title: ");
                    String songTitle = scanner.nextLine().trim();
                    String result = musicStore.searchSongByTitle(songTitle);
                    System.out.println(result != null ? result : "Song not found.");
                }
                case "2" -> {
                    System.out.print("Enter album title: ");
                    String albumTitle = scanner.nextLine().trim();
                    String result = musicStore.searchAlbumByTitle(albumTitle);
                    System.out.println(result != null ? result : "Album not found.");
                }
                case "3" -> {
                    System.out.print("Enter the song title to add: ");
                    String songTitle = scanner.nextLine().trim();
                    boolean added = libraryModel.addSong(songTitle);
                    System.out.println(added ? "Song added to library." : "Song could not be added.");
                }
                case "4" -> {
                    System.out.print("Enter the album title to add: ");
                    String albumTitle = scanner.nextLine().trim();
                    boolean added = libraryModel.addAlbum(albumTitle);
                    System.out.println(added ? "Album added to library." : "Album could not be added.");
                }
                case "5" -> {
                    System.out.println("\n--- Your Library ---");
                    System.out.println(libraryModel.getAllLibraryItems());
                }
                case "6" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
        
        scanner.close();
    }
}
