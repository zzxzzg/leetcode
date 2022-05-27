package com.example.daliy;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @Created: lidong on 2022/5/19 9:07 PM
 * @Description:
 * @version: 1.0.0
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
//        numbers.parallelStream()
//            .reduce((integer, integer2) -> {
//                System.out.println(Thread.currentThread());
//                Integer sum = Integer.sum(integer,integer2);
//                System.out.println(integer + "+" + integer2 + "=" + sum);
//                return sum;
//            });

        numbers.parallelStream()
            .forEach(integer -> {
                System.out.println(Thread.currentThread());
                System.out.println(integer);
            });
    }
}
