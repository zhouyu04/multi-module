package unit.test;

import com.oracle.jrockit.jfr.Producer;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2017/12/18 0018.
 */
public class TestJUC {

    class Producer implements Runnable {
        private final BlockingQueue queue;
        Producer(BlockingQueue q) { queue = q; }
        public void run() {
            try {
                while (true) { queue.put(produce()); }
            } catch (InterruptedException ex) {
                new InterruptedException("生产者抛出异常");
            }
        }
        Object produce() {

        }
    }

    class Consumer implements Runnable {
        private final BlockingQueue queue;
        Consumer(BlockingQueue q) { queue = q; }
        public void run() {
            try {
                while (true) { consume(queue.take()); }
            } catch (InterruptedException ex) { ... handle ...}
        }
        void consume(Object x) { ... }
    }

    @Test
    public void testBlockingQueue(){
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
