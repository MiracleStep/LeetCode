package DFS和BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _827_最大人工岛 {
    public static void main(String[] args) {
        System.out.println(new _827_最大人工岛().largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 1;
        int res = 0, index = 2;
        HashMap<Integer, Integer> areasMap = new HashMap();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    areasMap.put(index, dfs(index++, grid, i, j));
                }
            }
        }

        if (areasMap.size() == 0) return 1;//没有岛屿，全是海洋
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int island = buildIsland(grid, i, j, areasMap);
                    res = Math.max(res, island);
                }
            }
        }
        if(res == 0) return areasMap.get(2); //全是岛屿，没有海洋
        return res;
    }

    public int dfs(int index, int[][] grid, int x, int y) {
        if (!isLegal(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] != 1) {
            //是海洋或者是已经遍历过
            return 0;
        }
        grid[x][y] = index;
        return 1 + dfs(index, grid, x + 1, y) + dfs(index, grid, x - 1, y)
                + dfs(index, grid, x, y + 1) + dfs(index, grid, x, y - 1);
    }

    //构建人工岛屿，返回岛屿的面积
    public int buildIsland(int[][] grid, int row, int column, HashMap<Integer, Integer> areasMap) {
        Set<Integer> set = new HashSet<>();
        if (isLegal(grid, row + 1, column) && grid[row + 1][column] != 0) set.add(grid[row + 1][column]);
        if (isLegal(grid, row - 1, column) && grid[row - 1][column] != 0) set.add(grid[row - 1][column]);
        if (isLegal(grid, row, column + 1) && grid[row][column + 1] != 0) set.add(grid[row][column + 1]);
        if (isLegal(grid, row, column - 1) && grid[row][column - 1] != 0) set.add(grid[row][column - 1]);
        int result = 1;

        for (Integer item : set) {
            result += areasMap.get(item);
        }
        return result;
    }

    public boolean isLegal(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
