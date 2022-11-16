/*----------------------------------------------------------------
 @Author: Shashank
 Program to find the all pair shortest path using the
 FloydWarshall algorithm (dynamic programming)
 ------------------------------------------------------------------*/
package Final_codes;

import java.util.Scanner;

class FloydWarshall {

    void floydWarshall(int graph[][], int n) {
        int dist[][] = new int[n][n];
        int i, j, k;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                dist[i][j] = graph[i][j];
        // k counts the cycles
        for (k = 0; k < n; k++) {
            // traversing the graph with i and j
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist, n);
    }

    void printSolution(int dist[][], int n) {
        System.out.println("SHORTEST PATH MATRIX:-");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == 999)
                    System.out.print("I ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();

        int[][] cost_matrix = new int[n][n];

        // taking cost matrix of graph as input
        System.out.println("Enter the cost matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = sc.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 0;
                }
            }
        }

        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(cost_matrix, n);
    }
}