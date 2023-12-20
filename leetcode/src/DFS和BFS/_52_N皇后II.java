package DFS和BFS;

public class _52_N皇后II {
    boolean[] cols, leftTop, rightTop;
    int way = 0;
    public int totalNQueens(int n) {
        if(n == 0){
            return 0;
        }
        cols = new boolean[n];
        leftTop = new boolean[2 * n - 1];
        rightTop = new boolean[2 * n - 1];
        place(0);
        return way;
    }

    public void place(int row){
        if(row == cols.length){
            way++;
            return ;
        }
        for(int i = 0; i < cols.length; i++){
            int rc = row - i + cols.length - 1;
            if(cols[i] || leftTop[rc] || rightTop[row + i]){
                continue;
            }
            cols[i] = true;
            leftTop[rc] = true;
            rightTop[row + i] = true;
            place(row + 1);
            cols[i] = false;
            leftTop[rc] = false;
            rightTop[row + i] = false;
        }
    }
}
