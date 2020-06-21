package cn.reyke.lab.week10;

public class ReverseOnlyLetter {
    public String reverseOnlyLetters(String S) {
        char[] charArray = S.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!Character.isLetter(charArray[left])) {
                left++;
            } else if (!Character.isLetter(charArray[right])) {
                right--;
            } else {
                char temp = charArray[left];
                charArray[left++] = charArray[right];
                charArray[right--] = temp;
            }
        }
        return new String(charArray);
    }
}