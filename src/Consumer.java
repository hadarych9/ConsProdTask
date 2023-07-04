import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Product> queue;

    private final int slowRate;

    public Consumer(BlockingQueue<Product> queue, int slowRate) {
        this.queue = queue;
        this.slowRate = slowRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(slowRate);
                System.out.println("Получен " + queue.take().getName());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
