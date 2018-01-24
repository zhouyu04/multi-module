package unit.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2018/1/16 0016.
 */
public class TestThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println(executorService.toString());
        executorService.execute(new Producor());
        executorService.execute(new Producor());
        executorService.execute(new Producor());
        executorService.execute(new Producor());
        executorService.execute(new Producor());
        System.out.println(executorService.toString());
    }

    static class Producor implements Runnable{

        public void run() {
            Consummer consummer = new Consummer();
            consummer.say();
        }
    }

    static class Consummer{
        int i = 0;
        public void say(){
            i++;
            System.out.println(i+"-say:"+Thread.currentThread().getName());
        }

    }
}
