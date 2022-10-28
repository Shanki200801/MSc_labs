package Final_printable_code;

/*Program to find the total number of edges connected to a node  */
/*Works on both directed and non directed graphs */

import java.util.Scanner;

public class NodeDegree {

    //private method to input edge_matrix and output the degree array of nodes 
    private static int[] getDegreeArray(int[][] edge_matrix){
        int n=edge_matrix.length;
        int[] degree_array=new int[n];       
        for(int i=0;i<n;i++){
            int local_count = 0;
            for(int j=0;j<n;j++){
                if(edge_matrix[i][j]!=999 && edge_matrix[i][j]>=0){
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

        int[][] edge_matrix = new int[n][n];
        
        System.out.println("Enter the edge adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                edge_matrix[i][j] = sc.nextInt();
                //idiot proofing to allow 0 as input in vertex to itself
                if(i==j){
                    edge_matrix[i][j]=999;
                }
            }
        }

        int[] cost_array = getDegreeArray(edge_matrix);
        for(int i=0;i<n;i++){
            System.out.println("the degree of node "+i+" is "+cost_array[i]);
        }
    }
}