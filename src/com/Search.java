package com;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.util.Random;

public class Search {

    // Search for specific book/chapter/verse(s) and return result
    public static String specificChapter(String chapter) {

        String filePath = "res/kjv.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // Add each txt file line to separate index
            bufferedReader.lines().forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = "(" + chapter + ")\n";
        Boolean found = false;

        // Search text for chapter
        for (String line : lines) {
            if (line.startsWith(chapter)) {
                result = result + line + "\n";
                found = true;
            } else if (found) {
                break;
            }
        }

        if (result.equals("(" + chapter + ")\n")) {
            return result + "Error: Not found. Make sure to capitalize the first letter, EX: John 3:16";
        } else {
            return result;
        }
    }

    // Return a specific verse
    public static String specificVerse(String verse) {
        return "Genesis 1:1: In the beginning God made the heavens and the earth.";
    }

    // Return total amount of word occurrences
    public static int wordOccurences(String word, String book) {
        return 777;
    }

    // Return total amount of phrase occurrences
    public static int phraseOccurences(String phrase, String book) {
        return 777;
    }

    // Return a random verse
    public static String randomVerse() {
        Random random = new Random();
        int randomInt = random.nextInt(31101 - 0 + 1);

        String filePath = "res/kjv.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // Add each txt file line to separate index
            bufferedReader.lines().forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = lines.get(randomInt);

        return result;
    }
}