import java.util.ArrayList;
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
                //idiot proofing to allow 0 as input in vertex to itself
                if(i==j){
                    cost_matrix[i][j]=999;
                }
            }
        }
        int total_cost = prims(n,cost_matrix);
        System.out.println("Total cost is "+total_cost);
    }

    private static int prims(int n, int[][] cost_matrix) {
        
        boolean[] visited = new boolean[n];
        ArrayList<Edge> edge_list = new ArrayList<>();

        int total_cost=0;
        //creating vertices and visited arrays
        //default values of booleans are false hence all are unvisted
        visited[0]=true;

        while(isUnvisted(visited)){
            int min = 999; //local minima
            int local_min_index=-1;
            int edge_start = -1;
            //parsing through visited nodes
            for(int i=0;i<n;i++){
                if(visited[i]){
                    //parsing through all edges of visited
                    for(int j=0;j<n;j++){
                        if(cost_matrix[i][j]<=min && !visited[j]){
                            //when we find a edge cost which is smaller the minima
                            min = cost_matrix[i][j];
                            edge_start=i;
                            local_min_index=j;
                        }
                    }
                }
            }

            //Using the edge class in KruskalsAlgo.java
            Edge e = new Edge(edge_start, local_min_index);
            edge_list.add(e);
            visited[local_min_index]=true;
            total_cost+=min;
            //reassigning local minima to 999
            min=999;
            
        }
        displayEdges(edge_list);
        return total_cost;
    }
        

    private static void displayEdges(ArrayList<Edge> arr) {
        System.out.println("Edges are");
        for(Edge e:arr){
            System.out.println("( "+e.vertex1+" -- "+e.vertex2+" )");
        }
    }

    private static boolean isUnvisted(boolean[] arr){
        for(boolean x:arr){
            if(x==false){
                return true;
            }
        }
        return false;
    }
}

