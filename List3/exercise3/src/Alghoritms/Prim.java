package Alghoritms;

import Graph.Edge;

import java.util.LinkedList;

import static Graph.Graph.adjacencylist;
import static Graph.Graph.vertices;

public class Prim implements MST {
    @Override
    public void MST() {

        boolean[] inHeap = new boolean[vertices];
        ResultSet[] resultSet = new ResultSet[vertices];
        //keys[] used to store the key to know whether min hea update is required
        int[] key = new int[vertices];
//          //create heapNode for all the vertices
        HeapNode[] heapNodes = new HeapNode[vertices];
        for (int i = 0; i < vertices; i++) {
            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].key = Integer.MAX_VALUE;
            resultSet[i] = new ResultSet();
            resultSet[i].parent = -1;
            inHeap[i] = true;
            key[i] = Integer.MAX_VALUE;
        }

        //decrease the key for the first index
        heapNodes[0].key = 0;

        //add all the vertices to the MinHeap
        MinHeap minHeap = new MinHeap(vertices);
        //add all the vertices to priority queue
        for (int i = 0; i < vertices; i++) {
            minHeap.insert(heapNodes[i]);
        }

        //while minHeap is not empty
        while (!minHeap.isEmpty()) {
            //extract the min
            HeapNode extractedNode = minHeap.extractMin();

            //extracted vertex
            int extractedVertex = extractedNode.vertex;
            inHeap[extractedVertex] = false;

            //iterate through all the adjacent vertices
            LinkedList<Edge> list = adjacencylist[extractedVertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                //only if edge destination is present in heap
                if (inHeap[edge.destination]) {
                    int destination = edge.destination;
                    int newKey = edge.weight;
                    //check if updated key < existing key, if yes, update if
                    if (key[destination] > newKey) {
                        decreaseKey(minHeap, newKey, destination);
                        //update the parent node for destination
                        resultSet[destination].parent = extractedVertex;
                        resultSet[destination].weight = newKey;
                        key[destination] = newKey;
                    }
                }
            }
        }
        //print mst
        printMST(resultSet);
    }


    public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {

        //get the index which key's needs a decrease;
        int index = minHeap.indexes[vertex];

        //get the node and update its value
        HeapNode node = minHeap.mH[index];
        node.key = newKey;
        minHeap.bubbleUp(index);
    }


    public void printMST(ResultSet[] resultSet) {
        int total_min_weight = 0;
        System.out.println("Minimum Spanning Tree: ");
        for (int i = 1; i < vertices; i++) {
            System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                    " weight: " + resultSet[i].weight);
            total_min_weight += resultSet[i].weight;
        }
        System.out.println("Total minimum key: " + total_min_weight);
    }
}

class HeapNode {
    int vertex;
    int key;
}

class ResultSet {
    int parent;
    int weight;
}
