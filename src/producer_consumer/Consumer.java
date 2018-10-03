package producer_consumer;

public class Consumer extends Thread {

    Store store;
    int product = 0;

    Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product < 5) {
                product = product + store.get();
                System.out.println("куплено " + product + " товаров");
                sleep(100);
            }
            System.out.println("потребитель " + getName() + " закупился");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
