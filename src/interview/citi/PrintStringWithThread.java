package src.interview.citi;

public class PrintStringWithThread implements Runnable {
    private final String str;
    int pos = 0;

    PrintStringWithThread(String s) {
        this.str = s;
    }


    public static void main(String[] args) {
        PrintStringWithThread obj = new PrintStringWithThread("0123456789");
        Thread t1 = new Thread(obj, "0");
        Thread t2 = new Thread(obj, "1");
        Thread t3 = new Thread(obj, "2");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Exiting");
    }

    @Override
    public void run() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        while (true) {
            if (pos >= str.length())
                break;
            synchronized (this) {
                if (pos % 3 == id) {
                    System.out.println("Print val:" + this.str.charAt(pos) + " by thread id:" + id);

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

