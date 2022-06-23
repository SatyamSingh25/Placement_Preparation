package islands;

import java.util.*;
public class Flood_fill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if(currentColor == newColor){
            return image;
        }
        dfs(image, sr, sc, newColor, currentColor);
        return image;
    }
    public static void dfs(int[][] image, int i, int j, int newColor, int currentColor){
        int row = image.length;
        int col = image[0].length;
        if(i<0 || i>=row || j<0 || j>=col)
            return;
        if(image[i][j] != currentColor)
            return;

        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, currentColor);
        dfs(image, i-1, j, newColor, currentColor);
        dfs(image, i, j+1, newColor, currentColor);
        dfs(image, i, j-1, newColor, currentColor);

    }

    public static void main(String[] args){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println("Before Flood of color 2 at [1,1]");
        for(int i=0; i<image.length; i++)
            System.out.println(Arrays.toString(image[i]));

        image = floodFill(image, 1, 1,2);

        System.out.println("After Flood of color 2 at [1,1]");
        for(int i=0; i<image.length; i++)
            System.out.println(Arrays.toString(image[i]));
    }
}
