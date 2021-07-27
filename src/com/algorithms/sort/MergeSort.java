package com.algorithms.sort;

class Run {
    public static void main(String[] args) {
        int[] array = {12, 2, 11, 56, 6, -4, 10};
        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort();
        Util.show(array);
    }
}

public class MergeSort {

    private int[] array;
    private int[] tempArray;

    public MergeSort(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
    }

    public void sort() {
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int low, int high) {
        if(low >= high) return;

        int middle = (low + high) / 2;

        mergeSort(low, middle);
        mergeSort(middle+1, high);
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
       //copy the array into tempArray
        System.arraycopy(array, 0, tempArray, 0, array.length);

        //compare between the left and right
        int i = low;
        int j = middle+1;
        int k = low;

        while(i<= middle && j <= high){
            if(tempArray[i] <= tempArray[j]){
                array[k] = tempArray[i];
                i++;
            }else{
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        //copy the rest of left array
        while(i<= middle){
            array[k] = tempArray[i];
            i++;
            k++;
        }

        //copy the rest of the right array
        while(j<=high){
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }
}
