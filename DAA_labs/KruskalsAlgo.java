import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class KruskalsAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();

        int[][] cost_matrix = new int[n][n];
        
        System.out.println("Enter the cost adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost_matrix[i][j] = sc.nextInt();
            }
        }

        int total_cost = kurskal(n,cost_matrix);

        //passing the cost adjecency matrix and the number of vertices
        //note: 1-1 costs are not 0 but 999
        System.out.println("Total cost is "+total_cost);
        
    }

    private static int kurskal(int n, int[][] cost_matrix) {
        
        int total_cost = 0;

        //Using treeset to get an array of non repeating, ascending order array of Integers
        TreeSet<Integer> ts = new TreeSet<Integer>();

        //traversing through all elements of cost matrix and adding them to tree set
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                ts.add(cost_matrix[i][j]);
            }
        }

        //converting tree set to Integer array
        Integer[] edgeSet = ts.toArray(new Integer[ts.size()]);
        
        ArrayList<Edge> edge_set=new ArrayList<Edge>();
        
        //
        for(int x=0;x<n-1;x++){
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(cost_matrix[i][j]==edgeSet[x]){
                        Edge e = new Edge(i, j, cost_matrix[i][j]);
                        if(edge_set.isEmpty()){
                            edge_set.add(e);
                            break;
                        }
                        else{
                            for(Edge es:edge_set){
                                if(es.vertex1!=e.vertex2&&es.vertex2!=e.vertex1){
                                    edge_set.add(e);
                                    break;
                                }

                            }
                        }
                    }
                }
            }
        }
        System.out.println("Edges are ");        
        for(Edge e:edge_set){
            total_cost+=e.cost;
            System.out.println(e.vertex1+" "+e.vertex2);
        }   
        return total_cost;
    }    
}

class Edge{
    int vertex1;
    int vertex2;
    int cost;
    Edge(int vertex1,int vertex2, int cost){
        this.vertex1=vertex1;
        this.vertex2= vertex2;
        this.cost = cost;
    }
}
