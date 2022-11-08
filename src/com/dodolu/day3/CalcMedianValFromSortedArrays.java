package com.dodolu.day3;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class CalcMedianValFromSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 && length2 == 0) {
            return 0.0;
        }
        int length = length1 + length2;

        int temp = length / 2 + 1;
        Integer tl = null, th = null;
        int i = 0, j = 0, k = 0;
        while (k < temp) {
            // 提前保存本次循环的数组元素
            tl = th;
            if (i == nums1.length) {
                th = nums2[j++];
            } else if (j == nums2.length) {
                th = nums1[i++];
            } else {
                int ni = nums1[i];
                int nj = nums2[j];
                if (ni < nj) {
                    th = ni;
                    i++;
                } else {
                    th = nj;
                    j++;
                }
            }
            k++;
        }
        // 奇数直接取th 偶数取平均数
        return (length & 1) == 1 ? th : (tl + th) / 2.0;
    }

    public static void main(String[] args) {
        int []nums1 = {1,2}, nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
