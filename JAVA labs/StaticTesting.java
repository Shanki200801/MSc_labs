
class OuterClass{
    private int private_x;
    int default_y;
    static int static_z;
    static class InnerStatic{
        int newint = static_z;
    }
    class InnerClass{
        int newint = private_x;
        int newnewint = default_y;
    }
}


public class StaticTesting {
    public static void main(String[] args) {
        OuterClass outer_obj = new OuterClass();
        OuterClass.InnerClass inner_obj = outer_obj.new InnerClass();
        OuterClass.InnerStatic inner_static_obj = new OuterClass.InnerStatic();
    }
    
}