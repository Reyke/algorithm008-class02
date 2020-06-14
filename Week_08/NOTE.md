## 3 种初级排序的实现 O(n^2)

### 选择排序 Selection Sort

选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

```java
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

```

### 插入排序 Insertion Sort

插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

```java
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

```

### 冒泡排序 Bublle Sort

冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

大学教材里常见，但是现实中基本从来不用。

```java
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

```
