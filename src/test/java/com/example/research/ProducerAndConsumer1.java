package com.example.research;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
/**
 * @ Author     ：zhangcx
 * @ Date       ：Created in 16:22 2019/11/22
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */

/**
 * 多线程生产者与消费者问题
 * 生产者生产，消费者立刻消费
 * 使用阻塞队列 保存产品
 */
public class ProducerAndConsumer1 {
    private static Logger logger = LoggerFactory.getLogger(ProducerAndConsumer1.class);


    public static void main(String[] args) {
        ProducerAndConsumer1 pac = new ProducerAndConsumer1();
        Storage storage = pac.new Storage();
        Producer p1 = pac.new Producer("11111", "小米手机", storage);
        Producer p2 = pac.new Producer("22222", "华为手机", storage);
        Consumer c1 = pac.new Consumer(storage);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(c1);
    }

    /**
     * 生产者
     */
    class Producer implements Runnable {
        private String name;//生产者名称
        private String pname;//生产的产品
        private Storage storage;

        public Producer(String name, String pname, Storage storage) {
            this.name = name;
            this.pname = pname;
            this.storage = storage;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 15; i++) {
                    Product p = new Product(pname, name);
                    storage.push(p);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者
     */
    class Consumer implements Runnable {
        private Storage storage;

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    storage.pop();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 产品信息
     */
    class Product {
        private String name;
        private String from;//来自哪个生产者
        private int id = 0;

        public Product(String name, String from, int id) {
            this.name = name;
            this.from = from;
            this.id = id;
        }

        public Product(String name, String from) {
            this.name = name;
            this.from = from;
        }

        public String getName() {
            return name;
        }

        public String getFrom() {
            return from;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    /**
     * 产品仓库
     */
    class Storage {

        //阻塞队列
        private BlockingQueue<Product> storage = new LinkedBlockingDeque<>();

        private int index = 1;//用于生成产品编号

        /**
         * 消费
         */
        protected void pop() throws InterruptedException {
            Product product = storage.take();
            logger.warn(product.getFrom() + "的" + product.getName() + "--> id:" + product.getId() + "被消费了");
        }

        /**
         * 生产
         */
        protected void push(Product product) throws InterruptedException {
            storage.put(product);
            product.setId(index++);
            logger.info(product.getFrom() + ",生产了" + product.getName() + "--> id:" + product.getId());
        }
    }

}
