package cn.reyke.lab.week3.everyday3;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/majority-element/
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new MajorityElement().majorityElement(nums));
    }


    //Hash
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {

            if (!counter.containsKey(num))
                counter.put(num, 1);
            else
                counter.put(num, counter.get(num) + 1);

            if (counter.get(num) > nums.length / 2)
                return num;
        }
        return -1;
    }

    // // Moore voting algorithm
    public int majorityElement1(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            if (num != candidate)
                count--;
            else
                count++;
        }
        return candidate;
    }


}
