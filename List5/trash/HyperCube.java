import java.util.Random;

public class HyperCube {
    private Random generator = new Random();
    private int[][] adjacencyMatrix;
    int [] hammingtable;
    boolean [][] binarytable;

    public HyperCube(int size){
        adjacencyMatrix = new int[(int) Math.pow(2, size)][(int) Math.pow(2, size)];
        hammingtable=LookupTables.getInstance().hammingtable;
        binarytable=LookupTables.getInstance().binarytable;

        int vDist;
        int u;

        for (int i = 0; i < Math.pow(2, size); i++){
            for (int j = 0; j < size; j++){
                if(binarytable[i][16-size+j]==true){
                    u=i-(int)(Math.pow(2,size-1-j));
                    vDist = hammingtable[i];
                    adjacencyMatrix[u][i] = randomWeight(vDist, size - vDist, vDist-1, size - vDist + 1);
                }
            }
        }
    }

    private int randomWeight(int... varargs){
        int range = varargs[0];
        for (int i : varargs) {
            if (i > range)
                range = i;
        }
        return (int)(generator.nextInt((int) (Math.pow(2, range))) + 1);
    }

    public int[][] getAdjacencyMatrix(){
        return adjacencyMatrix;
    }
}
