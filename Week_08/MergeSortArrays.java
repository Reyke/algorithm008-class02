package cn.reyke.lab.week8;

public class MergeSortArrays {

    //双指针，归并排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     int index1 = m - 1;
     int index2 = n - 1;
     int tail = m + n - 1;

        while(index1 >= 0 && index2 >=0){
            if(nums1[index1] <= nums2[index2])
                nums1[tail--] = nums2[index2--];
            else
                nums1[tail--] = nums1[index1--];
        }

        while(index2 >= 0){
            nums1[tail--] = nums2[index2--];
        }

    }
    /**
     *  1.  index1 = 2, index2 = 2, tail = 5 , [1,2,3,0,0,6]
     *  2.  index1 = 2, index2 = 1, tail = 4 , [1,2,3,0,5,6]
     *  3.  index1 = 2, index2 = 0, tail = 3 , [1,2,3,3,5,6]
     *  4.  index1 = 1, index2 = 0, tail = 2 , [1,2,3,3,5,6]
     *  5.  index1 = 1, index2 = -1,  退出while 循环
     *
     */
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;

        new MergeSortArrays().merge(nums1,m,nums2,n);

        for(int i : nums1)
            System.out.print(i + ", ");
    }
}



