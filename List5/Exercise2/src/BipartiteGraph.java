import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class BipartiteGraph {
    int[][] cap;
    LinkedList<Integer>[] adjList;
    int size;
    int k;


    public BipartiteGraph(int k, int m) {
        int randomNum;
        Random Random = new Random();
        size = (int) Math.pow(2, k + 1) + 2;
        adjList = new LinkedList[size];
        this.k = k;
        cap = new int[size][size];

        //BUILDING FLOW NETWORK ON ADJLIST
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int i = 1; i <= Math.pow(2, k); ++i) {
            adjList[0].add(i);// MAKIN SITUATION THAT SOURCE 0 LEADS TO ALL 1-2^k vertixes
            cap[0][i]=1;
        }
        for (int i = (int) Math.pow(2, k) + 1; i <= (int) Math.pow(2, k + 1); ++i) {
            adjList[i].add(size - 1);// MAKIN SITUATION THAT ALL vertixes FROM V2 LEADS TO destination T size-1
            cap[i][size-1]=1;
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
                            cap[i][randomNum]=1;
                        }
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        BipartiteGraph bipartiteGraph = new BipartiteGraph(3, 3);
        printGraph(bipartiteGraph);
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



    public int[][] getCap() {
        return cap;
    }

}
