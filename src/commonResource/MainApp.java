package commonResource;

import java.util.concurrent.locks.ReentrantLock;

public class MainApp {

    public static void main(String[] args) {
       /*
       Определенный класс CommonResource представляет общий ресурс. В нем определено одно целочисленное поле x.
       Класс потока CountThread, используя этот ресурс, просто увеличивает в цикле значение x на единицу.
       Причем при входе в поток значение x = 1:
       То есть в итоге мы ожидаем, что после выполнения цикла res.x будет равно 4.
       В главном классе программы запускается пять потоков.
       То есть мы ожидаем, что каждый поток будет увеличивать res.x с 1 до 4 и так пять раз.
        */

        CommonResource commonResource = new CommonResource();
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(commonResource, reentrantLock));
            t.setName("Thread " + i);
            t.start();
        }

    }

}
