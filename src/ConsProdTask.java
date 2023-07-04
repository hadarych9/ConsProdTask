import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsProdTask {

    private static final int timer = 2000;

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter(timer);

        BlockingQueue<Product> commonQueue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(commonQueue, limiter);
        Thread consThread = new Thread(new Consumer(commonQueue, timer));

        producer.produce();
        consThread.start();
    }
}
