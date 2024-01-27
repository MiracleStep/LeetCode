package 数组_滑动窗口_双指针;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return list;
        int n = matrix[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int x = 0, y = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[x][y]);
            visited[x][y] = true;

            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
            if ((x < 0 || x >= m || y < 0 || y >= n) || visited[x][y]) {
                x -= dir[dirIndex][0];
                y -= dir[dirIndex][1];
                dirIndex = (dirIndex + 1) % 4;
                x += dir[dirIndex][0];
                y += dir[dirIndex][1];
            }
        }
        return list;
    }
}

