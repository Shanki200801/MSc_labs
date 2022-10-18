import java.util.Scanner;

/**
 * DegreeOfNode
 */
public class DegreeOfNode {

    private static int[] getDegreeArray(int[][] cost_matrix){
        int n=cost_matrix.length;
        int[] degree_array=new int[n];       
        for(int i=0;i<n;i++){
            int local_count = 0;
            for(int j=0;j<n;j++){
                if(cost_matrix[i][j]!=999 && cost_matrix[i][j]>=0){
                    local_count++;
                }
            }
            degree_array[i]=local_count;
        }
        return degree_array;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        int n=sc.nextInt();

        int[][] cost_matrix = new int[n][n];
        
        System.out.println("Enter the cost adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost_matrix[i][j] = sc.nextInt();
                //idiot proofing to allow 0 as input in vertex to itself
                if(i==j){
                    cost_matrix[i][j]=999;
                }
            }
        }

        int[] cost_array = getDegreeArray(cost_matrix);
        for(int i=0;i<n;i++){
            System.out.println("the degree of node "+i+" is "+cost_array[i]);
        }
    }
}