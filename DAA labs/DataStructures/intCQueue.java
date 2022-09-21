package DataStructures;

/**
 * intCQueue
 */
public class intCQueue extends intQueue  {
    intCQueue(int size){
        super(size);    
   }
   intCQueue(){
    super();
   }

   @Override
   public int deQueue() {
    int t;
    if(isQempty()){
       System.out.println("Cant delete because the queue is empty");
       return -1;
    }
    if(front==rear){
        t=array[front];
        front=-1;rear=-1;
    }
    t=array[front];
    front++;
    return t;      
   }

   @Override
   public void enQueue(int ele) {
       
    if(isQfull()){
        System.out.println("queue is full");
        return;
    }
    if(front==-1 && rear==-1){
        front=0;
    }
    if(rear==array.length-1){
        rear=0;
    }
    else{
        rear++;
    }
    
    array[rear]=ele;
        
   }

   @Override
   public boolean isQfull() {
        if((front==0 && rear ==array.length-1)|| (rear+1==front)){
            return true;
     } 
        return false;
   }

   @Override
   public boolean isQempty() {
       return super.isQempty();
   }

   

   public static void main(String[] args) {
    intCQueue newcq= new intCQueue(3);
    newcq.enQueue(5);
    newcq.enQueue(4);
    newcq.enQueue(3);
    newcq.display();
    newcq.deQueue();
    newcq.enQueue(2);
    newcq.display();
   }

    
}