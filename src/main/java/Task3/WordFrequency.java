package Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String filePath = "src/main/java/Task3/words.txt";
        countWordFrequency(filePath);
    }

    public static void countWordFrequency(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+"); // Розділення слів
                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}