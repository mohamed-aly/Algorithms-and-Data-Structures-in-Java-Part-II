package com.algorithms.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6, -4, 10};
        System.out.println(Util.isSorted(array));
        sort(array);
        System.out.println(Util.isSorted(array));
        Util.show(array);
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                Util.swap(array, j - 1, j);
                j = j - 1;
            }
        }
    }
}
