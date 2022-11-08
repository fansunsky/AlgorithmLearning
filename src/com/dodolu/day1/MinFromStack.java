package com.dodolu.day1;

import java.util.Stack;

/**
 * 求栈中的最小值 要求复杂度O(1)
 */
public class MinFromStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(9);
        minStack.push(3);
        minStack.push(4);
        System.out.println(minStack.getMin());

    }

}


class StackNode{
    public int val;
    public int min;
    public StackNode(int val,int min){
        this.val=val;
        this.min=min;
    }
}

class MinStack{
    private Stack<StackNode> stack=new Stack<>();

    //判空
    public boolean empty(){
        return stack.isEmpty();
    }

    //压栈
    public void push(int x){
        if(empty()){
            stack.push(new StackNode(x,x));
        }else{
            // 每次入栈第二个参数保存较小的值，这样栈顶的值永远是最小的
            stack.push(new StackNode(x,Math.min(x, stack.peek().val)));
        }
    }

    //出栈
    public void pop(){
        if(empty()){
            throw new IllegalStateException("栈为空....");
        }
    }


    //显示栈顶值
    public int top(){
        if(empty()){
            throw new IllegalStateException("栈为空....");
        }
        return stack.peek().val;
    }

    //最小值
    public int getMin(){
        if(empty()){
            throw new IllegalStateException("栈为空.....");
        }
        return stack.peek().min;
    }
}


