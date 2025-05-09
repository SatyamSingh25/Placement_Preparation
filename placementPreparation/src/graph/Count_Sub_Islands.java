package graph;
/**-------------------------------------------Count Sub Islands-------------------------------------------------------------
 * Problem: You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land).
 *         An island is a group of 1's connected 4-directionally (horizontal or vertical). 
 *         Any cells outside of the grid are considered water cells.
 *         
 *         An island in grid2 is considered a sub-island if there is an island in grid1 
 *         that contains all the cells that make up this island in grid2.
 *         Return the number of islands in grid2 that are considered sub-islands.
 *         
 * Grid 1                Grid 2
 * [1,1,1,0,0],          [1,1,1,0,0]
 * [0,1,1,1,1],          [0,0,1,1,1] 
 * [0,0,0,0,0],          [0,1,0,0,0]
 * [1,0,0,0,0],          [1,0,1,1,0]
 * [1,1,0,1,1]           [0,1,0,1,0]
 * 
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 *         The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 */
import java.util.*;
public class Count_Sub_Islands {
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
    	//storing all the lands coordinates in grid2
        ArrayList<Pair> cordinates = new ArrayList<>(); 
        
        //storing all coordinates of 1 islands in a single list
        ArrayList<ArrayList<Pair>> lands = new ArrayList<>(); 
        
        int count = 0;
        
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    cordinates = new ArrayList<Pair>();
                    dfs(i, j, grid2, cordinates); //visiting all valid coordinates of valid in grid2
                    lands.add(cordinates);
                }                
            }
        }
        
        int flag = 0;
        for(int i=0; i<lands.size(); i++){
            cordinates = lands.get(i);
            
            for(Pair pair: cordinates){
                if(grid1[pair.i][pair.j] != 1){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                count++;
            }
            flag = 0;
        }        
        return count;
    }
    
    private void dfs(int i, int j, int[][] grid, ArrayList<Pair> cords){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        cords.add(new Pair(i, j));
        dfs(i+1, j, grid, cords);
        dfs(i-1, j, grid, cords);
        dfs(i, j+1, grid, cords);
        dfs(i, j-1, grid, cords);
    }

    
    class Pair{
        int i, j;
        Pair(){
            this.i = 0;
            this.j = 0;
        }
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
