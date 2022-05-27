package com.example.leetcode.code;

/**
 * @Created: lidong on 2022/4/12 9:41 PM
 * @version: 1.0.0
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code6 {
    public static String longestPalindrome(String s) {
        int indexA = 0;
        int indexB = 0;
        int indexC = 1;
        String maxString = null;
        int maxSize = 0;
        while (indexA <= s.length() - 2) {
            int i = -1;
            while(true){
                int tempA = indexA - i - 1;
                int tempB = indexC + i + 1;
                if (tempA < 0 || tempB >= s.length()){
                    break;
                }
                if (s.charAt(tempA) != s.charAt(tempB)){
                    break;
                }
                i++;
            }
            if (i >= 0) {
                int size = (indexC + i) - (indexA - i) + 1;
                if (size > maxSize){
                    maxSize = size;
                    maxString = s.substring(indexA - i , indexC + i +1);
                }
            }

            if (indexB == 0){
                indexB = indexC;
                indexC ++;
            }else{
                indexA = indexB;
                indexB = 0;
            }
        }
        if (maxString == null){
            maxString = s.substring(0,1);
        }
        return maxString;
    }

    public static void main(String[] args) {
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }
}
