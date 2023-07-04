import java.util.concurrent.BlockingQueue;

public class Producer {

    private final BlockingQueue<Product> queue;

    private final RateLimiter limiter;

    public Producer(BlockingQueue<Product> queue, RateLimiter limiter) {
        this.queue = queue;
        this.limiter = limiter;
    }

    public void produce() {
        limiter.limitAndSchedule(() -> {
            Product product = new Product();
            System.out.println("Произведен " + product.getName());
            try {
                queue.put(product);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
