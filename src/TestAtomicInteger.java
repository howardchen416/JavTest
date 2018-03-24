import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Howard on 11/12/2014.
 */
public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int a;
        boolean b;
        for(int i=0; i<10; i++) {
            System.out.println(ai.incrementAndGet());
        }
    }
}
