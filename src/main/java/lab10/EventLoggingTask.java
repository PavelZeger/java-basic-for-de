package lab10;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

/**
 * @author Pavel Zeger
 */
public class EventLoggingTask implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(EventLoggingTask.class);

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     * @see Thread#run()
     */
    @Override
    public void run() {
        Supplier<String> stringSupplier = () -> new String("Logger logs logging messages");
        logger.info(stringSupplier);
    }
}
