package com.example.leetcode.code;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Created: lidong on 2022/5/12 8:45 PM
 * @Description: 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * @version: 1.0.0
 */
public class Code53 {
    public static void main(String[] args) {
        String str = "[-2,1,-3,4,-1,2,1,-5,4]";
        List<Integer> list  = JSON.parseArray(str,Integer.class);
        int[] array = list.stream().mapToInt(i->i).toArray();
        System.out.println(maxSubArray2(array));
    }

    public static int maxSubArray(int[] nums) {
        int[] maxNums = new int[nums.length];
        maxNums[0] = nums[0];
        int max = nums[0];
        for (int i=1 ; i< nums.length;i++){
            int x = nums[i];
            maxNums[i] = Math.max(maxNums[i-1] + x, x);
            max = Math.max(max, maxNums[i]);
        }

        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int max = pre;
        for (int x : nums){
            pre = Math.max(pre + x, x);
            max = Math.max(max, pre);
        }

        return max;
    }
}
