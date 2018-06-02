import javafx.concurrent.Task;

import java.util.Date;

public class ReadWriteTest {
    
    private static Object LW = new Object();
    private static Object LR = new Object();
    private static String data;
    private static int readCount = 0;

    public static class Reader extends Thread {
        @Override
        public void run() {
            synchronized(LR) {
                readCount++;
            }
            // do something
            synchronized(LR) {
                readCount--;
                notifyAll();
            }
            // do something else
        }

    }
    public static class Writer extends Thread {
        @Override
        public void run() {
          synchronized (LW) {
              synchronized (LR) {
                  if (readCount==0) {
                      // do something
                  }
                  else {
                      while (readCount!=0) {
                          try {
                              LR.wait();
                          } catch (InterruptedException ex) {}
                      }
                  }
              }
          }
        }
    }
}
