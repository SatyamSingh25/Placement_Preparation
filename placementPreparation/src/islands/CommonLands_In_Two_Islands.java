package islands;

public class CommonLands_In_Two_Islands {
    public static int countSubIslands(int[][] grid1, int[][] grid2){
        int count = 0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                boolean flag = true;
                if(grid2[i][j] == 1){
                    dfs(i, j, grid1, grid2, flag);
                    if(flag){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void dfs(int i, int j, int[][] grid1, int[][] grid2, boolean flag){
        if(i<0 || i>=grid2.length || j<0 || j>=grid2[0].length)
            return;

        if(grid2[i][j] == 0)
            return;

        if(grid2[i][j] == 1){
            if(grid1[i][j] == 0){
                flag = false;
                return;
            }
            grid2[i][j] = 0;
        }
        dfs(i+1, j, grid1, grid2, flag);
        dfs(i-1, j, grid1, grid2, flag);
        dfs(i, j+1, grid1, grid2, flag);
        dfs(i, j-1, grid1, grid2, flag);
    }

    public static void main(String[] args){
        int[][] grid1 = new int[][]{{1,1,1,0,0},
                                    {0,1,1,1,1},
                                    {0,0,0,0,0},
                                    {1,0,0,0,0},
                                    {1,1,0,1,1}};

        int[][] grid2 = new int[][]{{1,1,1,0,0},
                                    {0,0,1,1,1},
                                    {0,1,0,0,0},
                                    {1,0,1,1,0},
                                    {0,1,0,1,0}};
        //result -> 3
        System.out.print(countSubIslands(grid1, grid1));
    }

//     class Pair{
//         int i, j;
//         Pair(){
//             this.i = 0;
//             this.j = 0;
//         }
//         Pair(int i, int j){
//             this.i = i;
//             this.j = j;
//         }
//     }

//     public int countSubIslands(int[][] grid1, int[][] grid2) {
//         ArrayList<Pair> cordinates = new ArrayList<>();
//         ArrayList<ArrayList<Pair>> lands = new ArrayList<>();

//         int count = 0;

//         for(int i=0; i<grid2.length; i++){
//             for(int j=0; j<grid2[0].length; j++){
//                 if(grid2[i][j] == 1){
//                     cordinates = new ArrayList<Pair>();
//                     dfs(i, j, grid2, cordinates);
//                     lands.add(cordinates);
//                 }
//             }
//         }
//         int flag = 0;
//         for(int i=0; i<lands.size(); i++){
//             cordinates = lands.get(i);
//             for(Pair pair: cordinates){
//                 if(grid1[pair.i][pair.j] != 1){
//                     flag = 1;
//                     break;
//                 }
//             }
//             if(flag == 0){
//                 count++;
//             }
//             flag = 0;
//         }
//         return count;
//     }
//     private void dfs(int i, int j, int[][] grid, ArrayList<Pair> cords){
//         if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
//             return;
//         }
//         grid[i][j] = 0;
//         cords.add(new Pair(i, j));
//         dfs(i+1, j, grid, cords);
//         dfs(i-1, j, grid, cords);
//         dfs(i, j+1, grid, cords);
//         dfs(i, j-1, grid, cords);
//     }
}
