import java.util.ArrayList;
import java.util.Scanner;

public class GraphSearching {

    int n;
    boolean[] visited;
    GraphSearching(int n){     
        visited= new boolean[n];
    }   
    ArrayList<Integer> traversal_arr = new ArrayList<>();
   
    int front = 0;

    void rBFS(int[][] cost_matrix, int start_node){
        this.visited[start_node]=true;
        if(!traversal_arr.contains(start_node))
            traversal_arr.add(start_node);
        
            for(int i =0;i<n;i++){
                if(cost_matrix[start_node][i]!=999 && !visited[i]){
                    if(!traversal_arr.contains(i))
                        traversal_arr.add(i);
                }
            }
            if(traversal_arr.size()>front+1)
                rBFS(cost_matrix, traversal_arr.get(++front));
        

    }

    void DFS(int[][] cost_matrix,int start_node){
        this.visited[start_node]=true;
        traversal_arr.add(start_node);
        if(isUnvisted(visited)){
            for(int i=0;i<n;i++){
                if(cost_matrix[start_node][i]!=999 && !visited[i]){
                    DFS(cost_matrix,i);
                }
            }
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        
        int[][] cost_matrix = new int[n][n];
        
        System.out.println("Enter the cost adjacency matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cost_matrix[i][j] = sc.nextInt();
                if(i==j){
                    cost_matrix[i][j]=999;
                }
            }
        }
        
        System.out.println("Enter starting node");
        int s_node = sc.nextInt();

        GraphSearching gs1 = new GraphSearching(cost_matrix.length);
        gs1.rBFS(cost_matrix,s_node);
        System.out.println("Traversal order in breadth first search is "+(gs1.traversal_arr));

        GraphSearching gs2 = new GraphSearching(cost_matrix.length);
        gs2.DFS(cost_matrix,s_node);
        System.out.println("Traversal order in depth first search is "+(gs2.traversal_arr));
        
    }   
}
