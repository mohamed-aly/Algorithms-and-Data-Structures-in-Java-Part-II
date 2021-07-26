package com.algorithms.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6, -4, 10};
        sort(array);
        Util.show(array);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                    Util.swap(array, i, j);
                }
            }
        }
    }
}
