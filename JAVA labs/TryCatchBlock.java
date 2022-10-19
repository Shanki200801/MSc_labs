class Outer {
    class Inner {}
}
class ChildOfInner extends Outer.Inner {
    ChildOfInner(Outer o) { 
        o.super(); // if o is null, NPE gets thrown
    }
}

public class TryCatchBlock {
    public static void main(String[] args) {
        try{
            Outer obj1= new Outer();
            ChildOfInner obj = new ChildOfInner(null);
        }
        catch(NullPointerException npe){
            //System.out.println(npe);
            npe.printStackTrace();
        }
        finally{
            System.out.println("FInally block executed");
        }
    }
    
}