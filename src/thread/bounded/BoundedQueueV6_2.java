package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private BlockingQueue<String> queue;


    public BoundedQueueV6_2(int max) {
        queue= new ArrayBlockingQueue<>(max);
    }

    //큐에 데이터를 저장한다. 큐가 가득 찬 경우 더는 데이터를 보관할 수 없으므로 데이터를 버린다.
    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result);

    }


    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }


}
