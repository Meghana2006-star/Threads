class SumThread extends Thread {
    public void run() {
        int i, s = 0;
        for (i = 1; i <= 10; i++) {
            s = s + i;
            System.out.println("Sum: " + s);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("ERROR in SumThread");
            }
        }
    }
}

class ProductThread extends Thread {
    public void run() {
        int i, p = 1; // Initialize p to 1 for correct product calculation
        for (i = 1; i <= 10; i++) {
            p = p * i;
            System.out.println("Product: " + p);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("ERROR in ProductThread");
            }
        }
    }
}

public class ThreadEX {
    public static void main(String[] args) {
        SumThread st = new SumThread();
        ProductThread pt = new ProductThread();
        st.start();
        pt.start();
    }
}