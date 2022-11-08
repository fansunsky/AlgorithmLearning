package com.dodolu.day2;

import java.util.LinkedList;
import java.util.Queue;

public class CalcEveryLevelMinValFromTreeNode {

    public static void main(String[] args) {
        Mytree tree = new Mytree();
        tree.add(7);
        tree.add(5);
        tree.add(8);
        tree.add(6);
        tree.add(9);
        tree.add(4);
        tree.add(8);
        levelOrder(tree.root);
        printLeftOfEveryLevel(tree.root);

    }

    static class TreeNode{
        public int val;//值
        public TreeNode left;//左子树
        public TreeNode right;//右子树



        public void addNode(TreeNode n)
        {
            if(n.val<this.val)
            {
                if(this.left==null)
                    this.left=n;
                else
                    this.left.addNode(n);//递归，实现左，右，根节点的链接
            }
            else{
                if(right==null)
                {
                    right=n;
                }
                else{
                    right.addNode(n);
                }
            }
        }
    }


    /**
     * 层序遍历 打印出最左边的值
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                System.out.printf("第%d层"+cur.val + " ", level);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
    }

    /**
     * 层序遍历 打印出最左边的值
     * @param root
     */
    public static void printLeftOfEveryLevel(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每次for循环结束，quequ保存了一层二叉树
            System.out.print("第" + level + "层最左边的值为:" + queue.peek().val + " ");
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
    }

    static class Mytree {
        public TreeNode root;//根节点
        public void add(int x)//插入数据
        {
            TreeNode p=new TreeNode();
            p.val=x;
            if(root==null)
            {
                root=p;
            }
            else {
                root.addNode(p);
            }
        }
    }



}
