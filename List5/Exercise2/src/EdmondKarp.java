import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class EdmondKarp {
        int k;int V;
    public EdmondKarp(int k, int m) {
        this.V=(int) Math.pow(2,k);
        this.k=k;

    }

    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;

        //bfs loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return (visited[t] == true);
    }
    boolean bfsonlist(LinkedList[] radj, int s, int t, int parent[])
    {

        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i]=false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s]=-1;

        //bfs loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && radj[u].contains(v))
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return (visited[t] == true);
    }

    int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;

        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];

        int max_flow = 0;  // There is no flow initially

        while (bfs(rGraph, s, t, parent))
        {
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }
}
