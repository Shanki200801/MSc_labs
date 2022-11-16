/*-----------------------------------------------------------
Program to demonstrate multithreading 
@Author - Shashank
-------------------------------------------------------------*/
package Final_codes;

public class MultiThreadApp extends Thread {

    public int rand;

    public class Job1 extends Thread {

        // Thread one generates the random integer
        public void run() {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Creates a random number between 0 to 10
                rand = (int) (Math.random() * (10 - 0 + 1) + 0);
                System.out.println("Original number " + rand);
            }
        }
    }

    // Job2 thread squares and displays the generated integer
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

    // job3 cubes and displays the generated integer
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
        MultiThreadApp obj = new MultiThreadApp();
        obj.new Job1().start();
        obj.new Job2().start();
        obj.new Job3().start();

    }
}
