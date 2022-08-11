package graph;
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
