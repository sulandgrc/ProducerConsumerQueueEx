package driver;

import consumer.Consumer;
import producer.Producer;

import java.util.concurrent.*;


public class Driver {

    public static void main(String[] args) throws InterruptedException {
       // create the BlockingQueue that will be shared amond the Producer and Consumer threads
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();
        Thread[] producers = new Thread[3];

        // create and start up Producer Threads pass queue to the Producer Thread Constructor
        for (int i = 1; i <= 3 ; i++) {
            producers[i-1] = new Thread(new Producer(queue), "P"+i );
            producers[i-1].start();

        }

        Thread[] consumers = new Thread[2];
        for (int i = 1; i <= 2 ; i++) {

            // create and start up Consumer Threads pass queue to the Consumer Thread Constructor
            consumers[i-1] = new Thread(new Consumer(queue), "C"+ i );
            consumers[i-1].start();

        }

        // tell the main thread to pause until all producers have finished
        for(Thread t : producers){
            t.join();
        }

        // tell the main thread to pause until all consumers have finished
        for(Thread t : consumers){
            t.join();
        }

        // print out the queue size which indicates how many orders are still in the queue
        System.out.println("Orders left in the queue: " + queue.size());

    }
}
