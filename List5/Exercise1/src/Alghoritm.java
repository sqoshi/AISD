import java.util.LinkedList;

public class Alghoritm {

    static boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        int V = (int) Math.pow(2, Graph.k);
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;


        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;


        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }


        return (visited[t]);
    }

    static int EdmondKarp(int[][] graph, int s, int t) {
        int u, v;
        int V = (int) Math.pow(2, Graph.k);

        int[][] rGraph = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int[] parent = new int[V];

        int max_flow = 0;

        while (bfs(rGraph, s, t, parent)) {
            Graph.breadthpaths++;

            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }


            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }
}
