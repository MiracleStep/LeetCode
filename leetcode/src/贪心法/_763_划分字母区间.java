package 贪心法;

import java.util.ArrayList;
import java.util.List;

public class _763_划分字母区间 {
    //贪心法：通过局部寻找每个片段可能的最小结束下标，达到全局每个片段的长度一定是符合要求的最短长度。
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];//hash表
        for (int i = 0; i < n; i++) {
            hash[chars[i] - 'a'] = i;
        }
        int begin = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(hash[chars[i]- 'a'], end);
            if (i == end) {
                res.add(end - begin + 1);
                end += 1;
                begin = end;
            }
        }
        return res;
    }
}
