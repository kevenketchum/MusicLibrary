import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * LibraryDataManager Class
 * 
 * This class is responsible for managing user-specific music library data.
 * It allows saving and loading a user's favorite songs, ratings, and playlist details
 * in a JSON file named after the user (e.g., "username_library.json").
 */

public class LibraryDataManager {
    private final String filePath; // Path to the user's library file

    /**
     * Constructs a LibraryDataManager instance for a specific user.
     * The user's library is stored in "username_library.json".
     * 
     * @param username The username associated with the library file.
     */

    public LibraryDataManager(String username) {
        this.filePath = username + "_library.json";
    }

    /**
     * Loads the user's saved music library from a JSON file.
     * If the file does not exist, an empty list is returned.
     * 
     * @return A list of Song objects representing the user's saved songs.
     */
    public List<Song> loadLibrary() {
        List<Song> songs = new ArrayList<>();
        
        try {
            File file = new File(filePath);
            if (!file.exists()) return songs; // Return empty list if no saved data

            // Read file contents as a UTF-8 string
            String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(content);

            // Extract song list from JSON data
            JSONArray songArray = json.getJSONArray("songs");
            for (int i = 0; i < songArray.length(); i++) {
                JSONObject songObj = songArray.getJSONObject(i);

                // Create a song object from JSON data
                Song song = new Song(
                    songObj.getString("name"),
                    songObj.getString("album"),
                    songObj.getString("artist"),
                    songObj.getString("genre")
                );
              
                song.setRating(songObj.getInt("rating")); // Set song rating
                if (songObj.getBoolean("favorite")) {
                    song.setFavorite(); // Mark song as favorite if applicable
                }
                songs.add(song);
            }
        } catch (Exception e) {
            System.out.println("Error loading library: " + e.getMessage());
        }
        return songs;
    }

    /**
     * Saves the user's current music library to a JSON file.
     * This function stores each song's name, album, artist, genre, rating, and favorite status.
     * 
     * @param songs The list of songs to be saved.
     */
    public void saveLibrary(List<Song> songs) {
        try (FileWriter writer = new FileWriter(filePath)) {
            JSONObject json = new JSONObject();
            JSONArray songArray = new JSONArray();
            
            for (Song song : songs) {
                JSONObject songObj = new JSONObject();
                songObj.put("name", song.getName());
                songObj.put("album", song.getAlbum());
                songObj.put("artist", song.getAuthor());
                songObj.put("genre", song.getGenre());
                songObj.put("rating", song.getRating());
                songObj.put("favorite", song.isFavorite());
                songArray.put(songObj); // Add song object to JSON array
            }
            
            json.put("songs", songArray);
            writer.write(json.toString(4)); // Write formatted JSON to file
        } catch (Exception e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }
}
