import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimsAlgo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        int n=sc.nextInt();

        int[][] cost_matrix = new int[n][n];
        

        System.out.println("Enter the cost adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost_matrix[i][j] = sc.nextInt();
            }
        }
        int total_cost = prims(n,cost_matrix);
        System.out.println("Total cost is "+total_cost);


    }

    private static int prims(int n, int[][] cost_matrix) {
        
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>();
        int total_cost=0;
        for(int i=0;i<n;i++){
            vertices.add(i);
        }
        vertices.remove(0);
        visited.add(0);
        for(int i=0;i<n-1;i++){
            int min =999;
            for(int j=0;j<n;j++){
                for(int k=0;j<n;j++){
                    if(cost_matrix[j][k]<min){
                        min=cost_matrix[j][k];
                        visited.add(j);
                        vertices.remove(j);
                    }
                }
            }
            total_cost+=min;
            min=999;
        }
        return total_cost;
    }
    
    private static void display(int[][] tree_matrix,int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(tree_matrix[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    private static boolean isUnvisted(int[] arr){
        for(int x:arr){
            if(x==0){
                return true;
            }
        }
        return false;
    }
}
