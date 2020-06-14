package cn.reyke.lab.week8;

public class SortAlgo {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 1, 6, 7, 4, 3, 8};
        new SortAlgo().BubbleSort(arr);
        for (int i : arr)
            System.out.print(i + ", ");
    }

    public int[] BubbleSort(int[] array) {
     int len = array.length;
     int temp = 0;
     for(int i = 0; i < len - 1; i++){
         for(int j = 0; j < len - i - 1; j++){
             if(array[j] > array[j+1]){
                 temp = array[j];
                 array[j] = array[j + 1];
                 array[j + 1] = temp;

             }
         }
     }
     return  array;
    }

    public int[] insertionSort(int[] array) {
        int len = array.length;
        int preIndex = 0, current = 0;
        for(int i = 1; i < len; i++){
            preIndex = i - 1;
            current = array[i];
            while(preIndex >= 0 && array[preIndex] > current){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public int[] selectionSort(int[] array) {
        int len = array.length;
        int minIndex = 0, temp = 0;

        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
//            temp = array[i];
//            array[i] = array[minIndex];
//            array[minIndex] = temp;

            array[i] = array[i] ^ array[minIndex];
            array[minIndex] = array[minIndex] ^ array[i];
            array[i] =array[i] ^ array[minIndex];
        }
        return array;
    }
}
