package demo_test.consumerAndProducer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

    public class Producer implements Runnable{

        private final BlockingQueue<Integer> queue;



        public Producer(BlockingQueue q){
            this.queue=q;
        }



        @Override
        public void run() {

            try {
                while (true){
                    Thread.sleep(1000);//模拟耗时
                    queue.put(produce());

                }

            }catch (InterruptedException e){



            }

        }



        private int produce() {

            int n=new Random().nextInt(10000);

            System.out.println("Thread:" + Thread.currentThread().getId() + " produce:" + n);

            return n;

        }

    }


