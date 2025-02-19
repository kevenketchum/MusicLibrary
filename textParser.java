package music;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class parseText {

    /**
     * Reads all lines from the given text file.
     * @param fileName The name (or path) of the file.
     * @return A List of trimmed strings, one per line.
     */
    protected List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file " + fileName + " - " + e.getMessage());
        }
        return lines;
    }

    /**
     * Splits a CSV-formatted line into an array of strings.
     * @param line The CSV string.
     * @return An array of tokens.
     */
    protected String[] parseCSV(String line) {
        if (line == null || line.isEmpty()) {
            return new String[0];
        }
        return line.split(",");
    }

    /**
     * Reads only the first line from the specified file.
     * @param fileName The name (or path) of the file.
     * @return The first line as a String, or null if not available.
     */
    protected String readFirstLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("ERROR: Could not read first line from file " + fileName + " - " + e.getMessage());
            return null;
        }
    }

    /**
     * Parses an album file where the first line contains CSV metadata (e.g., album title, artist, genre, year)
     * and the remaining lines contain content such as song names.
     * @param fileName The album file name.
     * @return An AlbumData object containing metadata and content.
     */
    public AlbumData parseAlbumFile(String fileName) {
        AlbumData albumData = new AlbumData();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read and parse metadata from the first line
            String firstLine = reader.readLine();
            if (firstLine != null) {
                albumData.metadata = parseCSV(firstLine);
            }
            // Read the remaining lines (e.g., songs)
            String line;
            while ((line = reader.readLine()) != null) {
                albumData.content.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read file " + fileName + " - " + e.getMessage());
        }
        return albumData;
    }

    /**
     * A simple data holder for album information.
     */
    public static class AlbumData {
        public String[] metadata;
        public List<String> content;

        public AlbumData() {
            content = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (metadata != null) {
                sb.append("Metadata: ");
                for (String data : metadata) {
                    sb.append(data.trim()).append(" ");
                }
                sb.append("\n");
            }
            sb.append("Content:\n");
            for (String line : content) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        }
    }

    // A simple main method for testing the utility methods.
    public static void main(String[] args) {
        parseText parser = new parseText();

        // Example 1: Read and display the contents of a generic text file.
        String fileName = "example.txt";  // Replace with your file
        List<String> lines = parser.readFile(fileName);
        System.out.println("File content:");
        for (String line : lines) {
            System.out.println(line);
        }

        // Example 2: Parse an album file (if it exists)
        String albumFile = "Album_Artist.txt";  // Replace with your actual album file name
        AlbumData album = parser.parseAlbumFile(albumFile);
        System.out.println("Parsed album data:");
        System.out.println(album);
    }
}
