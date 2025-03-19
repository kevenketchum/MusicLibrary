import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/**
* UserManager Class
*
* This class is responsible for managing user accounts and much more including:
* - Registering new users with hashed passwords and unique salts 
* - Authenticating users during login by comparing stored hashed passwords
* Methods:
 * - registerUser(String username, String password): Registers a new user
 * - loginUser(String username, String password): Authenticates a user
 * - loadUsers(): Loads existing users from the JSON file
 * - saveUsers(): Saves user data to the JSON file
 * - generateSalt(): Generates a random salt for password hashing
 * - hashPassword(String password, String salt): Hashes a password using SHA-256 with a salt
 * 
 * This class ensures security by using cryptographic hashing with SHA-256 and random salting.
 */

public class UserManager {
    private static final String USER_FILE = "users.json";
    private Map<String, String[]> users; // Stores username, hashed password, and salt

    public UserManager() {
        users = new HashMap<>();
        loadUsers(); // Load existing users from File
    }

    // Loads users from the JSON file and populates the users map
    private void loadUsers() {
        try {
            File file = new File(USER_FILE);
            if (!file.exists()) return;
            
            String content = new String(Files.readAllBytes(Paths.get(USER_FILE)), StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(content);
            
            for (String key : json.keySet()) {
                JSONObject userObj = json.getJSONObject(key);
                users.put(key, new String[]{userObj.getString("password"), userObj.getString("salt")});
            }
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    // saves the current user data to the JSON file
    private void saveUsers() {
        try (FileWriter writer = new FileWriter(USER_FILE)) {
            JSONObject json = new JSONObject();
            
            for (Map.Entry<String, String[]> entry : users.entrySet()) {
                JSONObject userObj = new JSONObject();
                userObj.put("password", entry.getValue()[0]); // store hashed password
                userObj.put("salt", entry.getValue()[1]);   // store salt used for hashing
                json.put(entry.getKey(), userObj);
            }
            
            writer.write(json.toString(4)); // Print JSON with indentation
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    // Registers a new user with a hashed password and salt
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        users.put(username, new String[]{hashedPassword, salt});
        saveUsers(); // Save updated user list to file
        return true;
    }

    // Authenticates a user by comparing entered password hass with stored hash. 
    public boolean loginUser(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found.");
            return false;
        }
        
        String[] storedData = users.get(username);
        String storedHash = storedData[0];
        String salt = storedData[1];
        
        return storedHash.equals(hashPassword(password, salt)); // Compare stored hash with entered password hash
    }

    // Generates a random salt for password hashing
    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16-byte salt
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes); // Convert to base64 string for storage 
    }

    // Hashes the password using SHA-256 with the provided salt
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt)); // Decode base64 Salt before hashing
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes); // Convert to base64 for storage
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
