package com.zhy;

public class ThreadTest {

    public static void main(String[] args) {
       final Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("=====start====");
                while (!Thread.interrupted()){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("===========3s over=========");
                }
            }
        });
       thread.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("main sleep over =====");
        thread.interrupt();
    }

}
