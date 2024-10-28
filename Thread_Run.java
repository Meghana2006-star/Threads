class SumThread implements Runnable {
    public void run() {
        int i, s = 0;
        for (i = 1; i <= 10; i++) {
            s = s + i;
            System.out.println("Sum: " + s);
        }
    }
}

public class Thread_Run {
    public static void main(String[] args) {
        SumThread st = new SumThread();
        Thread t1 = new Thread(st);
        t1.start();
    }
}