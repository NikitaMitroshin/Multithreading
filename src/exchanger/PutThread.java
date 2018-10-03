package exchanger;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    PutThread(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("PutThread получил " + message);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
