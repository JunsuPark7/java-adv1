package thread.bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable{

    //데이터를 생성하는 생성자 스레드가 실행하는 클래스.
    //스레드를 실행하면, queue.put(request)를 호출해서 전달된 데이터를 request를 큐에 보관함.
    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }


    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 완료] " + request + " -> " + queue);
    }
}
