import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class DijQue {


    private int dist[];
    private int prev[];
    private Set < Integer > settled;
    private PrioQue pq;
    private int vectors;
    public ArrayList < Edge > [] adj;


    public DijQue(int qty) {
        this.vectors = qty;
        dist = new int[qty];
        prev = new int[qty];
        settled = new HashSet < Integer > ();
        pq = new PrioQue();
        adj = new ArrayList[qty];

        for (int i = 0; i < qty; i++) {
            adj[i] = new ArrayList < Edge > ();
        }
    }



    public void dijkstra(int source) {
        for (int i = 0; i < vectors; i++)
            dist[i] = Integer.MAX_VALUE;
        pq.insert(source, 0);
        dist[source] = 0;
        while (settled.size() != vectors) {
            int u = pq.Pop().val;
            settled.add(u);
            neighbours(u);
        }
    }





    private void neighbours(int u) {

        for (int i = 0; i < adj[u].size(); i++) {
            Edge v = adj[u].get(i);

            if (!settled.contains(v.toVertex)) {
                int edgeDistance = v.weight;
                int newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.toVertex]) {
                    dist[v.toVertex] = newDistance;
                    prev[v.toVertex] = u;
                }

                pq.insert(v.toVertex, dist[v.toVertex]);
            }
        }
    }


    public String getPath(int targetVertex, int sourceV) {
        List < Integer > path = new ArrayList < > ();



        for (int vertex = targetVertex; vertex != sourceV; vertex = prev[vertex]) {
            path.add(vertex);
        }



        String result = String.valueOf(sourceV);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            result = result + " -> " + path.get(i);
        }
        return result;
    }


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        DijQue dq = new DijQue(vertices);

        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int x[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dq.adj[x[0]].add(new Edge(x[0], x[1], x[2]));
        }

 /* //  TEST
   dq.adj[0].add(new Edge(0,1,17));
    dq.adj[0].add(new Edge(0,2,10));

    dq.adj[1].add(new Edge(1,3,1));

    dq.adj[2].add(new Edge(2,1,5));
    dq.adj[2].add(new Edge(2,3,9));
    dq.adj[2].add(new Edge(2,4,11));

    dq.adj[3].add(new Edge(3,4,6));
*/


        dq.adj[0].add(new Edge(0,1,900));
        dq.adj[0].add(new Edge(0,4,1400));
        dq.adj[0].add(new Edge(0,5,0));
        dq.adj[1].add(new Edge(1,0,900));
        dq.adj[1].add(new Edge(1,2,600));
        dq.adj[2].add(new Edge(2,1,600));
        dq.adj[2].add(new Edge(2,3,500));
        dq.adj[2].add(new Edge(2,5,1100));
        dq.adj[3].add(new Edge(3,2,500));
        dq.adj[3].add(new Edge(3,4,700));
        dq.adj[3].add(new Edge(3,5,314));
        dq.adj[4].add(new Edge(4,0,1400));
        dq.adj[4].add(new Edge(4,3,700));
        dq.adj[4].add(new Edge(4,5,900));
        dq.adj[5].add(new Edge(5,0,0));
        dq.adj[5].add(new Edge(5,2,1100));
        dq.adj[5].add(new Edge(5,3,314));
        dq.adj[5].add(new Edge(5,4,900));



        int source = sc.nextInt();
        long start = System.nanoTime();
        dq.dijkstra(source);
        long finish = System.nanoTime();

        System.out.println("The shorted path from node :" + source);
        for (int i = 0; i < dq.dist.length; i++)
            System.out.println(source + " to " + i + " is " + dq.dist[i]);

        for (int i = 0; i < dq.prev.length; i++) {
            System.err.println(dq.getPath(i,source));
        }

       long timeElapsed = finish-start;
        System.err.println("Time: " + timeElapsed);
    }








}