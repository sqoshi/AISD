import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Simulation {

    public static void S1(int n) throws IOException {




        int size=16;
        int[][] breadthsgrouped;
        int[][] flows;
        double[][] times;
        double[][] OveralAverage;
        Graph graph;

        for (int k = 1; k <= size; ++k) {


            breadthsgrouped = new int[size][n];
            flows = new int[16][n];
            times = new double[16][n];
            //0 BP //1 MF //2 ET
            OveralAverage = new double[size][3];
            //System.out.println();
            for (int i = 0; i < n; ++i) {
                graph = new Graph(k);
                breadthsgrouped[k][i] = graph.getBreadthpaths();
                flows[k][i] = graph.getMaxFlow();
                times[k][i] = graph.getTime();
                // System.out.println("K: " + k + " | I: " + i +
                //         " | BP: " + graph.getBreadthpaths() +
                //         " | MF: " + graph.getMaxFlow() +
                //         " | ET: " + graph.getTime());
            }
            double BreadthPatsAverageFork = Arrays.stream(breadthsgrouped[k]).average().getAsDouble();
            double FlowAverageFork = Arrays.stream(flows[k]).average().getAsDouble();
            double TimeAverageFork = Arrays.stream(times[k]).average().getAsDouble();
            //OveralAverage[k][0] = BreadthPatsAverageFork;
            //OveralAverage[k][1] = FlowAverageFork;
            //OveralAverage[k][2] = TimeAverageFork;
            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.append((k )+ " " + BreadthPatsAverageFork + " " + FlowAverageFork + " " + TimeAverageFork);
            writer.close();

        }



    }


}
