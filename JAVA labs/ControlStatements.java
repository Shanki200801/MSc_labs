import java.util.Scanner;

public class ControlStatements {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number of people");
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        sc.nextLine();
        int[] ages= new int[n];
        String[] names= new String[n];
       
        for(int i =0;i<n;i++){
            System.out.println("Enter the names of person numer "+i);
            names[i]=sc.nextLine();
            //sc.nextLine();
            System.out.println("Enter the age of "+names[i]);
            ages[i]=sc.nextInt();
            sc.nextLine();
        }
        for(int j=0;j<n;j++){
            if(ages[j]>17){
                System.out.println(names[j]+" is eligible to vote");
            }
        }
    }
}


