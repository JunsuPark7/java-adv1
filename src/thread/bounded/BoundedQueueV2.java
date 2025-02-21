package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue {

    //데이터를 중간에 보관하는 버퍼로 큐를 사용한다.
    private final Queue<String> queue = new ArrayDeque<>();
    //한정된 버퍼 이므로 최대 크기 지정한다.
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    //큐에 데이터를 저장한다. 큐가 가득 찬 경우 더는 데이터를 보관할 수 없으므로 데이터를 버린다.
    @Override
    public synchronized void put(String data) {

        while (queue.size() == max) {
            log("[put] 큐가 가득 참. 생산자 대기");
            sleep(1000);
        }
        queue.offer(data);
    }
    //객체에 모니터락을 획득 하니깐 스레드가 접근 할 때, 아예 객체 접근에 blocked를 거는거라서?

    //여기서 핵심은 p3 스레드가 락을 가지고 있는 상태에서, 큐에 빈 자리가 나올 때 까지 대기한다는 점이다.
    //락을 가지고 있는 상태에서 큐에 빈자리 나올때 까지 대기함.
    //객체에 모니터락을 걸어버려서,다른 스레드는 take나 put 이런거에 다 접근 불가능함.

    //큐의 데이터를 가져간다. 큐에 데이터가 없는 경우 null을 반환한다.
    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }


}
