import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Simulation {



    public static void S1(int n) throws IOException {

        int size = 16;
        int[][] breadthsgrouped;
        int[][] flows;
        double[][] times;
        double[][] OveralAverage;
        Graph graph;

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));


        for (int k = 1; k <= size; ++k) {

            breadthsgrouped = new int[size][n];
            flows = new int[16][n];
            times = new double[16][n];


            for (int i = 0; i < n; ++i) {
                graph = new Graph(k);
                breadthsgrouped[k][i] = graph.getBreadthpaths();
                flows[k][i] = graph.getMaxFlow();
                times[k][i] = graph.getTime();
            }
            double BreadthPatsAverageFork = Arrays.stream(breadthsgrouped[k]).average().getAsDouble();
            double FlowAverageFork = Arrays.stream(flows[k]).average().getAsDouble();
            double TimeAverageFork = Arrays.stream(times[k]).average().getAsDouble();

            writer.append(String.valueOf(k)).append(" ").
                    append(String.valueOf(BreadthPatsAverageFork)).append(" ").
                    append(String.valueOf(FlowAverageFork)).append(" ").
                    append(String.valueOf(TimeAverageFork)).append("\n");
            writer.flush();
        }

        writer.close();

    }
    //outputWriter.close();


}