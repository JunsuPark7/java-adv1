package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");


        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);
        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);
        log("End");
    }

    static class SumTask implements Runnable {

        private int startNum;
        private int endNum;

        int result = 0;

        public SumTask(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startNum; i <= endNum; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result=" + result);
        }
    }
}
