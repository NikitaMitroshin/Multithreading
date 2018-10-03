public class MyThread extends Thread {
//public class MyThread {
    // сперва просто это
//    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        System.out.println(thread);
//    // Thread[main,5,main]
//    //        Первое main -  имя потока (что можно получить через t.getName()),
//    // второе значение 5 предоставляет приоритет потока (также можно получить через t.getPriority()),
//    // и последнее main представляет имя группы потоков, к которому относится текущий - по умолчанию также main
//    // (также можно получить через t.getThreadGroup().getName())
//    }


    public MyThread(String name) {
        super(name);
    }


    //метод run(), код которого собственно и будет представлять весь тот код, который выполняется в потоке.
    @Override
    public void run() {
        System.out.println(String.format("Thread %s started", Thread.currentThread().getName()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println(String.format("Thread %s finished", Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        System.out.println("main thread started");
//        threadsOrder();
        threadsToSeeStackInDebug();
//        joinUsage();
        System.out.println("main thread finished");
    }

    public static void threadsOrder() {
        MyThread myThread = new MyThread("MySampleThread");
        myThread.start(); // вызываем старт который вызовет ран
       /* вывод
           main thread started
           main thread finished
           Thread MySampleThread started
           Thread MySampleThread finished
        */
    }

    /*
        Каждому потоку соответствует свой собственный стек в памяти, где хранятся все локальные переменные и ряд других данных,
        связанных с выполнением потока. Это значит, чем больше памяти потоков работает, тем больше памяти используется.
        Важно отметить, что размеры памяти ограничены и в некоторых системах ограничено и количество допустимых потоков.
        В случае, когда ограничения нет, обязательно будет ограничение по умолчанию в видео максимальной скорости работы процессора.
     */
    public static void threadsToSeeStackInDebug() {
        MyThread myThread = new MyThread("MySampleThread");
        myThread.start();

        MyThread myThread2 = new MyThread("MySampleThread2");
        myThread2.start();
    }

    //
    public static void joinUsage() {
//        System.out.println("main thread started");
        MyThread myThread = new MyThread("MySampleThread");
        myThread.start();

        try {
            myThread.join(); // Метод join() заставляет вызвавший поток ожидать завершения вызываемого потока, для которого и применяется метод join.
        } catch (InterruptedException e) {
            System.out.println(String.format("Thread %s interrupted", myThread.getName()));
        }

//        System.out.println("main thread finished");
    }


}
