package cn.reyke.lab.everyday;

/**
 *  题号392. 判断子序列
 *
 *  解法：
 *  1. 顺序查找法
 *  2. 双指针解法
 *  3. 动态规划
 *  4. 二分查找
 */
public class SubsequenceValidator {


    /**
     *
     * 思路：java中非常好的一个方法，indexOf(char c,int m)意思是从第m位置开始寻找该索引，找到则返回该索引，否则返回-1，利用该特性我们通过对索引处理从而获得解。
     *
     * https://leetcode-cn.com/problems/is-subsequence/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jiao-77/
     */
        public boolean isSubsequence(String s, String t) {
            char[] arr = s.toCharArray();
            int j = -1;
            for(int i = 0;i<arr.length;i++) {
                j = t.indexOf(arr[i],j+1);
                if(j==-1) {
                    return false;
                }
            }
            return true;
    }


    public static void main(String [] args){
            String s = "acb";
            String t = "ahbgdc";
            System.out.println(new SubsequenceValidator().isSubsequence(s,t));
    }
}

