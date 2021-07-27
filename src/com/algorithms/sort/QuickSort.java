package com.algorithms.sort;

class App {
    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6, -4, 10};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        Util.show(array);
    }
}

public class QuickSort {

    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(low, high);
        quickSort(0, pivotIndex - 1);
        quickSort(pivotIndex + 1, high);
    }

    private int partition(int low, int high) {
        int pivot = array[high];

        int i = low;

        for(int j = low; j<high; j++){
            if(array[j] < pivot){
                Util.swap(array,j, i);
                i++;
            }
        }

        Util.swap(array, i, high);
        return i;

    }

}
