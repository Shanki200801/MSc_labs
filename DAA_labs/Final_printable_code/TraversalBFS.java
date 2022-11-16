/*----------------------------------------------------------------
 @Author: Shashank
 Program to find all reachable nodes from a source node using BFS
 ------------------------------------------------------------------*/
package Final_printable_code;

import java.util.ArrayList;
import java.util.Scanner;

public class TraversalBFS {
    int n;
    boolean[] visited;

    TraversalBFS(int n) {
        visited = new boolean[n];
    }

    ArrayList<Integer> traversal_arr = new ArrayList<>();

    int front = 0;

    void rBFS(int[][] cost_matrix, int start_node) {
        n = cost_matrix.length;
        this.visited[start_node] = true;
        if (!traversal_arr.contains(start_node))
            traversal_arr.add(start_node);

        for (int i = 0; i < n; i++) {
            if (cost_matrix[start_node][i] != 999 && !visited[i]) {
                // add all unvisted neighbours to the traversal array
                if (!traversal_arr.contains(i))
                    traversal_arr.add(i);
            }
        }
        // if there are elements in the traversal array who have not been searched
        // through yet then ..
        if (traversal_arr.size() > front + 1)
            rBFS(cost_matrix, traversal_arr.get(++front));

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

        TraversalBFS gs1 = new TraversalBFS(cost_matrix.length);
        gs1.rBFS(cost_matrix, s_node);
        System.out.println("Traversal order in breadth first search is " + (gs1.traversal_arr));
    }
}
