package graph;
/**
 * @Minimum_step_of_knight_to_goto_destination
 * @BFS @QUEUE @Minimum_Path
 * @GFG
 * @HARD
 */
//https://practice.geeksforgeeks.org/problems/steps-by-knight5927/0/?track=amazon-graphs&batchId=192#
import java.util.*;
public class Steps_by_Knight {
	//pair class for storing node in queue
	static class Pair{
        int i, j, dist;
        Pair(int i, int j, int d){
            this.i = i;
            this.j = j;
            this.dist = d;
        }
    }
    
    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
    	//visited matrix
        boolean[][] visited = new boolean[n+1][n+1];
        visited[KnightPos[0]][KnightPos[1]] = true;
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(KnightPos[0], KnightPos[1], 0));
        
        int dRow[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dCol[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        while(queue.isEmpty() == false){
            Pair curr = queue.poll();
            
            //if current node is at distination so return the distance
            if(curr.i==TargetPos[0] && curr.j == TargetPos[1]){
                return curr.dist;
            }
            //goin to Knight all 8 positions
            for(int t=0; t<8; t++){
                int adj_x= curr.i +dRow[t];
                int adj_y= curr.j +dCol[t];
                
                if(isValid(adj_x, adj_y, n, visited)){
                    visited[adj_x][adj_y] = true;
                    queue.add(new Pair(adj_x, adj_y,curr.dist + 1));
                }
            }
        }
        //if not possible to goto destination then return -1
        return -1;
    }
    public static boolean isValid(int i, int j, int n, boolean[][] visited){
    	if (i >= 1 && i <= n && j >= 1 && j <= n && visited[i][j]==false)
			return true;
		return false;
    }
	public static void main(String[] args) {
		int[] arr1 = new int[] {4,5};
		int[] arr2 = new int[] {1,1};
		System.out.println(minStepToReachTarget(arr1,arr2, 6));
	}

}
