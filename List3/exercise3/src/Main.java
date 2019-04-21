import Alghoritms.Kruskal;
import Alghoritms.Prim;
import Graph.Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        System.out.println("Input quantity of Vertices");
        int V = scanner.nextInt();
        System.out.println("Input quantity of Edges");
        int E = scanner.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Connect your graph as you wish");
        for (int i = 0; i < E; i++) {
            //adding Edges with weights
            System.out.print("Source: ");
            int src = scanner.nextInt();
            System.out.print("Destination: ");
            int dest = scanner.nextInt();
            System.out.print("Weight: ");
            int weight = scanner.nextInt();
            System.out.println("******************************************************");

            graph.addEdge(src, dest, weight);
        }

        for (String arg : args) {
            if (arg.equals("-p")) {
                Prim prim = new Prim();
                prim.MST();

            } else if (arg.equals("-k")) {
                Kruskal kruskal = new Kruskal();
                kruskal.MST();
            }
        }

    }
}
