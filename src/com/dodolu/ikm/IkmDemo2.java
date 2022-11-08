package com.dodolu.ikm;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class IkmDemo2 {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("3");
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("3");
        set.add("1");
        set.forEach(s-> System.out.print(s+"-"));
        int c=0;
        System.out.println((0==c++)?true:false);
        System.out.println(Stream.of("green", "yellow", "blue").max(String::compareTo).filter(s->s.endsWith("n")).orElse("yellow"));
    }
}
