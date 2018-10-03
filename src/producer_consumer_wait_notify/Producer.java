package producer_consumer_wait_notify;

public class Producer implements Runnable {

    Store store;

    Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.put();
        }
    }
}
