package cn.reyke.lab.week4;

import java.util.Arrays;

//https://leetcode-cn.com/problems/assign-cookies
public class AssignCookies {

    //贪心算法
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j=0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
