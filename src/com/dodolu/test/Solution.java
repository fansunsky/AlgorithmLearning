package com.dodolu.test;

import java.util.*;
class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        Set<Character> set = new HashSet<>();
        int result = 1;
        for (char s : S.toCharArray()) {
            if(!set.add(s)){
                result++;
                // duplicate char, clear set and add this char
                set.clear();
                set.add(s);
            }
        }
        return result;
    }
}
