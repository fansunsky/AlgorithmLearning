package com.dodolu.day5;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            int newTarget = target - num1;
            while(left < right){
                int val = nums[left] + nums[right];
                if(val == newTarget){
                    return target;
                }else if(val > newTarget){
                    right--;
                }else{
                    left++;
                }
                // 不断循环找出与target最接近的值
                if(Math.abs(newTarget - val) < Math.abs(min)){
                    min = newTarget - val;

                }
            }
        }

        return target - min;
    }

}
