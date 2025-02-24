package music;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class TextParser {

    private TextParser() {
        // Utility class - no instantiation
    }

    public static List<String> readFile(String fileName) {
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

    public static String[] parseCSV(String line) {
        return line != null && !line.isEmpty() ? line.split(",") : new String[0];
    }
}
