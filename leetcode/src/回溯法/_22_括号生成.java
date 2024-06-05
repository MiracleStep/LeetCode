package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        dfs(new StringBuilder(), n, n);
        return res;
    }

    private void dfs(StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        if(left > 0) {
            sb.append("(");
            dfs(sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0 && right > left) {
            sb.append(")");
            dfs(sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
