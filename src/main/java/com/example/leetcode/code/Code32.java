package com.example.leetcode.code;

/**
 * @Created: lidong on 2022/5/13 2:26 PM
 * @Description: 32. 最长有效括号
 * @version: 1.0.0
 */
public class Code32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("("));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        for (int index = 0; index < s.length(); index++) {
            int l = 0, r = 0 ,temp = index;
            int startIndex = index + 1;
            while (temp >=0 ){
                char ch = s.charAt(temp);
                if (ch == '('){
                    l++;
                }
                if (ch  == ')'){
                    r++;
                }
                if (l > r){
                    break;
                }
                if (l == r){
                    startIndex = temp;
                    l = 0;
                    r = 0;
                }
                temp--;
            }
            max = Math.max(max, index - startIndex + 1);
        }
        return max;
    }
}
