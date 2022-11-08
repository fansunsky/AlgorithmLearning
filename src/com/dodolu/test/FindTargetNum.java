package com.dodolu.test;

/**
 *
 * 从有序数组中查找一个数target， 返回起始下标
 */
public class FindTargetNum {

    public static int[] findTargetNum(int []arrey, int target){
        // target先和
        int left = 0;
        int right = arrey.length - 1;
        int middle;
        while (left <= right){
            middle = (left+right)/2;
            if(arrey[middle] == target){
                 break;
            }
            if(arrey[middle] > target){
                right = middle;
            }
            else{
                left = middle;
            }
        }
        boolean startFlag = false;
        boolean endFlag = false;
        int []result = new int[2];
        for(int startIndex = left, endIndex = right; startIndex < right ; startIndex++, endIndex--){
            if(!startFlag && arrey[startIndex] == target){
                startFlag = true;
                result[0] = startIndex;
            }
            if(!endFlag && arrey[endIndex] == target){
                endFlag = true;
                result[1] = endIndex;
            }
        }
        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    public static void main(String[] args) {
        int []array = new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, 7, 8, 9};
        findTargetNum(array, 5);
    }
}
