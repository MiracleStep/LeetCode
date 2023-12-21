package DFS和BFS;

public class _463_岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return 1;  //到达边界，周长+1.
        }
        if(grid[x][y] == 0){
            return 1;//从陆地到海洋，周长+1.
        }
        if(grid[x][y] == 2){
            return 0;//已经便利过的陆地，与周长没有关系。
        }
        grid[x][y] = 2;//已经遍历过
        return dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
