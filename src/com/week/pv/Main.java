package com.week.pv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 主函数
 * @author xingqijiang
 *
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int length = 5;
        Producer p1 = new Producer(queue,length);
        Consumer c1 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(c1);

    }
}