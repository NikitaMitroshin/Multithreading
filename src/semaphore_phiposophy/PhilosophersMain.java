package semaphore_phiposophy;

import java.util.concurrent.Semaphore;

public class PhilosophersMain {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);

        for (int i = 0; i < 6; i++) {
            Philosopher philosopher = new Philosopher(semaphore, i);
            philosopher.start();
        }
    }

}
