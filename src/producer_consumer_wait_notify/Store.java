package producer_consumer_wait_notify;

public class Store {

    int counter;

    // метод производителя
    synchronized void put() {
        while (counter >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("производитель добавил 1 товар");
        System.out.println("товаров на складе " + counter);
        notify();
    }

    // метод покупателя
    synchronized void get() {
        while (counter < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("покупатель купил 1 товар");
        System.out.println("товаров на складе " + counter);
        notify();
    }
}
