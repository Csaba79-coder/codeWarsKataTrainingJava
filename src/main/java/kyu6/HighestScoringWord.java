package kyu6;

import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {

    // https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java

    public static String high(String s) {
        // Your code here...
        String highScoreWord = "";
        int maxTotal = 0;
        for (String word : s.split(" ")) {
            int totalOfWord = 0;
            for (char character : word.toCharArray()) {
                totalOfWord += character - 96; // the int value of "a" is 97
            }
            if (totalOfWord > maxTotal) {
                maxTotal = totalOfWord;
                highScoreWord = word;
            }
        }
        return highScoreWord;
    }

    public static String high2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

    public static String high3(String s) {

        String winner = "";
        int highScore = 0;

        for (String word : s.split(" ")) {
            int score = 0;
            for (char character : word.toCharArray()) {
                score += character - 'a' + 1;
            }
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }

        return winner;
    }

    public static String high4(String s) {
        String[] arr = s.split(" ");
        int[] sums = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = 0; j < arr[i].length(); j++) {
                sum += arr[i].charAt(j) - 96;
                sums[i] = sum;
            }
        }

        int max = sums[0];
        int maxIndex = 0;

        for(int i = 0; i < sums.length; i++) {
            if(sums[i] > max) {
                max = sums[i];
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static String high5(String s) {
        return Arrays.stream(s.split(" "))
                .sorted(Comparator.comparingInt(HighestScoringWord::calculateWordScore).reversed())
                .findFirst().get();
    }

    private static int calculateWordScore(String word) {
        return word.chars().map(c -> c - (int)'a' + 1).sum();
    }

    public static String high6(String s) {
        String word = "";
        int n, max = 0;
        for (String w : s.split(" ")) {
            if ((n = w.chars().sum() - w.length() * ('a'-1)) > max) {
                word = w; max = n; }
        }
        return word;
    }
}
