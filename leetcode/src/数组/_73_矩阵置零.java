package 数组;

import java.util.Arrays;

public class _73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Arrays.fill(matrix[i], 0);
                    Arrays.fill(matrix, 0);
                }
            }
        }
    }
}
