package com.netcracker.edu.miloserdov.dice;

/**
 * Supporting class to work with Integer arrays.
 */

public class Array {

    /**
     * Returns the int type maximum value of the input int[] type array.
     */

    public static int findMax(int[] array) {

        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    /**
     * Returns the index of the maximum value of the input int[] type array.
     */

    public static int findMaxKey(int[] array) {
        int temp = array[0];
        int key = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp) {
                temp = array[i];
                key = i;
            }
        }
        return key;
    }

    /**
     * Returns the sorted input int[] type array without changing it.
     */

    public static int[] bubbleSort(int[] arr) {
        int[] temparr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temparr[i] = arr[i];
        }
        for (int i = temparr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (temparr[j] > temparr[j + 1]) {
                    int tmp = temparr[j];
                    temparr[j] = temparr[j + 1];
                    temparr[j + 1] = tmp;
                }
            }
        }
        return temparr;
    }
}
