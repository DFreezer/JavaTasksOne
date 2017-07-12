package com.company;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    /**
     * Find length of text excluding spaces
     * @param inputStr The input string
     * @return length of string excluding spaces
     */
    public static int lengthWithoutSpaces(String inputStr) {
        int length = 0;
        for (char ch : inputStr.toCharArray()) {
            if(ch != ' ') length++;
        }
        return length;
    }

    /**
     * Find the number of letters
     * @param inputStr The input string
     * @return number of letters in string
     */
    public static int numbersOfLetters(String inputStr) {
        int count;
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(inputStr);
        for (count = 0; matcher.find(); count++) {}
        return count;
    }

    /**
     * Find the number of words in text
     * @param inputStr The input string
     * @return number of words int the string
     */
    public static int numberOfWords(String inputStr) {
        return devider(inputStr).length;
    }

    /**
     * Find number of sentences in text
     * @param inputStr The input string
     * @return number of sentences in he string
     */
    public static int numberOfSentences(String inputStr) {
        return inputStr.split("[.!?(...)]+ +").length;
    }

    /**
     * Find number of words in sentences
     * @param inputStr The input string
     */
    public static void numberOfWordsInSentences(String inputStr) {
        String[] sentence = inputStr.split("[.!?(...)]+ +");
        for (int i = 0; i < sentence.length; i++) {
            System.out.println("Количество слов в предложении " + (i + 1) + ": " + numberOfWords(sentence[i]));
        }
    }

    /**
     * Devide text on words
     * @param inputStr The input string
     * @return array of words
     */
    public static String[] devider(String inputStr) {
        return inputStr.replaceAll("[\\p{Punct}&&[^'-]]", " ").replaceAll("[0-9]", " ").trim().split(" +");
    }

    /**
     * Find the longest word in text
     * @param inputStr The input string
     * @return word with the longest length
     */
    public static String theLongestWord(String inputStr) {
        String[] sentence = devider(inputStr);
        String maxStr = sentence[0];
        for (int i = 1; i < sentence.length; i++) {
            if(maxStr.length() < sentence[i].length()) maxStr = sentence[i];
        }
        return maxStr;
    }

    /**
     * Find the short word in text
     * @param inputStr The input string
     * @return word with the shortest length
     */
    public static String theShortestWord(String inputStr) {
        String[] sentence = devider(inputStr);
        String minStr = "";
        for (int i = 0; minStr.length() < 3; i++) {
            if(sentence[i].length() >= 3) {
                minStr = sentence[i];
            }
        }
        for (int i = 0; i < sentence.length; i++) {
            if(minStr.length() > sentence[i].length() && sentence[i].length() >= 3) minStr = sentence[i];
        }
        return minStr;
    }

    /**
     * Find palindromes in text
     * @param inputStr The input string
     */
    public static void palindromeChecker(String inputStr) {
        String[] sentence = devider(inputStr);
        StringBuilder[] stringBuilder = new StringBuilder[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            stringBuilder[i] = new StringBuilder(sentence[i].toLowerCase());
        }
        for (int i = 0; i < stringBuilder.length; i++) {
            if(stringBuilder[i]. reverse().toString().equals(sentence[i].toLowerCase())) {
                System.out.println(sentence[i]);
            }
        }
    }

    //For testing
    public static void stringAnalizer(String inputStr) {
        System.out.println("Предложение: " + inputStr);
        System.out.println("Длина текста: " + inputStr.length() + " символов, " + lengthWithoutSpaces(inputStr) + " без учета пробелов.");
        System.out.println("Количество слов: " + numberOfWords(inputStr));
        System.out.println("Количество букв: " + numbersOfLetters(inputStr));
        System.out.println("Количество предложений: " + numberOfSentences(inputStr));
        numberOfWordsInSentences(inputStr);
        System.out.println("Самое длинное слово в тексте: " + theLongestWord(inputStr));
        System.out.println("Самое короткое слово в тексте: " + theShortestWord(inputStr));
        System.out.println("Слова палиндромы: ");
        palindromeChecker(inputStr);
    }

    public static void main(String[] args) throws IOException {
        stringAnalizer("Шел казак куда-то вдаль! На груди была медаль. ");
        stringAnalizer(" !^$@hello83redivider42world!#$HEllo World!!!");
        stringAnalizer("In the year 2035, humanoid robots serve humanity, which is protected by the Three Laws of Robotics.");
    }
}
