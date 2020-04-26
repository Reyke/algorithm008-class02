package cn.reyke.lab.everyday;

public class SortColors {
    public void sortColors(int[] nums) {
        int i=-1;
        int j=nums.length;
        int index=0;
        while( index < nums.length) {
            if(nums[index] == 2 && index < j) {
                swap(nums, index,--j);
            } else if(nums[index]==0 && index>i) {
                swap(nums, index, ++i);
                index++;
            } else {
                index++;
            }
        }
    }

    void swap(int[] nums, int from, int to) {
        int temp = nums[to];
        nums[to] = nums[from];
        nums[from] = temp;
    }
}
