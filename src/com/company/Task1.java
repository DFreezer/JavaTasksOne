package com.company;

import java.util.Arrays;
import java.util.Random;

public class Task1 {

    /**
     * Initialize array of type int
     * @param length
     * @param content
     * @return array of type int
     */
    public static int[] arrayInitialize(int length, int content) {
        int[] arr = new int[length];
        Arrays.setAll(arr, i -> content);
        return arr;
    }

    /**
     * Initialize array of type double
     * @param length
     * @param content
     * @return array of type double
     */
    public static double[] arrayInitialize(int length, double content) {
        double[] arr = new double[length];
        Arrays.setAll(arr, i -> content);
        return arr;
    }

    /**
     * Initialize array of type String
     * @param length
     * @param content
     * @return array of type String
     */
    public static String[] arrayInitialize(int length, String content) {
        String[] arr = new String[length];
        Arrays.setAll(arr, i -> content);
        return arr;
    }

    /**
     * Iinitialize the array of type Integer with random numbers
     * @param length
     * @return array of type Integer
     */
    public static Integer[] randomArrayInitialize(int length) {
        Random random = new Random();
        Integer[] arr = new Integer[length];
        Arrays.setAll(arr, i -> random.nextInt(99));
        return arr;
    }

    /**
     * Delete the selected array element
     * @param index element's index that will have deleted
     * @param arr
     * @return array of type Integer
     */
    public static Integer[] deleteElementOfArray(int index, Integer... arr) {
        arr[index] = 0;
        return arr;
    }

    //For testing
    public static void test() {
        int[] arr = arrayInitialize(5, 3);
        double[] arr2 = arrayInitialize(5, 2.9);
        String[] arr3 = arrayInitialize(2, "Hello");
        Integer[] arr4 = randomArrayInitialize(6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (double i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (String i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i : arr4) {
            System.out.print(i + " ");
        }
        deleteElementOfArray(3, arr4);
        System.out.println();
        for (Integer i : arr4) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        test();
    }
}

