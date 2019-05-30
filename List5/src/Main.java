public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--size")) {
                try {
                    int k = Integer.parseInt(args[i + 1]);
                    if (k < 1 || k >= 16) {
                        System.out.println(" kis not in <1,16> range");
                    }

                    System.out.println(" k belong to 1,16");
                 //Graph graph = new Graph(k);
                //   System.out.println(graph.getBreadthpaths());
                Simulation.S1(10);


                } catch (Exception e) {
                    System.out.println();
                }
            }
        }
    }
}
