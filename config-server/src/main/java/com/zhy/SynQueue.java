package com.zhy;

public class SynQueue<T>{
    private  T item;
    private boolean putValue = false;

    public synchronized T take() throws InterruptedException {
        while (item == null){
            wait();//没有值则等待
        }
        T temp = item;
        item = null;
        notifyAll();//唤醒放值
        return temp;
    }

    public synchronized void put(T t) throws InterruptedException {
        if(t == null){return;}
        while (putValue){
            wait();
        }
        putValue = true;
        item = t;
        notifyAll();//唤醒取值
        while (item != null){
            wait();//此处释放锁
        }
        putValue = false;
        notifyAll();
    }

}
