package com.example.leetcode.code;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Created: lidong on 2022/5/17 11:19 AM
 * @Description: 42.接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @version: 1.0.0
 */
public class Code42 {
    public static void main(String[] args) {
        String str = "[4,2,0,3,2,5]";
        List<Integer> list = JSON.parseArray(str, Integer.class);
        int[] array = list.stream()
            .mapToInt(i -> i)
            .toArray();
        System.out.println(trap(array));
    }

    public static int trap(int[] height) {
        int x = 0, lastH = height[0];
        int k = 0;
        for (int index = 1; index < height.length; index++) {
            int h = height[index];
            if (h > lastH) {
                int temp = index - 1;
                while (temp >= 0){

                }
                k = h;
            }
            lastH = height[index];
        }
        return x;
    }
}
