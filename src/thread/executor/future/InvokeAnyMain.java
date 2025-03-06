package thread.executor.future;

import thread.executor.CallableTask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.log;

public class InvokeAnyMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(10);
        CallableTask taskA = new CallableTask("task1", 1000);
        CallableTask taskB = new CallableTask("task2", 2000);
        CallableTask taskC = new CallableTask("task3", 3000);
        List<CallableTask> tasks = List.of(taskA, taskB, taskC);

        Integer value = es.invokeAny(tasks);
        log("value = " + value);
        es.close();


    }
}
