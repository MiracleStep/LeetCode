package 数组;

import java.util.Arrays;
import java.util.LinkedList;

public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        LinkedList<int[]> list = new LinkedList<>();
        // 按照各个区间的左边界升序排列
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            // 如果当前区间和上一区间有重合，直接合并
            int[] left = list.getLast();
            int[] cur = intervals[i];
            if (left[1] >= cur[0]) {
                left[1] = Math.max(left[1], cur[1]);
            } else {
                // 如果当前区间和上一区间没有重合，直接添加进最终的 res 数组中
                list.add(intervals[i]);
            }
        }
//        int[][] res = new int[list.size()][];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//
//        return res;
        return list.toArray(new int[list.size()][]);
    }
}
