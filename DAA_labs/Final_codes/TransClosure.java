/*----------------------------------------------------------------
 @Author: Shashank
 Program to find the transitive closure edge matrix
 for a given matrix
 ------------------------------------------------------------------*/

package Final_codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Edge class describes an edge with source and destination properties
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

class Graph {
    // contains a matrix which represents the graph
    List<List<Integer>> adjList = null;

    // constructor to initialize the graph
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
        }
    }
}

public class TransClosure {
    public static void DFS(Graph graph, byte[][] C, int root, int descendant) {
        for (int child : graph.adjList.get(descendant)) {
            if (C[root][child] == 0) {

                C[root][child] = 1;
                DFS(graph, C, root, child);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of edges initially");
        int n = sc.nextInt();

        // taking all the edges present as input
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Edge " + (i + 1));
            System.out.println("Enter source");
            int source = sc.nextInt();
            System.out.println("Enter destination");
            int destination = sc.nextInt();
            edges.add(new Edge(source, destination));
        }

        final int N = n + 1;
        // initalizing the graph
        Graph graph = new Graph(edges, N);
        // creating the byte array representing the output graph
        byte[][] C = new byte[N][N];
        System.out.println("TRANSITIVE CLOSURE:-\n");
        for (int v = 0; v < N; v++) {
            C[v][v] = 1;
            // using depth first search on each vertex to visit all children possible
            DFS(graph, C, v, v);
            // printing each line
            for (int u = 0; u < N; u++)
                System.out.print(C[v][u] + " ");
            System.out.println();
        }
    }
}