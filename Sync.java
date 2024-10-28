
class Bank {
    int balance;
    boolean status = false;

    Bank(int bal) { 
        balance = bal; 
    }

    synchronized void deposit(int amt) {
        if (status == true) {
            try { 
                wait();
            } catch (Exception e) {}
        }
        balance = balance + amt;
        status = true;
        notify();
    }

    synchronized void withdraw(int amt) {
        if (status == false) {
            try {
                wait();
            } catch (Exception e) {}
        }
        balance = balance - amt;
        status = false;
        notify();
    }

    void display() {
        System.out.println("Balance: " + balance);
    }
}

class DepositThread extends Thread {
    Bank b;

    public DepositThread(Bank b1) {
        b = b1;
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            b.deposit(500);
            b.display();
            try {
                sleep(500);
            } catch (Exception e) {
                System.out.println("Error");
            }
            i++;
        }
    }
}

class WithdrawThread extends Thread {
    Bank b;

    public WithdrawThread(Bank b1) {
        b = b1;
    }

    public void run() {
        int i = 0;
        while (i < 10) {
            b.withdraw(300);
            b.display();
            try {
                sleep(500);
            } catch (Exception e) {
                System.out.println("Error");
            }
            i++;
        }
    }
}

public class Sync {
    public static void main(String args[]) {
        Bank b = new Bank(2000);
        DepositThread d1 = new DepositThread(b);
        WithdrawThread w1 = new WithdrawThread(b);
        d1.start();
        w1.start();
    }
}
