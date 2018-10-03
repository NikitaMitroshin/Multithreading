public class MyRunnableFinish implements Runnable {

    private boolean isActive; // default value?

    void disable() {
        isActive = false;
    }

    MyRunnableFinish() {
        isActive = true;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));

        int counter = 1;
        while (isActive) {
            System.out.println("loop number = " + counter++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
       /*
       Итак, вначале запускается дочерний поток: new Thread(myThread,"MyThread").start().
       Затем на 1100 миллисекунд останавливаем главный поток и потом вызываем метод myThread.disable(),
       который переключает в потоке флаг isActive. И дочерний поток завершается.
        */
        System.out.println("main thread started");
        MyRunnableFinish myRunnable = new MyRunnableFinish();
        new Thread(myRunnable, "MyRunnable").start();

        try {
            Thread.sleep(2000);

            myRunnable.disable();

//            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("main thread finished");
       /*
       main thread started
       Thread MyRunnable started
       loop number = 1
       loop number = 2
       loop number = 3
       Thread MyRunnable finished
       main thread finished
        */
    }

}
