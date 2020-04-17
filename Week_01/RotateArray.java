package cn.reyke.lab;

public class RotateArray {
    public void  rotate (int [] nums, int k){
        int len = nums.length;
        int n = k % len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            exch(nums, start++, end--);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static  void main(String[] args){
     int k = 3;
     int [] nums = {1,2,3,4,5,6,7};

     new RotateArray().rotate(nums,k);
     for (int i : nums)
       System.out.print(i + ",");

    }


}
