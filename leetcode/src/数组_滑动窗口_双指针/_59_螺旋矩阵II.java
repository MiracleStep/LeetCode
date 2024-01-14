package 数组_滑动窗口_双指针;

public class _59_螺旋矩阵II {
    public static void main(String[] args) {
        new _59_螺旋矩阵II().generateMatrix(3);
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int dirIndex = 0;

        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;

            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
            if ((x >= n || y >= n || x < 0 || y < 0) || res[x][y] != 0) {
                //越界处理
                x -= dir[dirIndex][0];
                y -= dir[dirIndex][1];
                dirIndex = (dirIndex + 1) % 4;
                x += dir[dirIndex][0];
                y += dir[dirIndex][1];
            }
        }
        return res;
    }
}
