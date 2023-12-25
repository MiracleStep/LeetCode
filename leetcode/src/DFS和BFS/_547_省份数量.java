package DFS和BFS;

public class _547_省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(isConnected, i, n, visited);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] isConnected, int i, int n, boolean[] visited){
        for(int j = 0; j < n; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, j, n, visited);
            }
        }
    }
}
