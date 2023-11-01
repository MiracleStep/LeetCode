package 数组;

public class _59_螺旋矩阵II {
    public static void main(String[] args) {
        new _59_螺旋矩阵II().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int dirIndex = 0;
        int x = 0;
        int y = -1;
        for (int i = 1; i <= n*n; i++){
            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
            if ((x >= n || y >= n || x < 0 || y < 0) || ans[x][y] != 0){
                x -= dir[dirIndex][0];
                y -= dir[dirIndex][1];
                dirIndex = (dirIndex + 1) % 4;
                i--;
                continue;
            }
            ans[x][y] = i;
        }
        return ans;
    }
}
