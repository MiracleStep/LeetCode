package 贪心法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class _56_合并区间 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        // 按照各个区间的左边界升序排列
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 记录最终的不重叠区间数组
        LinkedList<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        // 遍历数组
        for (int i = 1; i < n; i++) {
            // 如果当前区间和上一区间有重合，直接合并
            if (res.getLast()[1] >= intervals[i][0]) {
                int left = res.getLast()[0];
                int right = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{left, right});
            } else {
                // 如果当前区间和上一区间没有重合，直接添加进最终的 res 数组中
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        //直接调用API排序即可，注意Comparator传入的需要是引入数据类型(不是基本数据类型)
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new LinkedList<>();
        int[] left = null;
        for (int[] cur : intervals) {
            if (left == null) {
                left = cur;
                list.add(left);
            } else {
                if (left[1] >= cur[0]) {
                    //有重叠区间
                    left[1] = Math.max(left[1], cur[1]);//更新left(left已经保存到list中了)
                } else {
                    //没有重叠区间，添加到list中
                    left = cur;
                    list.add(left);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
