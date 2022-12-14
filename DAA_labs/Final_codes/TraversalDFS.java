/*----------------------------------------------------------------
 @Author: Shashank
 Program to find the degree of a node for a given graph
 ------------------------------------------------------------------*/
package Final_codes;

import java.util.ArrayList;
import java.util.Scanner;

public class TraversalDFS {

    int n;
    boolean[] visited;

    TraversalDFS(int n) {
        visited = new boolean[n];
    }

    ArrayList<Integer> traversal_arr = new ArrayList<>();

    int front = 0;

    void DFS(int[][] cost_matrix, int start_node) {
        n = cost_matrix.length;
        this.visited[start_node] = true;
        traversal_arr.add(start_node);
        if (isUnvisted(visited)) {
            for (int i = 0; i < n; i++) {
                if (cost_matrix[start_node][i] != 999 && !visited[i]) {
                    // if the neighbour is not visited then call dfs on it
                    DFS(cost_matrix, i);
                }
            }
        }
    }

    // checks if there are unvisited vertices remaining
    private static boolean isUnvisted(boolean[] arr) {
        for (boolean x : arr) {
            if (x == false) {
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

        System.out.println("Enter the edge matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = sc.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 999;
                }
            }
        }

        System.out.println("Enter starting node");
        int s_node = sc.nextInt();

        TraversalDFS gs1 = new TraversalDFS(cost_matrix.length);
        gs1.DFS(cost_matrix, s_node);
        System.out.println("Traversal order in breadth first search is " + (gs1.traversal_arr));
        // The visited array contains booleans for each vertices
        if (isUnvisted(gs1.visited)) {
            System.out.println("The graph is disjoint");
        } else
            System.out.println("All nodes are reachable");

    }
}
