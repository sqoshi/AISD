import java.util.*;


public class Kosaraju {
    private ArrayList< Integer >[] adj;
    private Set< Integer > visited;
    Stack stack;

    Kosaraju(int qty){
        adj = new ArrayList[qty];
        visited =  new HashSet < Integer > ();
        stack = new Stack();

        for (int i = 0; i < qty; i++) {
            adj[i] = new ArrayList < Integer > ();
        }
    }



    void orderStack(int i) {
        visited.add(i);

        adj[i].forEach( (s) -> {
            if(!visited.contains(s)){
                orderStack(s);
            }
        });

        stack.push(new Integer(i));
    }


    private ArrayList<Integer>[] transpose() {
        ArrayList<Integer>[] adjT = new ArrayList[this.adj.length];
        for (int i = 0; i < this.adj.length; i++) {
            adjT[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < this.adj.length; i++) {
            int finalI = i;
            adj[i].forEach(e -> {
                adjT[e].add(finalI);
            });
        }
        return adjT;
    }

    private void printSSC(ArrayList<Integer>[] tr,int v) {
        visited.add(v);
        System.out.print(v + " ");
        tr[v].forEach(e -> {
            if(!visited.contains(e)) {
                printSSC(tr,e);
            }
        });

    }

    void kosarajuSSC(){

        for (int i = 0; i < adj.length; i++)
            if (!visited.contains(i)) {
                orderStack(i);
            }

        ArrayList< Integer >[] tr = transpose();

       visited.clear();

        // Now process all vertices in order defined by Stack
        while (!stack.empty())
        {
            // Pop a vertex from stack
            int v = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited.contains(v))
            {
                printSSC(tr,v);
                System.out.println();
            }
        }





    }




    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();

        Kosaraju dq = new Kosaraju(vertices);

        int edges = sc.nextInt();
        sc.nextLine();

       /* TEST dq.adj[0].add(1);
        dq.adj[1].add(4);
        dq.adj[1].add(2);
        dq.adj[1].add(5);
        dq.adj[2].add(3);
        dq.adj[2].add(6);
        dq.adj[3].add(2);
        dq.adj[3].add(7);
        dq.adj[4].add(5);
        dq.adj[4].add(0);
        dq.adj[5].add(6);
        dq.adj[6].add(5);
        dq.adj[7].add(3);
        dq.adj[7].add(6);*/


        dq.adj[0].add(1);
        dq.adj[1].add(6);
        dq.adj[1].add(7);
        dq.adj[2].add(3);
        dq.adj[2].add(5);
        dq.adj[3].add(2);
        dq.adj[3].add(4);
        dq.adj[4].add(4);
        dq.adj[5].add(4);
        dq.adj[5].add(6);
        dq.adj[6].add(5);
        dq.adj[7].add(6);
        dq.adj[7].add(0);



        for (int i = 0; i < edges; i++) {
            String line = sc.nextLine();

            int x[] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            dq.adj[x[0]].add(x[1]);
        }

        dq.kosarajuSSC();

    }
}
