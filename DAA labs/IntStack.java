import java.util.ArrayList;

public class IntStack {
    
    public ArrayList<Integer> array = new ArrayList<>();

    public int pop() throws Exception{
        if(array.isEmpty()){
            System.out.println("Array empty");
            throw new Exception("Array empty");
        }
        int ele = array.get(array.size()-1);
        array.remove(array.size()-1);
        return ele;
    }
    public void push(int ele){
        array.add(ele);
    }
    public void display(){
        System.out.println(array.toString());
    }

    public static void main(String[] args) throws Exception{
        IntStack newStack = new IntStack();
        newStack.push(6);
        newStack.push(5);
        newStack.pop();
        newStack.pop();
        newStack.pop();
        newStack.display();
    }
}
