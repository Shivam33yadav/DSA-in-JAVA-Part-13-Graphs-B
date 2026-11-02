import java.util.*;
public class BConnectingCitiesWithMinCost {  //using prims algo
    static class Edge implements Comparable<Edge>  { //dont know on which basis of sorting ...on the basis of cost
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;//ascending cost m sorting
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0)); //initialize with src -> 0
        int finalCost = 0;

        //loop of prims algo
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost; //  jis edge ko include kr rhe uski cost ko bhi add -> final cost m curr cost ko bhi add kr denge
                
                for(int i =0; i<cities[curr.dest].length; i++) { //loop for all neighbours
                    if(cities[curr.dest][i] != 0) {//edge exist krta h then usko pq m add krna h
                        pq.add(new Edge(i, cities[curr.dest][i])); //destination is i , final cost is citi...
                    }
                }
            }
        }

        return finalCost;
    }
   public static void main(String[] args) {
       int cities[][] = {{0, 1, 2, 3, 4},
                           {1, 0, 5, 0, 7},
                           {2, 5, 0, 6, 0},
                           {3, 0, 6, 0, 0},
                           {4, 7, 0, 0, 0}};  
                           
          System.out.println(connectCities(cities));                 
   } 
}
