package 并查集;

import java.util.HashSet;
import java.util.Set;

public class _827_最大人工岛 {
    public static void main(String[] args) {
        System.out.println(new DFS和BFS._827_最大人工岛().largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
    int[] parent;
    int[] sizes;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new int[n * n];
        sizes = new int[n * n];
        for(int i = 0; i < n * n; i++){
            parent[i] = i;
            sizes[i] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    for(int k = 0; k < 4; k++){//四方向遍历
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1){
                            //没有越界并且是没有遍历过的陆地板块
                            union(i * n + j, nx * n + ny);
                        }
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, sizes[find(i * n + j)]);
                } else {
                    Set<Integer> set = new HashSet<>();//统计遍历过的根。
                    int num = 1;//统计面积
                    for(int k = 0; k < 4; k++){//四方向遍历
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1){
                            int root = find(nx * n + ny);
                            if(!set.contains(root)){
                                num += sizes[root];
                                set.add(root);
                            }
                        }
                    }
                    res = Math.max(res, num);
                }
            }
        }
        return res;
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx == rooty) return ;
        if(sizes[rootx] < sizes[rooty]){
            parent[rootx] = rooty;
            sizes[rooty] += sizes[rootx];
        } else {
            parent[rooty] = rootx;
            sizes[rootx] += sizes[rooty];
        }
    }
}
