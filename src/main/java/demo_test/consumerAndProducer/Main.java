package demo_test.consumerAndProducer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    //测试
    public static void main(String[] args) {

        BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(100);
        Producer p=new Producer(queue);
        Consumer c1=new Consumer(queue);
        Consumer c2=new Consumer(queue);



        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();

    }
}
