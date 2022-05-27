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
public class Code70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }

    public static int climbStairs(int n) {
        int pre1 = 0, pre2 = 0, temp;
        for (int i = 0; i <n ;i ++){
            temp = pre1 + pre2;
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
}
