import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Prim {

    private ArrayList<Edge>[] adj;
    private ArrayList<Edge> heap = new ArrayList<>();
    private ArrayList<Edge> result = new ArrayList<>();
    private int vectors;
    private int[] parent;

    private Prim(int vectors) {
        this.vectors = vectors;
        parent = new int[vectors];
        for (int i = 0; i < vectors; i++) {
            parent[i] = i;
        }

        adj = new ArrayList[vectors];

        for (int i = 0; i < vectors; i++) {
            adj[i] = new ArrayList<Edge>();
        }
    }

    public static void main(String[] arg) throws NullPointerException {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        Prim ks = new Prim(vertices);

//
     //   int edges = sc.nextInt();
     //   for (int i = 0; i < edges; i++) {
     //       int x[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
     //       ks.heap.add(new Edge(x[0], x[1], x[2]));
     //   }
//




            ks.adj[0].add(new Edge(0, 1, 2));
            ks.adj[1].add(new Edge(1, 0, 2));
            ks.adj[1].add(new Edge(1, 2, 1));
            ks.adj[2].add(new Edge(2, 1, 1));
            ks.adj[2].add(new Edge(2, 3, 4));
            ks.adj[3].add(new Edge(3, 2, 4));
            ks.adj[3].add(new Edge(3, 4, 2));
            ks.adj[4].add(new Edge(4, 3, 2));
            ks.adj[4].add(new Edge(4, 5, 1));
            ks.adj[5].add(new Edge(5, 4, 1));
            ks.adj[3].add(new Edge(3, 5, 2));
            ks.adj[5].add(new Edge(5, 3, 2));
            ks.adj[2].add(new Edge(2,4,1));
            ks.adj[4].add(new Edge(4,2,1));
            ks.adj[3].add(new Edge(3,1,2));
            ks.adj[1].add(new Edge(1,3,2));
            /*ks.adj[6].add(new Edge(6, 8, 600));
            ks.adj[8].add(new Edge(8, 6, 600));
            ks.adj[7].add(new Edge(7, 8, 700));
            ks.adj[8].add(new Edge(8, 7, 700));
            ks.adj[2].add(new Edge(2, 8, 10));
            ks.adj[8].add(new Edge(8, 2, 10));
*/

     //  ks.add(new Edge(0,1,2));
     //  ks.add(new Edge(1,0,2));
     //  ks.add(new Edge(2,0,1));
     //  ks.add(new Edge(0,2,1));
     //  ks.add(new Edge(2,3,4));
     //  ks.add(new Edge(3,2,4));
     //  ks.add(new Edge(3,1,2));
     //  ks.add(new Edge(1,3,2));
     //  ks.add(new Edge(2,4,1));
     //  ks.add(new Edge(4,3,2));
     //  ks.add(new Edge(3,4,2));
     //  ks.add(new Edge(3,5,2));
     //  ks.add(new Edge(5,3,2));
     //  ks.add(new Edge(5,4,1));
     //  ks.add(new Edge(4,5,1));


        ks.primMST(0);

    }

    public void primMST(int source) {

        for (Edge edge : adj[source]) {
            heap.add(edge);
            heapup(heap.size() - 1);
        }
        int i = 0;
        while (i < vectors - 1) {
            Edge e = Pop();
            assert e != null;
            int aSet = find(e.fromVertex);
            int bSet = find(e.toVertex);

            if (aSet != bSet) {
                for (Edge neighbour : adj[e.toVertex]) {
                    heap.add(neighbour);
                    heapup(heap.size() - 1);
                }
                i++;
                result.add(e);
                union(aSet, bSet);
            }

        }
        result();

    }

    public void result() {
        int totalW = 0;
        for (int i = 0; i < result.size(); i++) {
            Edge edge = result.get(i);
            System.out.println("Source:" + edge.fromVertex + " Destination: " + edge.toVertex + " Weight: " + edge.weight);
            totalW += edge.weight;
        }
        System.out.println("Total weight: " + totalW);
    }

    void heapup(int i) {
        if (i >= 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent).weight > heap.get(i).weight) {
                Collections.swap(heap, parent, i);
                heapup(parent);
            }
        }
    }
    private int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }

    private void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        parent[b] = a;
    }

    int higherPrio(int parent, int child) {
        if (child < heap.size() && heap.get(child).weight < heap.get(parent).weight) return child;
        else return parent;
    }

    int getChild(int parent) {
        return higherPrio(higherPrio(parent, 2 * parent + 1), 2 * parent + 2);
    }

    void heapdown(int i) {
        if (heap.size() != 0) {
            int child = getChild(i);
            if (child != i) {
                Collections.swap(heap, i, child);

                heapdown(child);
            }
        }
    }

    private Edge Pop() {
        if (heap.size() == 0) {
            return null;
        } else {
            Edge deletedEdge = heap.get(0);

            Collections.swap(heap, 0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            heapdown(0);
            return deletedEdge;
        }

    }



}

