public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted");
//        }

        System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        System.out.println("main thread started");
        new Thread(new MyRunnable(), "MyRunnable").start();
        System.out.println("main thread finished");
       /*
       main thread started
       main thread finished
       Thread MyRunnable started
       Thread MyRunnable finished
        */
    }

}
