package concurency;

public class MAin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyTask("Thread 1"));
        Thread thread2 = new Thread(new MyTask("Thread 2"));
        Thread thread3 = new Thread(new MyTask("Thread 3"));
        try {
            thread1.start();
            thread2.start();

            // Thread 1 and Thread 2 will run concurrently
            thread1.join();// Main thread waits for Thread 1 to finish

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();

        try {
            thread3.join(); // Main thread waits for Thread 3 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed their tasks.");
    }

    public static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " - Step " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}