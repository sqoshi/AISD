import java.io.*;
import java.util.Arrays;

public class Simulation {

    public static void S1(int n)  throws FileNotFoundException, IOException  {


        int size = 16;
        int[][] breadthsgrouped;
        int[][] flows;
        double[][] times;
        double[][] OveralAverage;
        Graph graph;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        File file = new File("/home/piotr/IdeaProjects/AISD/List5/output.txt");
StringBuilder str = new StringBuilder();
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
            OveralAverage[k][0] = BreadthPatsAverageFork;
            OveralAverage[k][1] = FlowAverageFork;
            OveralAverage[k][2] = TimeAverageFork;
            //. writer.append((k )+ " " + BreadthPatsAverageFork + " " + FlowAverageFork + " " + TimeAverageFork);
               str.append(k).append(" ").append(BreadthPatsAverageFork).append(" ").append(FlowAverageFork)
                       .append(" ").append(TimeAverageFork).append("/");
            System.out.println(str.toString());
            System.out.println();
                if(file.exists()) {


                    String line = bufferedReader.readLine();
                    System.out.println(line);
                    while(line != null) {
                        line = bufferedReader.readLine();
                        if(line.equals("")) {
                            bufferedWriter.write(str.toString());
                            bufferedWriter.append(str.toString());
                            System.out.println("a");
                        }
                        System.out.println(line);
                    }
                }
            }

        }
        //outputWriter.close();


    }



