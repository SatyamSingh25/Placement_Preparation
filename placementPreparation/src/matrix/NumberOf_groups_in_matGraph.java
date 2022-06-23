package matrix;
//Leetcode 547
import java.util.*;
public class NumberOf_groups_in_matGraph {
    public static void main(String[] args){
        int[][] mat = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        //result -> 2
        System.out.println(numberOf_Groups(mat));
        System.out.println(numberOf_Groups2(mat));
    }
    //approach 1 (fast)
    private static int numberOf_Groups(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        boolean[] visited = new boolean[row];
        int count = 0;
        for(int i=0; i<row; i++){
            if(visited[i] == false){
                count++;
                dfs(i, visited, arr);
            }
        }

        return count;
    }
    public static void dfs(int source, boolean[] visited, int[][] grid){
        for(int i=0; i<grid[0].length; i++){
            if(visited[i] == false && grid[source][i] == 1){
                visited[i] = true;
                dfs(i, visited, grid);
            }
        }
    }

    //approach 2 (understandable)
    private static int numberOf_Groups2(int[][] arr) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            graph.add(new ArrayList<>());
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[graph.size()];
            for(int i=0; i<graph.size(); i++){
                if(visited[i] == false){
                    dfs(i, visited, graph);
                    count++;
                }
            }
            return count;
        }

        public static void dfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> graph){
            visited[source] = true;
            for(int curr: graph.get(source)){
                if(visited[curr] == false){
                    dfs(curr, visited, graph);
                }
            }
        }
}
