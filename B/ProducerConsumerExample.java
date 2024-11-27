import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
      BlockingQueue<Task> queue = new LinkedBlockingQueue<>(10);

        Thread producer1 = new Thread(new Producer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
