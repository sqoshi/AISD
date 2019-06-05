public class Driver {
/*
    private static void z(int k, int i) {
        long t1 = System.currentTimeMillis();
        BipartiteGraph bipartiteGraph = new BipartiteGraph(k, i);
        EdmondsKarp edmond = new EdmondsKarp((int) (Math.pow(2, k + 1) + 2));
        matches2[k][i] += edmond.edmonds_Karp(bipartiteGraph.getFlowNetwork(), 0, (int) Math.pow(2, k + 1) + 1);
        times2[k][i] += (System.currentTimeMillis() - t1);
    }
 */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--size")) {
                try {
                    int k = Integer.parseInt(args[i + 1]);
                    if (k < 1 || k > 16) {
                        System.out.println(" k is not in <1,16> range");
                        System.exit(0);
                    }
                    System.out.println(" k belong to 1,16");
                    if (args[i + 2].equals("--degree")) {
                        try {
                            int m = Integer.parseInt(args[i + 3]);
                            if (m >= 1 && m <= k) {
                                BipartiteGraph bipartiteGraph = new BipartiteGraph(k,m);
                                bipartiteGraph.printer(bipartiteGraph.getCap());


                            } else {
                                System.out.println(" m is bigger than k or smaller than 1");
                                System.exit(0);
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("m is not a number");
                            System.exit(0);
                        }
                    } else
                        System.out.println("Type -degree and a number after it!");

                } catch (Exception e) {
                    System.out.println("k is not a number");
                    System.exit(0);
                }
            }

        }
    }
}
