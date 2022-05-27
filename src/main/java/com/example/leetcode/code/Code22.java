package com.example.leetcode.code;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created: lidong on 2022/5/13 10:41 AM
 * @Description: 括号生成
 * @version: 1.0.0
 */
public class Code22 {
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }

    public static List<String> generateParenthesis(int n) {
        List<Record> pre = new ArrayList<>();
        Record record = new Record(n, n, "");
        pre.add(record);
        for (int i = 0; i < 2 * n; i++) {
            List<Record> records = new ArrayList<>();
            for (Record temp : pre) {
                if (temp.leftP == temp.rightP) {
                    records.add(new Record(temp.leftP - 1, temp.rightP, temp.str + '('));
                }else{
                    if (temp.leftP == 0){
                        records.add(new Record(temp.leftP, temp.rightP - 1, temp.str + ')'));
                    }else{
                        records.add(new Record(temp.leftP - 1, temp.rightP, temp.str + '('));
                        records.add(new Record(temp.leftP, temp.rightP - 1, temp.str + ')'));
                    }
                }
            }
            pre = records;
        }
        return pre.stream().map(r -> r.str).collect(Collectors.toList());
    }

    public static class Record {
        public int leftP;
        public int rightP;
        public String str;

        public Record(int leftP, int rightP, String str) {
            this.leftP = leftP;
            this.rightP = rightP;
            this.str = str;
        }
    }
}
