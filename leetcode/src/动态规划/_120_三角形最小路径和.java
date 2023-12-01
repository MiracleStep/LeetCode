package 动态规划;

import java.util.List;

public class _120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        //dp表示i层下标为j的位置的最小路径和
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;

        for(int i = 1; i < len; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    //来自上一层的当前索引
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if(j != i){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                } else {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }
            }
        }
        for(int i = 0; i < len; i++){
            res = Math.min(res, dp[len - 1][i]);
        }
        return res;
    }
}
