package com.dodolu.test;

import java.lang.reflect.Array;
import java.util.Arrays;

//12.合并有序数组
public class MergeSortArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{2,4,6,8,10,0,0,0,0};
        int[] num2 = new int[]{1,3,5,7};
//        System.out.println(Arrays.toString(merge(num1,5,num2,4)));
//        System.out.println(Arrays.toString(merge1(num1,5,num2,4)));
        System.out.println(Arrays.toString(merge3(num1,5,num2,4)));
    }

    //利用java中的api
    private static int[] merge(int[] num1, int m, int[] num2, int n) {
        System.arraycopy(num2,0,num1,m,n);
        Arrays.sort(num1);
        return num1;
    }

    //双指针算法
    private static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] num1_copy = new int[m];//新的数组
        System.arraycopy(nums1,0,num1_copy,0,m);//为了不违背题意
        int p1=0,p2=0;//双指针
        int p = 0;//指向num1。

        while (p1<m&&p2<n){
            nums1[p++] = num1_copy[p1]<nums2[p2]?num1_copy[p1++]:nums2[p2++];
        }
        if (p1<m){
            System.arraycopy(num1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if (p2<n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
        return nums1;
    }
    //双指针算法优化
    private static int[] merge3(int[] num1, int m, int[] num2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p =  num1.length-1;//num1的最后一个下标
        // 较大值追加到num1尾部 从后往前追加 num2剩余部分copy到num1上
        while (p1>=0&&p2>=0){
            num1[p--] = num1[p1]<num2[p2]?num2[p2--]:num1[p1--];
        }
        System.arraycopy(num2,0,num1,0,p2+1);
        return num1;
    }
}
