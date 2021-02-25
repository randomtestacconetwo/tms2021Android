package com.tms.io.homework.hw2;

public class StringUtil {
    private static final String WORDS_REGEXP = "[\\s,:;]+";

    public static int countWords(String sentence) {
        return sentence.split(WORDS_REGEXP).length;
    }

    public static boolean hasPalindrome(String sentence) {
        for (String word : sentence.split(WORDS_REGEXP)) {
            if (isWordPalindrome(word)) {
                return true;
            }
        }
        return false;
    }

    public static String[] splitIntoSentences(String text) {
        return text.split("(?<=[.!?])\\s+");
    }

    public static boolean isWordPalindrome(String word) {
        if (word.length() == 1) {
            return false;
        }
        word = word.toLowerCase().replaceAll("[.!?]", "");
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
