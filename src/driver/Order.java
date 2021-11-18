package driver;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Represents a product order designed to be placed on a queue by a Producer Thread and
 * removed by a Consumber Thread
 */
public class Order {
    private String origin;
    private String item;
    private int qty;
    private int orderNum;
    // use a class field that is thread safe to initialize the orderNum field
    // thread-safe options for a field (balance, sum)
    // AtomicInteger
    private static AtomicInteger genId = new AtomicInteger(1);

    /**
     *
     * @param origin which thread did the order originate from
     * @param item item ordered
     * @param qty quantity ordered
     */
    public Order(String origin, String item, int qty) {
        this.origin = origin;
        this.item = item;
        this.qty = qty;
        this.orderNum = getNextOrderNum();
    }

    private int getNextOrderNum(){
        // use AtomicInteger genId to initialize order num
       return genId.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Order{" +
                "origin='" + origin + '\'' +
                ", item='" + item + '\'' +
                ", qty=" + qty +
                ", orderNum=" + orderNum +
                '}';
    }
}
