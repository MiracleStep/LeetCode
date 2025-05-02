package 数组;

public class LCR_121_寻找目标值_二维数组 {
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int m = plants.length;
        if (m == 0) return false;
        int n = plants[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            int cur = plants[x][y];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
