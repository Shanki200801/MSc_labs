package DataStructures;

public class intQueue {
    
    int front = -1;
    int rear = -1;
    int[] array;
    intQueue(int size){
         this.array = new int[size];    
    }
    intQueue(){
         this.array = new int[10];
    }
    
    
    public int deQueue(){
        if(isQempty()){
            System.out.println("Queue is empty and cant delete");
            return -1;
        }
        int t = array[front];
        if(front==rear){
            front=rear=-1;
            return t;
        }      
        front++;
        return t;
    }

    public void enQueue(int ele){
        
        if(isQfull()){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front=0;    
        }
        rear++;
        array[rear]= ele;
    } 

    public boolean isQempty(){
        if(front==-1)return true;
        return false;
    }

    public boolean isQfull(){
        if(front==0&&rear==array.length-1)
            return true;
        return false;
    }

    public int peek(){
        return array[front];
    }

    public void display(){
        int i;
        for (i = front; i != rear; i = (++i) % array.length){
            System.out.print(array[i]+" ");
        }
        System.out.print(array[i]);
        System.out.println("");
        return;
    }

    public static void main(String[] args) {
        
        intQueue newQueue = new intQueue(5);

        newQueue.enQueue(5);
        newQueue.enQueue(9);
        newQueue.enQueue(4);
        newQueue.enQueue(29);      
        newQueue.enQueue(2);
        newQueue.enQueue(6);
        newQueue.deQueue();
        newQueue.display();
    }
}