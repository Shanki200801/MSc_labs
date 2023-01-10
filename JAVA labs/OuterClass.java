/**
 * OuterClass
 */
public class OuterClass {

    public static void main(String[] args) {
        System.out.println("Outer main");
    }

    public static class InnerClass {
        public static void main(String[] args) {
            System.out.println("Inner main");
        }
    }
}