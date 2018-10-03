package commonResource;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {

    CommonResource commonResource;
    ReentrantLock lock;

    CountThread(CommonResource commonResource, ReentrantLock lock) {
        this.commonResource = commonResource;
        this.lock = lock;
    }

    @Override
    public void run() {
//        commonResource.increment();
        try {
            lock.lock();
            commonResource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }


//    @Override
//    public void run() {
//        synchronized (commonResource) {
//            commonResource.x = 1;
//
//            for (int i = 1; i < 5; i++) {
//                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
//                commonResource.x++;
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    System.out.println("Thread interrupted " + Thread.currentThread().getName());
//                }
//            }
//        }
//    }
}
