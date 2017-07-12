package com.company;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static int lengthWithoutSpaces(String str) {
        int length = 0;
        for (char ch : str.toCharArray()) {
            if(ch != ' ') length++;
        }
        return length;
    }

    public static int numbersOfLetters(String str) {
        int count;
        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(str);
        for (count = 0; matcher.find(); count++) {}
        return count;
    }

    public static int numberOfWords(String str) {
        while(!((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') || (str.charAt(0) >= 'a' && str.charAt(0) <= 'z'))
                && !((str.charAt(0) >= 'А' && str.charAt(0) <= 'Я') || (str.charAt(0) >= 'а' && str.charAt(0) <= 'я'))) {
            str = str.replaceFirst(Pattern.compile("\\d+|[^а-яА-ЯёЁa-zA-Z]+", Pattern.UNICODE_CHARACTER_CLASS).pattern(), "");
        }
        str = str.replaceAll(Pattern.compile("\\d+|[^а-яА-ЯёЁa-zA-Z]+['-]+", Pattern.UNICODE_CHARACTER_CLASS).pattern(), " ");
        return str.split(" +").length;
    }

    public static int numberOfSentences(String str) {
        return str.split("[.!?(...)]+ +").length;
    }

    public static void numberOfWordsInSentences(String str) {
        String[] string = str.split("[.!?(...)]+ +");
        for (int i = 0; i < string.length; i++) {
            System.out.println("Количество слов в предложении " + (i + 1) + ": " + numberOfWords(string[i]));
        }
    }

    public static String theLongestWord(String str) {
        String[] string = str.replaceAll("[\\p{P}&&[^'-]]", " ").split(" +");
        String maxStr = string[0];
        for (int i = 1; i < string.length; i++) {
            if(maxStr.length() < string[i].length()) maxStr = string[i];
        }
        return maxStr;
    }

    public static String theShortWord(String str) {
        String[] string = str.replaceAll("[\\p{P}&&[^'-]]", " ").split(" +");
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

    public static void palindromeChecker(String str) {
        String[] string = str.replaceAll("[\\p{P}&&[^'-]]", " ").split(" +");
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

    public static void stringAnalizer(String str) {
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
    }
}
