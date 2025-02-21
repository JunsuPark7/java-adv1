package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;


    public BoundedQueueV6_4(int max) {
        queue= new ArrayBlockingQueue<>(max);
    }

    //큐에 데이터를 저장한다. 큐가 가득 찬 경우 더는 데이터를 보관할 수 없으므로 데이터를 버린다.
    public void put(String data) {
        queue.add(data); // java.lang.IllegalStateException: Queue full
    }
    public String take() {
        return queue.remove(); // java.util.NoSuchElementException
    }

    @Override
    public String toString() {
        return queue.toString();
    }


}
