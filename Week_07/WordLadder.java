package cn.reyke.lab.week7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// P127 https://leetcode-cn.com/problems/word-ladder/
public class WordLadder {


    // two-end BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>(),endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                for (int i = 0; i < beginWord.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String target = new String(chars);
                        if (endSet.contains(target)) return step + 1;
                        if (!wordSet.contains(target)) continue;
                        wordSet.remove(target);
                        temp.add(target);
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        if (!wordSet.contains(endWord)) return 0;

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for(String word : beginSet){
                char[] chs = word.toCharArray();

                for(int i = 0; i <chs.length; i++){
                    for(char j = 'a'; j <= 'z'; j++){
                        char old = chs[i];
                        chs[i] = j;
                        String target = String.valueOf(chs);

                        if(endSet.contains(target)){
                            return  len + 1;
                        }

                        if(!visited.contains(target) && wordList.contains(target)){
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] =  old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }



}
