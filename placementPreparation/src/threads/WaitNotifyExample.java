package threads;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();
        final boolean flag = false;

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        System.out.println("Waiting thread is waiting.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.println("hello");
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying thread is working.");
                lock.notify();
            }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}

