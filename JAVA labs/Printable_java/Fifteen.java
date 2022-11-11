package Printable_java;

public class Fifteen extends Thread {

    public int rand;

    public class Job1 extends Thread {
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rand = (int) (Math.random() * (10 - 0 + 1) + 0);
                System.out.println("Original number " + rand);
            }
        }
    }

    public class Job2 extends Thread {
        public void run() {
            while (true) {
                if (rand % 2 == 0)
                    System.out.println("Squared of original " + rand * rand);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public class Job3 extends Thread {
        public void run() {
            while (true) {
                if (rand % 2 == 1)
                    System.out.println("Cube of original " + rand * rand * rand);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Fifteen obj = new Fifteen();
        obj.new Job1().start();
        obj.new Job2().start();
        obj.new Job3().start();

    }
}
