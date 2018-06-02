import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedCollatzChecker {

    public static class MyRunable implements Runnable {
        long lower;
        long upper;
        Set<Long> verifiedNumbers;

        public MyRunable(long lower, long upper, Set<Long> verifiedNumbers) {
            this.lower = lower;
            this.upper = upper;
            this.verifiedNumbers = verifiedNumbers;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {

            }
            for (long i = lower; i < upper; i++) {
                checkCollatz(i, verifiedNumbers);
            }
        }
    }

    public static boolean checkCollatz(Long n, Set<Long> verifiedNumbers) {
        if (verifiedNumbers.contains(n)) return true;
        Set<Long> sequence = new HashSet<>();
        long largestNumberChecked = -1;
        for (long i = 3; i <= n; i += 2) {
            long j = i;
            sequence.clear();
            while (j >= i) {
                if (sequence.contains(j))
                    return false; // loop found
                sequence.add(j);
                if (verifiedNumbers.contains(j))
                    break;
                j = nextNumber(j);
                if (j>largestNumberChecked) largestNumberChecked = j;
            }
            verifiedNumbers.addAll(sequence);
        }
        System.out.println(n + " largest number checked: " + largestNumberChecked + " verifiedNumbers:" + verifiedNumbers.size());
        return true;
    }

    public static long nextNumber(long currentNumber) {
        if (currentNumber%2==0) return currentNumber/2;
        else return 3*currentNumber+1;
    }

    public static void main(String[] args) {
        int threadPoolSize = 5;
        long numberToGetTo = 50000;
        long blockSize = numberToGetTo/threadPoolSize;
        ExecutorService exe = Executors.newFixedThreadPool(threadPoolSize);
        Set<Long> verifiedNumbers = new HashSet<>();

        TestTimer tt = new TestTimer();
        tt.start();
        for (long i = 0; i < threadPoolSize; i++) {
            exe.execute(new MyRunable(i*blockSize, (i+1)*blockSize, verifiedNumbers));
        }
        exe.shutdown();
        try {
            exe.awaitTermination(3600, TimeUnit.SECONDS);
        } catch (InterruptedException e) {}
        tt.stop();
        System.out.println("Total elapsed time: " + TestTimer.durationToString(tt.getMicroseconds()));
    }
}
