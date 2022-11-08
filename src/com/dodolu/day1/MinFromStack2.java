package com.dodolu.day1;

import java.util.Stack;

/**
 * 求栈中的最小值 要求复杂度O(1)
 */
public class MinFromStack2 {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        MinFromStack2 minFromStack = new MinFromStack2();
        minFromStack.push(5);
        minFromStack.push(7);
        minFromStack.push(3);
        minFromStack.push(10);
        System.out.println(minFromStack.getMin());
    }

    public void push(int x){
        pushStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }
        // 待入栈元素小于栈顶的值，则入栈，保证栈顶的值最小
        else if( x < minStack.peek()){
            minStack.push(x);
        }
    }

    public int getMin(){
        return minStack.peek();
    }

}


