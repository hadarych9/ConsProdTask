import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final int period;

    public RateLimiter(int period) {
        this.period = period;
    }

    public void limitAndSchedule(Runnable command) {
        scheduler.scheduleWithFixedDelay(command, period, period, TimeUnit.MILLISECONDS);
    }
}
