class Prime extends Thread {
    public void run() {
        for (int num = 1; num <= 10; num++) {
            boolean isPrime = true;
            if (num < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) { // Fixed prime checking condition
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                System.out.println("Prime: " + num);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Error in Prime thread");
                }
            }
        }
    }
}

class Factor extends Thread {
    public void run() {
        for (int num = 1; num <= 20; num++) {
            System.out.print("Factors of " + num + ": ");
            for (int i = 1; i <= num; i++) {  // Changed i=0 to i=1 to avoid division by zero
                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error in Factor thread");
            }
        }
    }
}

public class PrimeFactor {  // Ensure this class is public and contains the main method
    public static void main(String[] args) {
        Prime p = new Prime();
        Factor f = new Factor();
        p.start();
        f.start();
    }
}