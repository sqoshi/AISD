import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BipartiteGraph {
    int[][] cap;
    LinkedList<Integer>[] adjList;
    LinkedList<Edge>[] adjListEdges;
    int size;
    int k;
    private int[] P;
    private int source;
    private int sink;
    private int[][] flow;
    int path=0;

    class Edge {
        int cap;
        int weight;
        int src;
        int dest;

        public Edge(int src, int dest,int cap) {
            int flow;
            this.cap = cap;
            this.src = src;
            this.dest = dest;
        }
    }

    public BipartiteGraph(int k, int m) {
        int randomNum;
        Random Random = new Random();
        size = (int) Math.pow(2, k + 1) + 2;
        sink = size - 1;
        flow = new int[size][size];
        P = new int[size];
        source = 0;
        adjList = new LinkedList[size];
        adjListEdges = new LinkedList[size];
        this.k = k;
        cap = new int[size][size];

        //BUILDING FLOW NETWORK ON ADJLIST
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
            adjListEdges[i] = new LinkedList<Edge>();
        }
        for (int i = 1; i <= Math.pow(2, k); ++i) {
            adjList[0].add(i);// MAKIN SITUATION THAT SOURCE 0 LEADS TO ALL 1-2^k vertixes
            cap[0][i] = 1;
            adjListEdges[0].add(new Edge(0,i,1));
        }
        for (int i = (int) Math.pow(2, k) + 1; i <= (int) Math.pow(2, k + 1); ++i) {
            adjList[i].add(size - 1);// MAKIN SITUATION THAT ALL vertixes FROM V2 LEADS TO destination T size-1
            cap[i][size - 1] = 1;
            adjListEdges[i].add(new Edge(i,size-1,1));
        }
        for (int i = 1; i <= Math.pow(2, k); ++i) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> NUMBERS = new ArrayList<Integer>();

            while (adjList[i].size() != m) {
                randomNum = (int) (Random.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);
                while (!NUMBERS.contains(randomNum)) {
                    NUMBERS.add(randomNum);
                    if (randomNum != i) {

                        while (!numbers.contains(randomNum)) {
                            numbers.add(randomNum);

                            adjList[i].add(randomNum);
                            cap[i][randomNum] = 1;
                            adjListEdges[i].add(new Edge(i,randomNum,1));
                            // random connections between V1 and V2 but all V2 are used at least once
                        }
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph(3, 2);
        printGraph(bipartiteGraph);
        System.out.println("flow");
       // printer(bipartiteGraph.flow);
        System.out.println(bipartiteGraph.maxFlow());
       // System.out.println(bipartiteGraph.path);

        //bipartiteGraph.BFS(bipartiteGraph.adjList,0,2, 3);

    }

    public static void printer(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    static void printGraph(BipartiteGraph graph) {
        for (int v = 0; v < graph.size; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjList[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    int maxFlow() {
        int f = 0;
        while (true) {
            int m = BFS();
            if (m == 0) break;
            f += m;
            int v = sink;
            while (v != source) {
                int u = P[v];
                path++;
                flow[u][v] += m;
                flow[v][u] -= m;
                v = u;
            }
        }
        return f;
    }

    void printflow() {
        for (int i = 0; i < flow.length; i++) {
            for (int j = 0; j < flow[i].length; j++) {
                System.out.print("[" + flow[i][j] + "]");
            }
            System.out.println();
        }
    }

    int BFS() {
        for (int j = 0; j < size; j++) {
            P[j] = -1;
        }
        P[source] = -2;
        int[] M = new int[size];
        M[source] = Integer.MAX_VALUE;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(source);
        while (Q.size() > 0) {
            int u = Q.poll();
            for (int j = 0; j < adjList[u].size(); j++) {
                int v = adjList[u].get(j);
                if (cap[u][v] - flow[u][v] > 0 && P[v] == -1) {
                    P[v] = u;
                    M[v] = Math.min(M[u], cap[u][v] - flow[u][v]);
                    if (v != sink)
                        Q.add(v);
                    else
                        return M[sink];
                }
            }
        }
        return 0;
    }

    public int[][] getCap() {
        return cap;
    }

}
