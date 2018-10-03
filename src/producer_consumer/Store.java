package producer_consumer;

public class Store {

    int counter = 0;
    final int N = 5;

    // метод производителя
    synchronized int put() {
        if (counter <= N) {
            counter++;
            System.out.println("в магазине " + counter + " товаров");
            return 1;
        }
        return 0;
    }

    // метод покупателя
    synchronized int get() {
        if (counter > 0) {
            counter--;
            System.out.println("в магазине осталось" + counter + " товаров");
            return 1;
        }
        return 0;
    }
}
