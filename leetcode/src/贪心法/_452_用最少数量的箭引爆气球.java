package 贪心法;

import java.util.Arrays;

public class _452_用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        new _452_用最少数量的箭引爆气球().findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        //排序：右边界从小到大排序，不能用a[1] - b[1]因为从题目可以看出，会溢出
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        //该题可以转化为求不重叠的区间，有多少不重叠的区间就射箭多少次。
        //这个不重叠区间有限制：射击点为两个重叠区间的最小的右边界。覆盖这个射击点才算重叠。
        int res = 1;//不重叠区间的个数。
        int end = points[0][1];
        for(int i = 1; i < n; i++){
            if(end < points[i][0]){
                //按照条件为不重叠。
                res++;
                end = points[i][1];//不重叠则为右边区间的右边界。
            }
        }
        return res;
    }
}
