package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue {

    //데이터를 중간에 보관하는 버퍼로 큐를 사용한다.
    private final Queue<String> queue = new ArrayDeque<>();
    //한정된 버퍼 이므로 최대 크기 지정한다.
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    //큐에 데이터를 저장한다. 큐가 가득 찬 경우 더는 데이터를 보관할 수 없으므로 데이터를 버린다.
    @Override
    public synchronized void put(String data) {
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림: " + data);
            return;
        }
        queue.offer(data);
    }

    //큐의 데이터를 가져간다. 큐에 데이터가 없는 경우 null을 반환한다.
    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }


}
