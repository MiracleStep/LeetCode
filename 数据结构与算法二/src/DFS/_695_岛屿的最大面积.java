package DFS;

import java.util.Stack;

public class _695_岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int nr = grid.length;
        if (nr == 0) return 0;
        int nc = grid[0].length;
        if (nc == 0) return 0;

        int ans = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    ans = Math.max(ans, dfs(grid, r, c));
                }
            }
        }
        return ans;
    }


    public int dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r >= nr || c >= nc || r < 0 || c < 0) return 0;
        if (grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int res = 1;

        res += dfs(grid, r + 1, c);
        res += dfs(grid, r - 1, c);
        res += dfs(grid, r, c + 1);
        res += dfs(grid, r, c - 1);

        return res;
    }

    class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    //利用栈实现
    public int maxAreaOfIsland2(int[][] grid) {
        int nr = grid.length;
        if (nr == 0) return 0;
        int nc = grid[0].length;
        if (nc == 0) return 0;
        int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int ans = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    grid[r][c] = 0;
                    int res = 1;

                    Stack<Node> stack = new Stack<Node>();
                    stack.push(new Node(r, c));
                    while (!stack.isEmpty()) {
                        Node node = stack.pop();
                        for (int k = 0; k < 4; k++) {
                            int x = node.r + direct[k][0];
                            int y = node.c + direct[k][1];

                            if(x >= 0 && y >= 0 && x < nr && y < nc && grid[x][y] == 1){
                                grid[x][y] = 0;
                                res++;
                                stack.push(new Node(x, y));
                            }
                        }
                    }
                    ans = Math.max(ans, res);
                }
            }
        }
        return ans;
    }
}
