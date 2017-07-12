package com.company;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    //Function for finding length of text excluding spaces
    public static int lengthWithoutSpaces(String str) {
        int length = 0;
        for (char ch : str.toCharArray()) {
            if(ch != ' ') length++;
        }
        return length;
    }

    //Function for finding the number of letters
    public static int numbersOfLetters(String str) {
        int count;
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(str);
        for (count = 0; matcher.find(); count++) {}
        return count;
    }

    //Function for finding the number of words in text
    public static int numberOfWords(String str) {
        return devider(str).length;
    }

    //Function for finding number of sentences in text
    public static int numberOfSentences(String str) {
        return str.split("[.!?(...)]+ +").length;
    }

    //Function for finding number of words in sentences
    public static void numberOfWordsInSentences(String str) {
        String[] string = str.split("[.!?(...)]+ +");
        for (int i = 0; i < string.length; i++) {
            System.out.println("Количество слов в предложении " + (i + 1) + ": " + numberOfWords(string[i]));
        }
    }

    //Function for deviding text on words
    public static String[] devider(String str) {
        return str.replaceAll("[\\p{Punct}&&[^'-]]", " ").replaceAll("[0-9]", " ").trim().split(" +");
    }

    //Function for finding the longest word in text
    public static String theLongestWord(String str) {
        String[] string = devider(str);
        String maxStr = string[0];
        for (int i = 1; i < string.length; i++) {
            if(maxStr.length() < string[i].length()) maxStr = string[i];
        }
        return maxStr;
    }

    //Function for finding the short word in text
    public static String theShortWord(String str) {
        String[] string = devider(str);
        String minStr = "";
        for (int i = 0; minStr.length() < 3; i++) {
            if(string[i].length() >= 3) {
                minStr = string[i];
            }
        }
        for (int i = 0; i < string.length; i++) {
            if(minStr.length() > string[i].length() && string[i].length() >= 3) minStr = string[i];
        }
        return minStr;
    }

    //Function for finding palindromes in text
    public static void palindromeChecker(String str) {
        String[] string = devider(str);
        StringBuilder[] stringBuilder = new StringBuilder[string.length];
        for (int i = 0; i < string.length; i++) {
            stringBuilder[i] = new StringBuilder(string[i].toLowerCase());
        }
        for (int i = 0; i < stringBuilder.length; i++) {
            if(stringBuilder[i]. reverse().toString().equals(string[i].toLowerCase())) {
                System.out.println(string[i]);
            }
        }
    }

    //Function for testing
    public static void stringAnalizer(String str) {
        System.out.println("Предложение: " + str);
        System.out.println("Длина текста: " + str.length() + " символов, " + lengthWithoutSpaces(str) + " без учета пробелов.");
        System.out.println("Количество слов: " + numberOfWords(str));
        System.out.println("Количество букв: " + numbersOfLetters(str));
        System.out.println("Количество предложений: " + numberOfSentences(str));
        numberOfWordsInSentences(str);
        System.out.println("Самое длинное слово в тексте: " + theLongestWord(str));
        System.out.println("Самое короткое слово в тексте: " + theShortWord(str));
        System.out.println("Слова палиндромы: ");
        palindromeChecker(str);
    }

    public static void main(String[] args) throws IOException {
        stringAnalizer("Шел казак куда-то вдаль! На груди была медаль. ");
        stringAnalizer(" !^$@hello83redivider42world!#$HEllo World!!!");
        stringAnalizer("In the year 2035, humanoid robots serve humanity, which is protected by the Three Laws of Robotics.");
    }
}
