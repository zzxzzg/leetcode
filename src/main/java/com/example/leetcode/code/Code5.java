package com.example.leetcode.code;

/**
 * @Created: lidong on 2022/4/12 9:41 PM
 * @version: 1.0.0
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code5 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        if (nums1.length == 0) {
            return getMid(nums2);
        }

        if (nums2.length == 0) {
            return getMid(nums1);
        }
        // 总数为双数，则取第 k 和第 k+1 两个数的平均值，单数择取 第k+1个数
        int k = (nums1.length + nums2.length) / 2 - 1;
        int leftA = 0;
        int leftB = 0;
        while (k > 0){
            // 双数取
            int index = k / 2;
            int indexA = leftA + index;
            int indexB = leftB + index;

            if(nums1[indexA] == nums2[indexB]){
                return nums1[indexA];
            } else if (nums1[indexA] > nums2[indexB]){
                k = k - index;
                leftB = indexB;
            } else if (nums1[indexA] < nums2[indexB]) {
                k = k - index;
                leftA = indexA;
            }
            if (k == 0){
                return (nums1[leftA] + nums2[leftB]) / 2f;
            }
        }

        return 0;

    }

    private static double getMid(int[] num) {
        if (num.length % 2 == 0) {
            int a = (num.length - 1) / 2;
            int b = num.length / 2;
            return (num[a] + num[b]) / 2f;
        } else {
            return num[num.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1,2,3,4,5};
        int[] num2 = new int[] {1,2,5,7,8};
        System.out.println(findMedianSortedArrays(num1, num2) + "");
    }
}
