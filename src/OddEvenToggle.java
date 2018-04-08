public class OddEvenToggle {
    static final public boolean ODD = false;
    static final public boolean EVEN = true;
    private boolean current = ODD;

    public synchronized void waitTurn(boolean mode) {
        while (mode!=current) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println("Interrupted!!");
                return;
            }
        }
    }

    public synchronized void toggleLockMode() {
        current ^= true;
        notifyAll();
    }

    public static class OddThread extends Thread {
        private OddEvenToggle toggleMonitor = new OddEvenToggle();

        public OddThread(OddEvenToggle tooggle) {
            this.toggleMonitor = tooggle;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100 ; i+=2) {
                toggleMonitor.waitTurn(OddEvenToggle.ODD);
                System.out.println(" Odd " + i);
                toggleMonitor.toggleLockMode();
            }
        }
    }

    public static class EvenThread extends Thread {
        private OddEvenToggle toggleMonitor = new OddEvenToggle();

        public EvenThread(OddEvenToggle tooggle) {
            this.toggleMonitor = tooggle;
        }

        @Override
        public void run() {
            for (int i = 2; i <= 100 ; i+=2) {
                toggleMonitor.waitTurn(OddEvenToggle.EVEN);
                System.out.println("  Even " + i);
                toggleMonitor.toggleLockMode();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddEvenToggle toggle = new OddEvenToggle();
        Thread t1 = new OddThread(toggle);
        Thread t2 = new EvenThread(toggle);

        t2.start();
        Thread.sleep(5000);
        t1.start();

        t1.join();
        t2.join();

    }

}
