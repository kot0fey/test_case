package org.example.Task09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task09 {
    public void count(String fileName) {
        try {
            Map<String, Integer> wordCounts = countWordFrequencies(fileName);
            List<Map.Entry<String, Integer>> sortedWordCounts = sortWordFrequencies(wordCounts);
            printWordFrequencies(sortedWordCounts);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Map<String, Integer> countWordFrequencies(String fileName) throws IOException {
        Map<String, Integer> wordCounts = new HashMap<>();
        File file = new File(fileName);

        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordCounts;
    }

    public static List<Map.Entry<String, Integer>> sortWordFrequencies(Map<String, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());
    }

    public static void printWordFrequencies(List<Map.Entry<String, Integer>> sortedWordCounts) {
        for (Map.Entry<String, Integer> entry : sortedWordCounts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
