package 回溯法;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String cur, int left, int right, List<String> res){
        if(left == 0 && right == 0){
            res.add(cur);
            return;
        }
        if(left > 0){
            dfs(cur + "(", left - 1, right, res);
        }

        if(left < right){
            dfs(cur + ")", left, right - 1, res);
        }
    }
}
