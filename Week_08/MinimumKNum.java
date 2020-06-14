package cn.reyke.lab.week8;

import java.util.Arrays;

public class MinimumKNum {

   public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int begin, int end, int k) {
        int i = partition(arr, begin, end);
        if (i == k) {
            return Arrays.copyOf(arr, i + 1);
        }
        return i > k ? quickSearch(arr, begin, i - 1, k) : quickSearch(arr, i + 1, end, k);
    }

    public void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }

}
