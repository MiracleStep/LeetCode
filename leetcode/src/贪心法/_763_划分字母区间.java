package 贪心法;

import java.util.ArrayList;
import java.util.List;

public class _763_划分字母区间 {
    //贪心法：通过局部寻找每个片段可能的最小结束下标，达到全局每个片段的长度一定是符合要求的最短长度。
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];//哈希表
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;//找到当前字符的最后一个下标
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int end = 0;//记录当前片段结束的下标
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(last[s.charAt(i) - 'a'], end);//遇到新字符就更新结束的下标
            if (i == end) {
                res.add(i - left + 1);
                left = end + 1;
            }
        }
        return res;
    }
}
