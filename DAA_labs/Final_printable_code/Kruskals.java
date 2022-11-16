/*----------------------------------------------------------------
 @Author: Shashank
 Program to find the minimum spanning tree of a given graph 
 using the kruskal's algorithm
 ------------------------------------------------------------------*/
package Final_printable_code;

import java.util.*;

public class Kruskals {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        public void kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),
                    Comparator.comparingInt(o -> o.weight));
            // adding all edges to a priority queue which sorts according to the edge
            // weights
            pq.addAll(allEdges);
            int[] parent = new int[vertices];
            // makes an array of all vertices
            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();
            int index = 0;
            // start adding edges to the mst according to lowest weights
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);
                // if forms a loop do nothing
                if (x_set == y_set) {
                }
                // else add them to mst
                else {
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source + " destination: " + edge.destination
                        + " weight: " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input the number vertices and edges
        System.out.println("Enter the number of vertices initially");
        int n = sc.nextInt();
        Graph graph = new Graph(n);

        System.out.println("Enter the number of edges present");
        int edges = sc.nextInt();
        // input the edges
        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the source, destination and weight of edge " + (i + 1));
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            graph.addEgde(s, d, w);
        }

        graph.kruskalMST();
    }
}