package 并查集;

public class _547_省份数量 {

    public static void main(String[] args) {
        System.out.println(new _547_省份数量().findCircleNum(new int[][]{{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 1}}));;
    }
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0){
            return 0;
        }
        int n = isConnected.length;
        //初始化并查集
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            //每个城市是单独的一个个体(一个省).
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    //两个城市相连。
                    isConnected[i][j] = 2;//标记为访问过。
                    isConnected[j][i] = 2;
                    union(parent, i, j);//合并为一个集合(一个省份)。
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                //统计有多少根。
                res++;
            }
        }
        return res;
    }
    public int find(int[] parent, int x){
        if(parent[x] != x){
            //不是根
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y){
        parent[find(parent, x)] = find(parent, y);
    }
}
