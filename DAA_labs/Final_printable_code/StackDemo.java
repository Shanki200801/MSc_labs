/*----------------------------------------------------------------
 @Author: Shashank
 Program to demonstrate and implement the stack data structure
 ------------------------------------------------------------------*/
package Final_printable_code;

import java.util.ArrayList;

public class StackDemo {
    public ArrayList<Integer> array = new ArrayList<>();

    // delete the element at top
    public int pop() throws Exception {
        if (array.isEmpty()) {
            System.out.println("Array empty");
            throw new Exception("Array empty");
        }
        int ele = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return ele;
    }

    // insert element at the top
    public void push(int ele) {
        array.add(ele);
    }

    public void display() {
        System.out.println("Stack Elements :" + array.toString());
    }

    public static void main(String[] args) throws Exception {
        StackDemo newStack = new StackDemo();
        newStack.push(6);
        newStack.push(5);
        newStack.display();
        newStack.pop();
        newStack.pop();
        newStack.display();
    }

}
