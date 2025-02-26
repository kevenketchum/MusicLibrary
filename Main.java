import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicStore musicStore = new MusicStore();
        LibraryModel libraryModel = new LibraryModel(musicStore);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Music Library!");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Search for a song by title");
            System.out.println("2. Search for an album by title");
            System.out.println("3. Add a song to your library");
            System.out.println("4. Add an album to your library");
            System.out.println("5. Create a playlist");
            System.out.println("6. Add a song to a playlist");
            System.out.println("7. Rate a song");
            System.out.println("8. Search in your library");
            System.out.println("9. View your library");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter song title: ");
                    String songTitle = scanner.nextLine().trim();
                    System.out.println(musicStore.searchSongByTitle(songTitle));
                }
                case "2" -> {
                    System.out.print("Enter album title: ");
                    String albumTitle = scanner.nextLine().trim();
                    System.out.println(musicStore.searchAlbumByTitle(albumTitle));
                }
                case "3" -> {
                    System.out.print("Enter the song title to add: ");
                    String songTitle = scanner.nextLine().trim();
                    System.out.println(libraryModel.addSong(songTitle) ? "Song added to library." : "Song not found.");
                }
                case "4" -> {
                    System.out.print("Enter the album title to add: ");
                    String albumTitle = scanner.nextLine().trim();
                    System.out.println(libraryModel.addAlbum(albumTitle) ? "Album added to library." : "Album not found.");
                }
                case "5" -> {
                    System.out.print("Enter the name of the new playlist: ");
                    String playlistName = scanner.nextLine().trim();
                    libraryModel.addPlaylist(playlistName);
                    System.out.println("Playlist '" + playlistName + "' created.");
                }
                case "6" -> {
                    System.out.print("Enter the playlist name: ");
                    String playlistName = scanner.nextLine().trim();
                    System.out.print("Enter the song title to add: ");
                    String songTitle = scanner.nextLine().trim();
                    System.out.println(libraryModel.addSongToPlaylist(playlistName, songTitle) ? "Song added to playlist." : "Playlist or song not found.");
                }
                case "7" -> {
                    System.out.print("Enter the song title to rate: ");
                    String songTitle = scanner.nextLine().trim();
                    System.out.print("Enter a rating (1-5): ");
                    int rating = Integer.parseInt(scanner.nextLine().trim());
                    libraryModel.setRating(songTitle, rating);
                    System.out.println("Rating updated.");
                }
                case "8" -> {
                    System.out.println("Search your library by:");
                    System.out.println("1. Song title");
                    System.out.println("2. Album title");
                    System.out.print("Enter your choice: ");
                    String searchChoice = scanner.nextLine().trim();

                    if (searchChoice.equals("1")) {
                        System.out.print("Enter song title: ");
                        String songTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.musicLibrary.searchSongByTitle(songTitle));
                    } else if (searchChoice.equals("2")) {
                        System.out.print("Enter album title: ");
                        String albumTitle = scanner.nextLine().trim();
                        System.out.println(libraryModel.musicLibrary.searchAlbumByTitle(albumTitle));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
                case "9" -> {
                    System.out.println("\n--- Your Library ---");
                    System.out.println(libraryModel.getAllLibraryItems());
                }
                case "10" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }
}
