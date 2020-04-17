package cn.reyke.lab;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }



    public static void main(String[] args){
        int [] digits = {9,9,9};
//        int [] digits = {1,2,3};

        for (int i = 0; i< digits.length; i++){
            System.out.print(String.valueOf(digits[i]) + ", ");
        }

        System.out.println("");

        System.out.println("After plus one  " + 3 % 100);

        digits = new PlusOne().plusOne(digits);
        for (int i = 0; i< digits.length; i++){
            System.out.print(String.valueOf(digits[i]) + ", ");
        }

    }
}
