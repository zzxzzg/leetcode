package com.example.daliy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Created: lidong on 2022/5/13 11:42 AM
 * @Description: 手搓一个OOM，注意jvm设置了 -Xmx20m -Xms20m
 * @version: 1.0.0
 */
public class OOMTest {
    public static void main(String[] args) {
        // 堆溢出
//        List<Byte[]> test = new ArrayList<>();
//        while (true){
//            Byte[] b = new Byte[1024];
//            test.add(b);
//        }

        // 栈溢出 StackOverflowError
//        Test test = new Test();
//        test.testF();

        // 方法区溢出


        // 线程太多
//        while (true){
//            Thread thread = new Thread(LockSupport::park);
//            thread.start();
//        }


    }

    public static class Test{
        public void testF(){
            Byte[] b = new Byte[20];
            testF();
        }
    }
}
