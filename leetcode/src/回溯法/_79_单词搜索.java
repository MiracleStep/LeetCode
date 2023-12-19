package 回溯法;

public class _79_单词搜索 {
    public static void main(String[] args) {
        boolean abcced = new _79_单词搜索().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(abcced);
    }
    int m, n;
    int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited){
        if(visited[x][y] || board[x][y] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= m || nx < 0 || ny >= n || ny < 0){
                //越界检查
                continue;
            }
            if(dfs(board, word, nx, ny, index + 1, visited)) return true;
        }
        visited[x][y] = false;
        return false;
    }

    //时间&空间复杂度优化
    public boolean exist2(char[][] board, String word) {
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                //遍历每个点以确保每个点都能看看是否满足
                if(dfs2(board,word,0,i,j)) return true;
            }
        }
        //board长度为0也可以不用单独判断
        return false;
    }
    public boolean dfs2(char[][] b,String w,int l,int x,int y){
        //这里是当二维数组超出范围或者b[x][y]并不是我们需要的对应的那个字母
        if(x < 0 || x > b.length - 1 || y < 0 || y > b[0].length - 1 || b[x][y] != w.charAt(l)) return false;
        //字母的正确性在上面已经验证，只要长度一样即为成功
        if(l == w.length() - 1) return true;
        b[x][y] = '.'; // 已经遍历过了
        //然后dfs其他四个方向，长度加1
        boolean ans = dfs2(b,w,l + 1,x - 1,y) || dfs2(b,w,l + 1,x + 1,y) || dfs2(b,w,l + 1,x,y - 1) || dfs2(b,w,l + 1,x,y + 1);
        b[x][y] = w.charAt(l);
        return ans;
    }
}
