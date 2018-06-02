public class Semaphore {
    private final int CAPACITY;
    private int inUse;

    public Semaphore(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.inUse = 0;
    }

    public synchronized void acquire() throws InterruptedException {
        while (inUse==CAPACITY) {
            wait();
        }
        inUse++;
    }

    public synchronized void release() throws InterruptedException {
        inUse--;
        notifyAll();
    }

}
