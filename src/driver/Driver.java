package driver;

import consumer.Consumer;
import producer.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {

    public static void main(String[] args) {
       // create the BlockingQueue that will be shared amond the Producer and Consumer threads
        BlockingQueue<Order> queue = new ArrayBlockingQueue<>(100);

        // create and start up Producer Threads pass queue to the Producer Thread Constructor
        Thread p = new Thread(new Producer(queue), "P1" );
        p.start();

        // create and start up Consumer Threads pass queue to the Consumer Thread Constructor
        Thread c = new Thread(new Consumer(queue), "C1" );
        c.start();

    }
}
