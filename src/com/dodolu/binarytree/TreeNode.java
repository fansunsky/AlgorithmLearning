package com.dodolu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 先序
     * @param root
     */
    public void pre(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val);
        pre(root.left);
        pre(root.right);
    }

    /**
     * 中序
     * @param root
     */
    public static void cur(TreeNode root) {
        if (root == null)
            return;
        cur(root.left);
        System.out.print(root.val);
        cur(root.right);
    }

    /**
     * 后续
     * @param root
     */
    public static void nxt(TreeNode root) {
        if (root == null)
            return;
        nxt(root.left);
        nxt(root.right);
        System.out.print(root.val);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode temp1 = new TreeNode(1);
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(3);
        TreeNode temp5 = new TreeNode(5);
        root.left = temp2;
        root.right = temp5;
        temp2.right = temp3;
        temp2.left = temp1;

        printRightNode(root);

    }


    static void printRightNode(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = root;
        queue.offer(cur);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                cur = queue.poll();
                if(i == size-1){
                    System.out.println(cur.val);
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }

    }
}

