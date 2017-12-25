package com.zhy;

public class MyRunable implements  Runnable {
    @Override
    public void run() {
        while (true ){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
