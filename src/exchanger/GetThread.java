package exchanger;

import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("GetThread получил " + message);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
