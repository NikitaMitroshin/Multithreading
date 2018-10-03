package producer_consumer;

public class Producer extends Thread {

    Store store;
    int product = 5;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product > 0) {
                product = product - store.put();
                System.out.println("осталось произвести " + product + " товаров");
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
