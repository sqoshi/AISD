import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class BipartiteGraph {
    int[][] cap;
    LinkedList<Integer>[] adjList;
    int size;


    public BipartiteGraph(int k, int m) {
        int randomNum;
        Random Random = new Random();
        size = (int) Math.pow(2, k + 1) + 2;
        adjList = new LinkedList[size];
//BUILDING FLOW NETWORK ON ADJLIST
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int i = 1; i <= Math.pow(2, k); ++i) {
            adjList[0].add(i);// MAKIN SITUATION THAT SOURCE 0 LEADS TO ALL 1-2^k vertixes
        }
        for (int i = (int) Math.pow(2, k) + 1; i <= (int) Math.pow(2, k + 1); ++i) {
            adjList[i].add(size - 1);// MAKIN SITUATION THAT ALL vertixes FROM V2 LEADS TO destination T size-1
        }
        for (int i = 1; i <= Math.pow(2, k); ++i) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> NUMBERS = new ArrayList<Integer>();

            while (adjList[i].size() != 3) {
                randomNum = (int) (Random.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);
                while (!NUMBERS.contains(randomNum)) {
                    NUMBERS.add(randomNum);
                    if (randomNum != i) {

                        while (!numbers.contains(randomNum)) {
                            numbers.add(randomNum);

                            adjList[i].add(randomNum);
                        }
                    }
                }
            }
        }

        cap = new int[(int) (Math.pow(2, k + 1) + 2)][(int) (Math.pow(2, k + 1) + 2)];
        // 2 zbiory po 2^k + sink i source
        Random generator = new Random();
        int random;

        for (int j = 1; j < Math.pow(2, k) + 1; j++)
            cap[0][j] = 1;

        for (int j = (int) (Math.pow(2, k) + 1); j < Math.pow(2, k + 1) + 1; j++)
            cap[j][(int) (Math.pow(2, k + 1) + 1)] = 1;

        for (int j = 1; j < Math.pow(2, k) + 1; j++) {
            random = (int) (generator.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);

            for (int a = 0; a < m; a++) {
                while (cap[j][random] != 0)
                    random = (int) (generator.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);
                cap[j][random] = 1;
            }
        }

    }

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph(3, 3);
        printGraph(bipartiteGraph);
    }

    static void addEdge(BipartiteGraph graph, int src, int dest) {
        graph.adjList[src].add(dest);
        graph.adjList[dest].add(src);
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

    public int[][] getCap() {
        return cap;
    }

}
