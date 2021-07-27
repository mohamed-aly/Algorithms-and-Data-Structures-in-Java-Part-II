package com.algorithms.sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6, -4, 10};
        System.out.println(Util.isSorted(array));
        sort(array);
        System.out.println(Util.isSorted(array));
        Util.show(array);
    }

    public static void sort(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;

                while (j >= gap && array[j - gap] > array[j]) {
                    Util.swap(array, j - gap, j);
                    j = j - gap;
                }
            }
        }
    }
}
