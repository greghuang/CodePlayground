package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by greghuang on 2018/4/16.
 */
public class FibonacciExample implements Callable<List<Long>> {
    private long number;

    public FibonacciExample(long num) {
        number = num;
    }

    @Override
    public List<Long> call() throws Exception {
        List<Long> fib = new ArrayList<Long>();
        fib.add(0L);
        fib.add(1L);
        for (int i=2; i<number; i++) {
            Long f = fib.get(fib.size()-1) + fib.get(fib.size()-2);
            fib.add(f);
        }
        return fib;
    }

    public static void main(String[] args) {
        Callable<List<Long>> fibonacci = new FibonacciExample(10);
        FutureTask<List<Long>> task = new FutureTask<List<Long>>(fibonacci);

        Thread t = new Thread(task);
        t.start();

        try {
            t.sleep(10);

            boolean canceled = task.cancel(false);
            System.out.println("canceled = " + canceled);

            if (!task.isCancelled()) {
                List<Long> fib = task.get();
                for (Long n: fib) {
                    System.out.print(n + " ");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
