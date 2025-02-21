package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV6_1 implements BoundedQueue {

    private BlockingQueue<String> queue;


    public BoundedQueueV6_1(int max) {
        queue= new ArrayBlockingQueue<>(max);
    }

    //큐에 데이터를 저장한다. 큐가 가득 찬 경우 더는 데이터를 보관할 수 없으므로 데이터를 버린다.
    @Override
    public void put(String data) {
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String take() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }


}
