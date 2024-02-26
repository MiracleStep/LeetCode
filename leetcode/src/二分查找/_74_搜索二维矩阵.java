package 二分查找;

public class _74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
