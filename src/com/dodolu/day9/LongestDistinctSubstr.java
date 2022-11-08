package com.dodolu.day9;

import java.util.HashMap;

public class LongestDistinctSubstr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ababc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // 有重复字符 从重复字符开始遍历
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            // 重复字符，ch对应的value覆盖
            map.put(ch,end);
        }
        return max;
    }
}
