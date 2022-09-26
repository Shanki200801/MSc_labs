public class CLArgs {
    public static void main (String[] args){
        
        try{
        double max = Double.parseDouble(args[0]);
        double min = Double.parseDouble(args[0]);
        
        for(String ele: args){
            if(Double.parseDouble(ele)>max){
                max = Double.parseDouble(ele);
            }
            if(Double.parseDouble(ele)<min){
                min = Double.parseDouble(ele);
            }
        }
        System.out.println("The length of the given array is "+args.length);
        System.out.println("maximum of the given arguments is "+max);
        System.out.println("minimum of the given arguments is "+min);
    }
    catch(Exception e){
        System.out.println("Error occured");
    }
    }
}
