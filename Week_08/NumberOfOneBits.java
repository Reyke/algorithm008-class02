package cn.reyke.lab.week8;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            // n & (n - 1) 清零最低位的1
            n &= (n - 1);
        }
        return sum;
    }

}
