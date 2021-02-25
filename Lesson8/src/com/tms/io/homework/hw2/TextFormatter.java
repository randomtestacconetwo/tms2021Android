package com.tms.io.homework.hw2;

public class TextFormatter {
    public static final int MIN_WORDS_COUNT = 3;
    public static final int MAX_WORDS_COUNT = 5;


    /**
     * Goes through sentences in the given text. Leaves only sentences that either
     *  - Has a palindrome word
     *  - Has {@value MIN_WORDS_COUNT} to MAX_WORDS_COUNT words
     */
    public String convertText(String text) {
        StringBuilder sb = new StringBuilder();
        for (String sentence : StringUtil.splitIntoSentences(text)) {
            int wordsCount = StringUtil.countWords(sentence);
            if (StringUtil.hasPalindrome(sentence) || wordsCount >= MIN_WORDS_COUNT && wordsCount <= MAX_WORDS_COUNT) {
                sb.append(sentence).append("\n");
            }
        }
        return sb.toString();
    }
}
