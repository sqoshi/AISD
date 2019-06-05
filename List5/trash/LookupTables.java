 public class LookupTables {
    static final LookupTables tables = new LookupTables();
    int [] hammingtable;
    boolean [][] binarytable;

    private LookupTables(){
        hammingtable=new int[(int)(Math.pow(2, 16))];
        binarytable=new boolean[(int)(Math.pow(2, 16))][16];

        for(int i=0;i<(int)(Math.pow(2, 16));i++){
            binarytable[i]=convertToBin(i);
            hammingtable[i]=HammingWeight(i);
        }
    }

    public static LookupTables getInstance(){
         return tables;
    }

    public int HammingWeight(int j){
        int counter = 0;
        boolean[] temp = binarytable[j];
        for (int i = 0; i < 16; i++)
            if (temp[i] == true)
                counter++;
        return counter;
    }

    private boolean[] convertToBin(int val) {
        boolean[] temp = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if(val % 2==1)
                temp[16-i-1] = true;
            val /= 2;
        }
        return temp;
    }
}
