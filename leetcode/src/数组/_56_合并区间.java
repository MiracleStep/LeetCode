package 数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] left = list.get(list.size() - 1);
            int[] cur = intervals[i];
            if (left[1] >= cur[0]) {
                left[1] = Math.max(left[1], cur[1]);
            } else {
                list.add(intervals[i]);
            }
        }
        // int[][] res = new int[list.size()][];
        // for (int i = 0; i < list.size(); i++) {
        //     res[i] = list.get(i);
        // }
        return list.toArray(new int[list.size()][]);
    }
}
