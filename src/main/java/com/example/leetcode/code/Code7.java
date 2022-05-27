package com.example.leetcode.code;

/**
 * @Created: lidong on 2022/4/12 9:41 PM
 * @version: 1.0.0
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code7 {
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        char[] chars = new char[s.length()];
        int step = 2 * (numRows - 1);
        int currentIndex = 0;
        for (int i = 0; i < numRows; i++) {
            int k = 0;
            while (true) {
                int c = k * step;
                int indexA = c + i;
                int indexB = c + (step - i);
                if (indexA >= s.length()) {
                    break;
                }
                chars[currentIndex] = s.charAt(indexA);
                currentIndex++;
                if (indexB >= s.length()){
                    break;
                }
                if (indexB < (k + 1) * step && indexB!= indexA) {
                    chars[currentIndex] = s.charAt(indexB);
                    currentIndex++;
                }
                k++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "A"; //PINALSIGYAHRPI
        System.out.println(convert(s, 1));
    }
}
