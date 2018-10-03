package semaphore_phiposophy;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    Semaphore semaphore;
    int num = 0; //колво приемов пищи
    int id;

    Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire();
                System.out.println(String.format("философ %s садится за стол", id));
                sleep(1000);
                System.out.println();
                num++;
                System.out.println(String.format("философ %s выходит из-за стола", id));
                semaphore.release();
                System.out.println();
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа проблемы");
        }
    }


}
