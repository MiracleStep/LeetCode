package 回溯法;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mirac
 * @date 20/9/2024
 */
public class _93_复原IP地址 {
    List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return res;
        Deque<String> deque = new LinkedList<>();
        dfs(deque, 0, 4, s, 0);
        return res;
    }

    private void dfs(Deque<String> deque, int begin, int n, String s, int count) {
        //到达最大长度并且收集到4个
        if (begin == s.length() && count == 4) {
            res.add(String.join(".", deque));
            return;
        }

        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            //剪枝条件1：后面元素不够用了，如：[10,102,3]
            //剪枝条件2：后面元素太多了，如：[1,0,1,0,...]
            //也可以采用更多的剪枝
            // if(count + (s.length()- begin) < 4 ||
            //     count == 4 && begin != s.length()) {
            //     break;
            // }
            // 长度大于1，并且第一位有0，直接返回
            if (i > begin && s.charAt(begin) == '0') {
                return;
            }
            // 大于255，直接返回
            String curStr = s.substring(begin, i + 1);
            if (Integer.parseInt(curStr) > 255) {
                return;
            }
            //进行回溯递归
            deque.offer(curStr);
            dfs(deque, i + 1, n, s, count + 1);
            deque.pollLast();
        }
    }
}
