package cn.reyke.lab.week2;

import java.util.*;

//https://leetcode-cn.com/problems/top-k-frequent-elements/
public class TopKFrequence {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue()); //min heap

        for(int i=0;i<nums.length;i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],++val);
        }

        for(Map.Entry m : map.entrySet()){
            heap.offer(m);
            if(heap.size()>k) heap.poll();
        }

        int arr[] = new int[heap.size()];
        int ptr=0;
        while(!heap.isEmpty()){
            arr[ptr++] = heap.poll().getKey();
        }

        return arr;
    }
}
