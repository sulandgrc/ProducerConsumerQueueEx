package consumer;

import driver.Order;

import java.util.concurrent.BlockingQueue;

// Consumer has to be a thread
public class Consumer implements Runnable{

    private BlockingQueue<Order> queue;

    public Consumer(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // consumer thread should run for 1 seconds
        try {
            long timeStart = System.currentTimeMillis();
            do {
                Order o = queue.take();
                System.out.println(Thread.currentThread().getName() + " takes off " + o);
            } while(System.currentTimeMillis() - timeStart <= 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is finished!");
    }
}
