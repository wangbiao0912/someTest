package com.thread.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


/**
 *  ���߳�ģ��ʵ�������ߣ�������ģ��
 * Created by pc5 on 2017/7/17.
 */
public class LinkedBlockingQueueTest{
    /**
     *
     * ����װƻ��������
     *
     */
    public class Basket {
        // ���ӣ��ܹ�����3��ƻ��
        BlockingQueue<String> basket = new LinkedBlockingQueue<>(3);

        // ����ƻ������������
        public void produce() throws InterruptedException {
            // put��������һ��ƻ������basket���ˣ��ȵ�basket��λ��
            basket.put("An apple");
        }

        // ����ƻ������������ȡ��
        public String consume() throws InterruptedException {
            // take����ȡ��һ��ƻ������basketΪ�գ��ȵ�basket��ƻ��Ϊֹ(��ȡ���Ƴ��˶��е�ͷ��)
            return basket.take();
        }
    }

    // ����ƻ��������
    class Producer implements Runnable {
        private String instance;
        private Basket basket;

        public Producer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    // ����ƻ��
                    System.out.println("������׼������ƻ����" + instance);
                    basket.produce();
                    System.out.println("!����������ƻ����ϣ�" + instance);
                    // ����300ms
                    Thread.sleep(300);
                }
            } catch (InterruptedException ex) {
                System.out.println("Producer Interrupted");
            }
        }
    }

    // ����ƻ��������
    class Consumer implements Runnable {
        private String instance;
        private Basket basket;

        public Consumer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    // ����ƻ��
                    System.out.println("������׼������ƻ����" + instance);
                    System.out.println(basket.consume());
                    System.out.println("!����������ƻ����ϣ�" + instance);
                    // ����1000ms
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                System.out.println("Consumer Interrupted");
            }
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueueTest test = new LinkedBlockingQueueTest();

        // ����һ��װƻ��������
        Basket basket = test.new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = test.new Producer("������001", basket);
        Producer producer2 = test.new Producer("������002", basket);
        Consumer consumer = test.new Consumer("������001", basket);
        service.submit(producer);
        service.submit(producer2);
        service.submit(consumer);
        // ��������5s����������ֹͣ
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        service.shutdownNow();
    }

}
