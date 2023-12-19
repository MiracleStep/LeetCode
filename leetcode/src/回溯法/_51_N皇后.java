package 回溯法;

import java.util.*;

public class _51_N皇后 {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> leftTop = new HashSet<>();
    Set<Integer> rightTop = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n < 1) return res;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        place(queens, 0, res);
        return res;
    }

    public void place(int[] queens, int row, List<List<String>> res){
        if(row == queens.length){
            res.add(generaBoard(queens));
            return;
        }

        for(int i = 0; i < queens.length; i++){
            //第i列
            if(cols.contains(i) || leftTop.contains(row - i) || rightTop.contains(row + i)){
                //不满足条件
                continue;
            }
            queens[row] = i;
            cols.add(i);
            leftTop.add(row - i);
            rightTop.add(row + i);
            place(queens, row + 1, res);
            queens[row] = -1;
            cols.remove(i);
            leftTop.remove(row - i);
            rightTop.remove(row + i);
        }
    }
    //构建返回列表
    private List<String> generaBoard(int[] queens){
        List<String> list = new ArrayList<>();
        char[] chars = new char[queens.length];
        for(int i = 0; i < queens.length; i++){
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            list.add(new String(chars));
        }
        return list;
    }
}
