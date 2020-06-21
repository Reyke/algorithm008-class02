package cn.reyke.lab.week10;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWord {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return  String.join("", words);
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return  String.join("", words);
    }
}
