import java.util.*;
public class EFloodFillAlgo { // 733 easy
    //T. C -> O(m *n)
    public void helper(int[] [] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
        //Base Case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        image[sr][sc] = color;
         //left 
        helper(image, sr, sc-1, color, vis, orgCol); //helper call

         //right
        helper(image, sr, sc+1, color, vis, orgCol);

         //up
         helper(image, sr-1, sc, color, vis, orgCol);

         //down
         helper(image, sr +1, sc, color, vis, orgCol);

    } 

 
    public int[][] floodFill(int[] [] image, int sr, int sc, int color) {
        boolean vis[][] =  new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        EFloodFillAlgo e = new EFloodFillAlgo();

        int sr = 1, sc = 1, color = 2;
        
        
         int[][] image = {{1, 1, 1},
                           {1, 1, 0},
                            { 1, 0, 1}};
        int result[][] = e.floodFill(image, sr, sc, color);

        //print 
        for(int row[] : result) {
            for(int val : row) {
               System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}
