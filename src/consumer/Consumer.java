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

        try {
            Order o = queue.take();
            System.out.println(Thread.currentThread().getName() + " takes off order " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
