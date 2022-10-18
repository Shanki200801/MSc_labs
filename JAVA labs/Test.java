import java.util.Scanner;
import DataStructures.intCQueue;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of circular queue");
        int n=sc.nextInt();
        intCQueue q = new intCQueue(n);

        q.enQueue(5);
        q.deQueue();
        q.enQueue(10);
        q.enQueue(40);
        System.out.println("The queue is");
        q.display();
    }
}