package DFS和BFS;

public class _695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int cur = dfs(grid, i, j);
                    res = Math.max(cur, res);
                }
            }
        }
        return res;
    }

    //计算当前岛屿面积并返回
    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return 0;
        }
        if(grid[x][y] != 1){
            return 0;
        }
        grid[x][y] = 2;//当前为遍历过的陆地
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
