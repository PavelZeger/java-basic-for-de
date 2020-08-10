package lab10;

/**
 * @author Pavel Zeger
 */
public class MainLab10 {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <= 200000000; i++) {
            EventLoggingTask event = new EventLoggingTask();
            Thread thread = new Thread(event, "event_" + i);
            thread.start();
            System.out.println(thread.getState());
            System.out.println(thread.getName());
        }

    }
}
