package 并查集;

public class _200_岛屿数量 {
    class UnionFind{
        //可以基于rank优化
        int count;
        int[] parent;

        public UnionFind(char[][] grid){
            //初始化
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        parent[i * n + j] = i * n + j;
                        count++;//统计集合数量
                    }
                }
            }
        }

        public int find(int i){
            while(i != parent[i]){
                i = parent[i];
            }
            return i;
        }

        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty) {
                parent[rootx] = rooty;
                count--;
            }
        }

        public int getCount(){
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '2';//标记访问过
                    if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if(i + 1 < m && grid[i + 1][j] == '1'){
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                        uf.union(i * n + j, i * n + (j - 1));
                    }
                    if(j + 1 < n && grid[i][j + 1] == '1'){
                        uf.union(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }
        return uf.getCount();
    }
}
