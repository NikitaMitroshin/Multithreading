package producer_consumer_wait_notify;

public class ProducerConsumerMain {

    public static void main(String[] args) {
        Store store = new Store();

        new Thread(new Producer(store)).start();
        new Thread(new Producer(store)).start();
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();
        new Thread(new Consumer(store)).start();
        new Thread(new Consumer(store)).start();
    }

}
