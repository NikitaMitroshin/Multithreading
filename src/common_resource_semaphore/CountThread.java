package common_resource_semaphore;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {

    CommonResource commonResource;
    Semaphore semaphore;
    String name;

    public CountThread(CommonResource commonResource, Semaphore semaphore, String name) {
        this.commonResource = commonResource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ожидает разрешения");
            semaphore.acquire(2);
            commonResource.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", name, commonResource.x);
                commonResource.x++;
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        semaphore.release(2);
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
