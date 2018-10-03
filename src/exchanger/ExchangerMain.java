package exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMain {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();
//        new Thread(new PutThread(exchanger, "Put Thread message")).start();
        exchanger.exchange("lol");
        new Thread(new GetThread(exchanger, "Get Thread message")).start();
    }

}
