package com.dodolu.ikm;

public class IntegerDemo {

    static Integer func(Integer b, Boolean flag){

        Integer a = flag ? b : 0;
        return a;

    }

    public static void main(String[] args) {
        System.out.println(func(null, true));
    }
}
