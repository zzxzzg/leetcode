package com.example.daliy;

/**
 * @Created: lidong on 2022/5/17 3:31 PM
 * @Description: TODO
 * @version: 1.0.0
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1");
            while (true){
                System.out.println("Thread1" + threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");
            while (true){
                System.out.println("Thread2" + threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
