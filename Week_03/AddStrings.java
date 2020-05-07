package cn.reyke.lab.week3.everyday3;

//https://leetcode-cn.com/problems/add-strings/
public class AddStrings {
    /**
     * 解题思路： 双指针，模拟人工加法
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = 0, n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0'; //类型转换
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0'; //类型转换
            }
            int sum = n1 + n2 + carry;
            carry = sum / 10;  //是否进位
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
