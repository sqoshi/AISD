import java.util.ArrayList;
import java.util.Collections;


public class Graph {
    static int k;
    static int breadthpaths = 0;
    public int maxFlow;
    int[][] cap;
    ArrayList<Integer> Lotery;
    int[][] adjmatrix;
    int[][] flows;
    int[][] residualCap;
    int[] P;
    long startTime;
    double elapsedTime;
    long endTime;

    public Graph(int k) {
        startTime = System.currentTimeMillis();
        this.k = k;

        P = new int[(int) Math.pow(2, k)];
        adjmatrix = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        flows = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        residualCap = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        cap = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        Lotery = new ArrayList<>();

        for (int i = 0; i <= Math.pow(2, k) - 1; i++) {
            for (int j = 0; j <= Math.pow(2, k) - 1; j++) {
                if (i < j) {
                    if (differAtOneBitPos(j, i)) {
                        adjmatrix[i][j] = 1;
                        int l = maxFromHandZ(i, j);
                        for (int m = 1; m <= (int) Math.pow(2, l); m++) {
                            Lotery.add(m);
                            Collections.shuffle(Lotery);
                        }
                        cap[i][j] = Lotery.get(0);
                    }
                }

            }
        }
        maxFlow = Alghoritm.EdmondKarp(cap, 0, (int) Math.pow(2, k) - 1);
        endTime = System.currentTimeMillis();
        elapsedTime = (double) (endTime - startTime) / 1000;

    }

    static boolean isPowerOfTwo(int x) {

        return x != 0 && ((x & (x - 1)) == 0);
    }

    static boolean differAtOneBitPos(int a, int b) {
        return isPowerOfTwo(a ^ b);
    }



    public double getTime() {
        return elapsedTime;
    }

    public int getMaxFlow() {
        return maxFlow;
    }

    public int getBreadthpaths() {
        return breadthpaths;
    }


    int maxFromHandZ(int v, int u) {
        return Math.max(H(v), Math.max(H(u), Math.max(Z(v), Z(u))));
    }

    //zero
    private int Z(int n) {
        int count0 = 0;
        while (n != 0) {
            if (n % 2 == 0)
                count0++;
            n /= 2;
        }
        return (count0);
    }

    //one
    private int H(int n) {
        int count1 = 0;
        while (n != 0) {
            if (n % 2 != 0)
                count1++;
            n /= 2;
        }
        return (count1);
    }
}
