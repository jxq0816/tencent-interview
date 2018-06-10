package com.week.pv;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class Producer implements Runnable {
    private Queue<Integer> queue = new LinkedList<Integer>();
    private int length;

    public Producer(Queue<Integer> queue, int length) {
        this.queue = queue;
        this.length = length;
    }

    @Override
    public void run() {
        try {
            while (true) {

                if (Thread.currentThread().isInterrupted())
                    break;
                Random r = new Random();
                int temp = r.nextInt(100);
                System.out.println(Thread.currentThread().getId() + " 生产了：" + temp);
                synchronized (queue) {
                    if (queue.size() >= length) {
                        queue.notifyAll();
                        queue.wait();
                    } else
                        queue.add(temp);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
