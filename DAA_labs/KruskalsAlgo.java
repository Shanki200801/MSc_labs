import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KruskalsAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();

        int[][] cost_matrix = new int[n][n];

        System.out.println("Enter the cost adjacency matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = sc.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 999;
                }
            }
        }

        int total_cost = kurskal(n, cost_matrix);

        // passing the cost adjecency matrix and the number of vertices
        // note: 1-1 costs are not 0 but 999
        System.out.println("Total cost is " + total_cost);

    }

    private static int kurskal(int n, int[][] cost_matrix) {

        int total_cost = 0;

        // Using Arraylist to get an array of edge costs
        ArrayList<Integer> as = new ArrayList<>();
        boolean[] visited = new boolean[n];
        // because graphs are non directed cost adj matrix are symmetric
        // traversing through only upper triangle elements of cost matrix and adding
        // them to tree set
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                as.add(cost_matrix[i][j]);
            }
        }
        // sorting the elements of the array
        Collections.sort(as);
        // converting ArrayList to Integer array which is totally unnecessary but oh
        // well
        Integer[] cost_set = as.toArray(new Integer[as.size()]);

        ArrayList<Edge> edge_set = new ArrayList<Edge>();

        // parsing through each edges in array list till n-1 edges are added
        for (int x = 0; edge_set.size() < n - 1; x++) {

            // parsing the upper triangle again to check where the least element exists ..
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (cost_matrix[i][j] == cost_set[x]) {
                        Edge e = new Edge(i, j, cost_matrix[i][j]);

                        // adding the edges to edge set list if the said list is empty or it doesnt form
                        // loops
                        if (edge_set.isEmpty()) {
                            edge_set.add(e);
                            visited[i] = true;
                            visited[j] = true;
                            break;
                        } else {
                            ArrayList<Edge> copied_arr = new ArrayList<>(edge_set);
                            copied_arr.add(e);
                            boolean flag = false;
                            copied_arr.get(0).visited = true;
                            for (Edge edge : copied_arr) {
                                if (check_cycle(copied_arr, edge)) {
                                    flag = true;
                                }

                            }
                            if (!flag)
                                edge_set.add(e);
                        }
                    }
                }
            }
        }

        // To print the final edges and summing their costs
        System.out.println("Edges are ");
        for (Edge e : edge_set) {
            total_cost += e.cost;
            System.out.println(e.vertex1 + " " + e.vertex2);
        }
        return total_cost;
    }

    private static boolean check_cycle(ArrayList<Edge> copied_arr, Edge start) {

        for (Edge edge : copied_arr) {
            if (start.vertex1 == edge.vertex2) {
                if (edge.visited)
                    return false;
                edge.visited = true;
                return check_cycle(copied_arr, edge);
            }
        }

        return false;
    }

    // function to check if graph forms a cycle

}

// Edge class contains properties of an edge
class Edge {
    boolean visited;
    int vertex1;
    int vertex2;
    int cost;

    Edge(int vertex1, int vertex2, int cost) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.cost = cost;
        this.visited = false;
    }

    Edge(int vertex1, int vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

}
