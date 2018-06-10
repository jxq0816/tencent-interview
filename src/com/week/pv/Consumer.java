package com.week.pv;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 消费者
 * @author xingqijiang
 */
public class Consumer implements Runnable {

    private Queue<Integer> queue = new LinkedList<Integer>();

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (Thread.currentThread().isInterrupted())
                    break;
                int data;
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.wait();
                        queue.notifyAll();
                    }
                    data = queue.poll();
                }
                System.out.println(
                        Thread.currentThread().getId() + " 消费了:" + data +  " 已出队");
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}