package 回溯法;

import java.util.*;

public class _51_N皇后 {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> leftTop = new HashSet<>();
    Set<Integer> rightTop = new HashSet<>();

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return res;
        }
        int[] places = new int[n];
        Arrays.fill(places, -1);
        dfs(n, 0, places);
        return res;
    }

    public void dfs(int n, int row, int[] places) {
        if (row == n) {
            getAns(n, places);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || leftTop.contains(col - row) || rightTop.contains(col + row)) {
                //不满足条件
                continue;
            }
            cols.add(col);
            leftTop.add(col - row);
            rightTop.add(col + row);
            places[row] = col;
            dfs(n, row + 1, places);
            places[row] = -1;
            cols.remove(col);
            leftTop.remove(col - row);
            rightTop.remove(col + row);
        }
    }

    public void getAns(int n, int[] places) {
        List<String> list = new ArrayList<>();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            int col = places[i];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            list.add(new String(chars));
        }
        res.add(list);
    }
}
