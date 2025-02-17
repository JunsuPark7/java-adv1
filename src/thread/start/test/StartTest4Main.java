package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Thread threadA = new Thread(new MyThread("A", 1000), "Thread-A");
        Thread threadB = new Thread(new MyThread("B", 500), "Thread-B");

        threadA.start();
        threadB.start();


    }

    static class MyThread implements Runnable {

        private String threadName;
        private int threadTime;

        public MyThread(String threadName, int threadTime) {
            this.threadName = threadName;
            this.threadTime = threadTime;
        }

        @Override
        public void run() {
            while (true) {
                log(threadName);
                try {
                    Thread.sleep(threadTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }





}
