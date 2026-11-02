import java.util.*;
public class DKruskalAlgo{   //T.C -> O(V + ElogE)
    static class Edge implements Comparable<Edge> {
           int src;
           int dest;
           int wt;
           public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
           }

           @Override
           public int compareTo(Edge e2) {
            return this.wt - e2.wt; //ascending order sorting 
           }
    }
    static void createGraph(ArrayList<Edge> edges) {
        // edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4; // vertices
    static int par[] = new int[n]; // same size of par and rank arr
    static int rank[] = new int[n];

    public static void init() { //const T.C
        for(int i =0; i<n; i++) {
            par[i] = i;
        }
    }
    public static int find(int x) { //const T.C
        if(par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        }else {
            par[parB] = parA;
        }
    }
    // kruskal's algo
    public static void  kruskalsMST(ArrayList<Edge> edges, int V) {//  how many vertices
        init(); //parent ko initialie
         Collections.sort(edges); //for sort the edges  // O(ElogE)
         int mstCost = 0;
         int count = 0;

         for(int i =0; count<V-1; i++) {   // O(V)
            Edge e = edges.get(i);
            //src, dst, wt
            
            //to detect cycle ..if par A is same as parB
            int parA = find(e.src); //src = a
            int parB = find(e.dest); //dest = b
            if(parA != parB) { //Cycle condition nhi h tab 
                union(e.src, e.dest); //tb union krna h 
                mstCost += e.wt; // in mstCost also include edge  weight
                count++;
            }
         }
         System.out.println(mstCost);
    }
    public static void main(String[] args) {
         int V =4; // 4 vertices graph
         ArrayList<Edge> edges = new ArrayList<>();
         createGraph(edges);
         kruskalsMST(edges, V);
    }
}