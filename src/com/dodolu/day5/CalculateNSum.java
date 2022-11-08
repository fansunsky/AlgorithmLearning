package com.dodolu.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

 你返回所有和为 0 且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

  

  

 示例 1：

 输入：nums = [-1,0,1,2,-1,-4]
 输出：[[-1,-1,2],[-1,0,1]]
 解释：
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 注意，输出的顺序和三元组的顺序并不重要。
 示例 2：

 输入：nums = [0,1,1]
 输出：[]
 解释：唯一可能的三元组和不为 0 。
 示例 3：

 输入：nums = [0,0,0]
 输出：[[0,0,0]]
 解释：唯一可能的三元组和为 0 。
  

 提示：

 3 <= nums.length <= 3000
 -105 <= nums[i] <= 105
 */
public class CalculateNSum {
    // n 数之和的通用解法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = 3;
        int start = 0;
        Arrays.sort(nums);
        res = nSum(nums, 0, n, start);
        return res;
    }

    public List<List<Integer>> nSum(int[] nums, int target, int n, int start){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < n || n < 2){
            return res;
        }

        // 两数之和，双指针解决
        if(n == 2){
            int left = start;
            int right = nums.length - 1;
            while(left < right){
                int cur = nums[left] + nums[right];
                if(cur == target){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[right]);
                    res.add(item);
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (cur > target){
                    right--;
                }else if(cur < target){
                    left++;
                }
            }
        }else{
            for(int i = start; i < nums.length; i++){
                List<List<Integer>> lists = nSum(nums, target - nums[i], n - 1, i + 1);
                // 把nums[i] 加到结果集里
                for(List<Integer> list: lists){
                    list.add(nums[i]);
                    res.add(list);
                }

                while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                    i++;
                }
            }
        }

        return res;
    }
}