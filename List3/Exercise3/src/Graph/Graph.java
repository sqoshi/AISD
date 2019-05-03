package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public static int vertices;
    public static LinkedList<Edge>[] adjacencylist;
    public static ArrayList<Edge> allEdges = new ArrayList<>();

    public Graph(int vertices) {
        Graph.vertices = vertices;
        adjacencylist = new LinkedList[vertices];

        //initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge);

        edge = new Edge(destination, source, weight);
        adjacencylist[destination].addFirst(edge); //for undirected graph

        Edge edge1 = new Edge(source, destination, weight);
        allEdges.add(edge1);
    }


    // A class to represent a subset for union-find
    public static class subset {
        public int parent;
        public int rank;
    }
}
