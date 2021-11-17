package producer;

import driver.Order;
import java.util.concurrent.BlockingQueue;

// Producer needs to be a thread
public class Producer implements Runnable {

    private BlockingQueue<Order> queue;


    public Producer(BlockingQueue<Order> queue) {
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
            // Create an order with the Producer's Thread as the origin
            Order o = new Order(Thread.currentThread().getName(), "PS5", 1);
            queue.put(o);
        }catch(InterruptedException e){
            System.out.println("Producer is interrupted!");
        }
        System.out.println(Thread.currentThread().getName() + "is finished!");

    }
}
