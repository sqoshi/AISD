import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    int k;
    int cap[][];
    ArrayList<Integer> Lotery;
    int[][] adjmatrix;

    public Graph(int k) {
        this.k = k;
        adjmatrix = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        cap = new int[(int) Math.pow(2, k)][(int) Math.pow(2, k)];
        Lotery = new ArrayList<>();

        for (int i = 0; i <= Math.pow(2, k) - 1; i++) {
            for (int j = 0; j <= Math.pow(2, k) - 1; j++) {
                if (i < j) {
                    if (differAtOneBitPos(j, i)) {
                        adjmatrix[i][j] = 1;
                        int l = maxFromHandZ(i, j);
                        System.out.println(l + " is max");
                        for (int m = 1; m <= (int) Math.pow(2, l); m++) {
                            Lotery.add(m);
                            Collections.shuffle(Lotery);
                            // System.out.println(m);
                        }
                        cap[i][j] = Lotery.get(0);
                    }
                }

            }
        }

        printer(cap);
        System.out.println();
        System.out.println();
        printer(adjmatrix);
        System.out.println(H(k));
        //   System.out.println(Lotery(2));


    }

    static boolean isPowerOfTwo(int x) {

        return x != 0 && ((x & (x - 1)) == 0);
    }

    static boolean differAtOneBitPos(int a, int b) {
        return isPowerOfTwo(a ^ b);
    }

    //  public int Lotery(int l) {
    //      return ThreadLocalRandom.current().nextInt(1, (int) Math.pow(2, l));
    //  }

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

    public void printer(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }


}


