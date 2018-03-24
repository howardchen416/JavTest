import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Howard on 11/12/2014.
 */
public class WaitingForMeaningOfLife {
    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {
        public void run() {
            ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
                public DateFormat initialValue() {
                    return new SimpleDateFormat("yyyy-MM-dd");
                }
            };
            while (!ready) {
                Thread.yield();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            return;
        }
        number = 42;
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            return;
        }
        ready = true;
    }
}
