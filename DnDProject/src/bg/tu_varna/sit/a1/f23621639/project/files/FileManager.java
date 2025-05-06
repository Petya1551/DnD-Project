package bg.tu_varna.sit.a1.f23621639.project.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static char[][] loadMapFromFile(String filePath) {
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<char[]> mapRows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                mapRows.add(line.toCharArray());
            }

            char[][] map = new char[mapRows.size()][];
            for (int i = 0; i < mapRows.size(); i++) {
                map[i] = mapRows.get(i);
            }

            return map;
        } catch (IOException e) {
            System.out.println("Error loading map from file: " + filePath + " (" + e.getMessage() + ")");
            return null;
        }
    }
}
