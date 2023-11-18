package 贪心法;

import java.util.Arrays;

public class _435_无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 1){
            return 0;
        }
        // 按照区间右边界排序
        Arrays.sort(intervals,(a, b)->a[1] - b[1]);
        // 记录区间右边界（如果有重叠区，是重叠区的最小右边界）
        int end = intervals[0][1];
        // 记录互不重叠的区间个数
        int res = 1;
        // 遍历数组
        for(int i = 0; i < n; i++){
            // 如果重叠区的最小右边界 <= 当前区间的左边界
            // 证明两个区间不重叠
            if(end <= intervals[i][0]){
                //更新互不重叠的区间个数
                res += 1;
                // 更新最小右边界为当前区间的右边界
                end = intervals[i][1];//也相当于再说：如果两区间重合，删除右边界最大的。
            }
        }
        // 总数 - 互不重叠区间的个数 = 需要移除的区间数
        return n - res;
    }
}
