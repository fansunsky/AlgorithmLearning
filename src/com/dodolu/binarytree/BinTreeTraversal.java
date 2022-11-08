package com.dodolu.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方法遍历
 * @author fanhaoyu
 * @version 1.0
 * @describe
 * @date
 */

public class BinTreeTraversal {
    //测试
    public static void main(String[] args) {

        Traversal traversal = new Traversal();

        System.out.print("前序遍历：");
        System.out.println(traversal.preOrder());

        System.out.print("中序遍历:");
        System.out.println(traversal.inOrder());

        System.out.print("后序遍历:");
        System.out.println(traversal.postOrder());
    }

}

/**
 *
 * @Description 节点结构创建
 * @author gcystart
 * @version
 * @date
 *
 */

class BinTreeNode<Character> {

    char val;
    BinTreeNode<Character> lchild,rchild;//树的左孩子，右孩子

    BinTreeNode(char val, BinTreeNode<Character> lchild, BinTreeNode<Character> rchild) {
        this.val = val;
        this.lchild = lchild;
        this.rchild = rchild;
    }

}

class Traversal {

    /**
     * @return 根节点
     * @Description 创建一棵二叉树
     * @author gcystart
     * @date
     */
    public static BinTreeNode<Character> createBinTree() {
        //<Character>:泛型：优点是保证类型的安全
        BinTreeNode<Character> RR2 = new BinTreeNode<>('F', null, null);
        BinTreeNode<Character> LR2 = new BinTreeNode<>('E', null, null);
        BinTreeNode<Character> LL2 = new BinTreeNode<>('D', null, null);
        BinTreeNode<Character> L1 = new BinTreeNode<>('B', LL2, LR2);
        BinTreeNode<Character> R1 = new BinTreeNode<>('C', null, RR2);
        BinTreeNode<Character> node = new BinTreeNode<>('A', L1, R1);
        return node;
    }

    /*
    前序遍历：迭代法 根-> 左 -> 右
     */
    public List<Character> preOrder() {

        BinTreeNode<Character> root = createBinTree(); //根节点root

        List<Character> res = new ArrayList<>(); //创建一个队列，用来返回
        Stack<BinTreeNode<Character>> stack = new Stack<>(); //创建一个栈

        //迭代访问节点的左孩子，并入栈
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.lchild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点的右孩子
            root = stack.pop();
            root = root.rchild;
        }

        return res;
    }


    /*
    中序迭代法 左-> 根 -> 右
     */
    public List<Character> inOrder() {

        BinTreeNode<Character> root = createBinTree();

        List<Character> res = new ArrayList<>();
        Stack<BinTreeNode<Character>> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，并将弹出的的节点加入到res中。访问节点的右孩子
            root = stack.pop();
            res.add(root.val);
            root = root.rchild;
        }

        return res;
    }


    /*
    后序迭代法
     */
    public List<Character> postOrder() {

        BinTreeNode<Character> root = createBinTree();

        BinTreeNode<Character> prevAccess = null;

        List<Character> res = new ArrayList<>();
        Stack<BinTreeNode<Character>> stack = new Stack<BinTreeNode<Character>>();

        while (root != null || !stack.isEmpty()) {
            // 第三次循环 root不为null root是最底层节点的一个右子树p1R
            while (root != null) {
                // 第三次循环压栈p1R
                stack.push(root);
                root = root.lchild;
            }
            // 第一次循环求出了最底层最左边节点
            // 第二次循环 root为第一次节点的父节点 p1
            // 第三次循环 后进先出 root为p1R
            //  第四次循环 root为父节点p1 prevAccess为p1R if条件判断成立 第四次循环存入p1
            root = stack.pop();
            // 第二次循环if判断为false
            if (root.rchild == null || root.rchild == prevAccess) {
                // 首次循环list存入p1L这个节点 prevAccess = p1L
                // 第二次进入prevAccess变为p1R
                // 第三次进入这里保存p1节点
                res.add(root.val);
                // 保存本次访问的节点
                // 第二次进入prevAccess变为p1R
                prevAccess = root;
                root = null;
            } else {
                // 将父节点p1入栈 root变为父节点右子树
                stack.push(root);
                root = root.rchild;
            }
        }

        return res;
    }

}
