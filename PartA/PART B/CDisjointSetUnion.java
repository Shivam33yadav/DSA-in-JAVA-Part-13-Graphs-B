import java.util.*;
public class CDisjointSetUnion { //T.C of union and find is same i.e O(4K) where k is const ..mathematically O(4) or O(1)
    static int n = 7;
   static  int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i = 0; i<n; i++) {
            par[i] = i; //initially har koi khud ka parent hh
        }
    }
    //find func
    public static int find(int x) { //x -> jiska final leader find out krna h
         if(x == par[x]) {
            return x;
         } //agr aesa nhi to dubara find par

         return par[x] = find(par[x]);
    }

    public static void union(int a, int b ) {
        int parA = find(a);
        int parB = find(b); // agr dono same set m h means cycle formed -> in kruskal algo

        if(rank[parA] == rank[parB]) {
            par[parB] = parA; //kisiko bhi kisika parent bna skte  -> A is the par of B

            if(parA == parB) return;
            rank[parA]++; //rank of A will be increase
        }else if(rank[parA] < rank[parB]) {
             par[parA] = parB;   //there is no updation in rank in this case  // A ko judna pdega B k saath
        }else{
            par[parB] = parA;
        }
    }

     public static void main(String[] args) {
        init(); //for initialization call init func
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3,6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);

     }
}
