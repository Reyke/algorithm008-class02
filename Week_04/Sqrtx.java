package cn.reyke.lab.week4;

//https://leetcode-cn.com/problems/sqrtx
public class Sqrtx {

    //二分查找法
    public int mySqrt(int x) {
        int left =0, mid= 0, right = x, ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
}