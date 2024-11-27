import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private final BlockingQueue<Task> queue;
    private static final AtomicInteger taskCounter = new AtomicInteger(0);

    public Producer(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int taskId = taskCounter.incrementAndGet();
                Task task = new Task(taskId, "Task description " + taskId);
                queue.put(task);
                System.out.println("Produced: " + task);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer interrupted.");
        }
    }
}
