package producer_consumer_lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    ReentrantLock lock;
    Condition condition;
    int counter;

    public Store() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    // метод производителя
    void put() {
        try {
            lock.lock();

            while (counter >= 3) {
                condition.await();
            }
            counter++;
            System.out.println("производитель добавил 1 товар");
            System.out.println("товаров на складе " + counter);

            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // метод покупателя
    void get() {
        try {
            lock.lock();

            while (counter < 1) {
                condition.await();
            }
            counter--;
            System.out.println("покупатель купил 1 товар");
            System.out.println("товаров на складе " + counter);
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
