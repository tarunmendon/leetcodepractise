package src.interview.citi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintStringWithThreadExecutor {
    private final String str;
    int pos = 0;

    PrintStringWithThreadExecutor(String s) {
        this.str = s;
    }


    public static void main(String[] args) {
        PrintStringWithThreadExecutor obj = new PrintStringWithThreadExecutor("0123456789");
        ExecutorService executorService= Executors.newFixedThreadPool(3);
    for(int i=0;i<3;i++) {
        final int threadId=i;
        executorService.submit(() -> obj.runTask(threadId));
    }
    executorService.shutdown();
        System.out.println("Exiting");
    }

    private void runTask(int threadId) {
        while (true) {
            if (pos >= str.length())
                break;
            synchronized (this) {
                if (pos % 3 == threadId) {
                    System.out.println("Print val:" + this.str.charAt(pos) + " by thread id:" + threadId);
                    pos++;
                    this.notifyAll();
                } else {
                    try {
                        this.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Exiting thread id:" + Thread.currentThread().getName());
    }

}

