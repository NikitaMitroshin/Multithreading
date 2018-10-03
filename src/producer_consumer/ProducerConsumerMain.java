package producer_consumer;

public class ProducerConsumerMain {

    public static void main(String[] args) {
        Store store = new Store();

        new Producer(store).start();
        new Producer(store).start();
        new Producer(store).start();
        new Consumer(store).start();
        new Consumer(store).start();
        new Consumer(store).start();
    }

}
