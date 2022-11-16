/*----------------------------------------------------------------
 @Author: Shashank
 Program to demonstrate implementation of a queue
 ------------------------------------------------------------------*/
package Final_printable_code;

public class QueueDemo {
    int front = -1;
    int rear = -1;
    int[] array;

    QueueDemo(int size) {
        this.array = new int[size];
    }

    QueueDemo() {
        this.array = new int[10];
    }

    public int deQueue() {
        if (isQempty()) {
            System.out.println("Queue is empty and cant delete");
            return -1;
        }
        // creating a backup of the deleted element just in case
        int t = array[front];
        if (front == rear) {
            front = rear = -1;
            return t;
        }
        front++;
        return t;
    }

    public void enQueue(int ele) {

        if (isQfull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        // adding the element to therea
        array[rear] = ele;
    }

    public boolean isQempty() {
        if (front == -1)
            return true;
        return false;
    }

    public boolean isQfull() {
        if (front == 0 && rear == array.length - 1)
            return true;
        return false;
    }

    public int peek() {
        return array[front];
    }

    public void display() {
        int i;
        for (i = front; i != rear; i = (++i) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.print(array[i]);
        System.out.println("");
        return;
    }

    public static void main(String[] args) {

        QueueDemo newQueue = new QueueDemo(5);

        newQueue.enQueue(5);
        newQueue.enQueue(9);
        newQueue.enQueue(4);
        newQueue.display();
        newQueue.deQueue();
        newQueue.display();
    }
}
