package cn.reyke.lab.week6;

//https://leetcode-cn.com/problems/house-robber/
public class HouseRobber {

    //解法详解
    // https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
    public int rob(int[] nums){
        int len = nums.length;
        if(len == 0) return 0;

        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 2; i <= len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return  dp[len];
    }

    //Iterative + 2 variables (bottom-up)
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
