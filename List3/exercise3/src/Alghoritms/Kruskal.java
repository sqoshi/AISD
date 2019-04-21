package Alghoritms;

import Graph.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static Graph.Graph.allEdges;
import static Graph.Graph.vertices;


public class Kruskal implements MST {


    public void MST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),
                Comparator.comparingInt(o -> o.weight));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i < allEdges.size(); i++) {
            pq.add(allEdges.get(i));
        }

        //create a parent []
        int[] parent = new int[vertices];

        //makeset
        makeSet(parent);

        ArrayList<Edge> mst = new ArrayList<>();

        //process vertices - 1 edges
        int index = 0;
        while (index < vertices - 1) {
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if (x_set == y_set) {
                //ignore, will create cycle
            } else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
        //print MST
        System.out.println("Minimum Spanning Tree: ");
        printGraph(mst);
    }

    public void makeSet(int[] parent) {
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex) {
        //chain of parent pointers from x upwards through the tree
        // until an element is reached whose parent is itself
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    public void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public void printGraph(ArrayList<Edge> edgeList) {
        int total_min_weight = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            System.out.println("Edge-" + i + " source: " + edge.source +
                    " destination: " + edge.destination +
                    " weight: " + edge.weight);
            total_min_weight += edge.weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);

    }
}

