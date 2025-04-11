package 回溯法;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mirac
 * @date 20/9/2024
 */
public class _93_复原IP地址 {
    private List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() == 0) return res;
        Deque<String> deque = new LinkedList<>();
        dfs(s, deque, 0, 0);
        return res;
    }

    private void dfs(String s, Deque deque, int begin, int count) {
        //满足条件
        if (count == 4 && begin == s.length()) {
            res.add(String.join(".", deque));
            return;
        }
        // begin超了
        if (begin >= s.length()) {
            return;
        }
        //第一个字符有0
        if (s.charAt(begin) == '0') {
            deque.offerLast('0' + "");
            dfs(s, deque, begin + 1, count + 1);
            deque.pollLast();
            return;
        }
        //提前剪枝
        if (count == 3 && s.length() - begin > 3) {
            return;
        }
        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            String str = s.substring(begin, i + 1);
            int cur = Integer.parseInt(str);
            if (cur > 255) return;
            deque.offerLast(str);
            dfs(s, deque, i + 1, count + 1);
            deque.pollLast();
        }
    }
}
