import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of objects");
        n=sc.nextInt();
        SackObject[] ObjArray = new SackObject[n];
        
        for(int i=0;i<n;i++){
            ObjArray[i] = new SackObject();
            System.out.println("Enter the weight and profit of object : "+i);
            ObjArray[i].weight=sc.nextInt();
            ObjArray[i].profit=sc.nextInt();
            ObjArray[i].objid = i;
            ObjArray[i].profit_weight_ratio = (double) (ObjArray[i].profit/ObjArray[i].weight);
            ObjArray[i].fraction = 0.0;
        }
        System.out.println("\nEnter the max capactiy of the knapsack");
        Double max_cap = sc.nextDouble();
        Double max_profit = 0.0;
        //according to weight
        Arrays.sort(ObjArray,(a,b)->a.weight.compareTo(b.weight));
        System.out.println("\nAccording to weight");
        max_profit= knapsackSolve(ObjArray, max_cap);
        int flag = 0;
        //according to profit
        Arrays.sort(ObjArray,(a,b)->a.profit.compareTo(b.profit));
        System.out.println("\nAccording to profit");
        if(knapsackSolve(ObjArray, max_cap)>max_profit){
            max_profit= knapsackSolve(ObjArray, max_cap);
            flag=2;
        }
        //according to profit weight ratio
        Arrays.sort(ObjArray,(a,b)->a.profit_weight_ratio.compareTo(b.profit_weight_ratio));
        System.out.println("\nAccording to ratio");
        if(knapsackSolve(ObjArray, max_cap)>max_profit){
            max_profit= knapsackSolve(ObjArray, max_cap);
            flag=3;
        }

        if(flag==3){
            System.out.println("solution set is obtained when arranged acc to ratio\n");
        }
        if(flag==2){
            System.out.println("solution set is obtained when arranged acc to profit\n");
        }
        if(flag==1){
            System.out.println("solution set is obtained when arranged acc to weight\n");
        }
        System.out.printf("Maximum profit possible is %.2f\n",max_profit);
        

        
 
              
    }

    private static Double knapsackSolve(SackObject[] objArray, Double max_cap) {

        

        for(int i=0;i<objArray.length;i++){
            if(objArray[i].weight<=max_cap){
                objArray[i].fraction=1.0;
                max_cap=max_cap-objArray[i].weight;
            }
            else{
                objArray[i].fraction = max_cap/objArray[i].weight;
                break;
            }
        }
        double total_profit=0.0;
        System.out.println("solution set is ");
        for(SackObject obj: objArray){
            System.out.printf("%.2f, ",obj.fraction);
            total_profit+= obj.fraction*obj.profit;
        }

        return total_profit;

    }
    
}

class SackObject{
    Integer weight;
    Integer profit;
    Integer objid;
    Double profit_weight_ratio;
    Double fraction;
}
