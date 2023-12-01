package 动态规划;

public class _96_不同的二叉搜索树 {
    public int numTrees(int n) {
        //dp表示一共节点为i个的二叉搜索树的种数
        int[] dp = new int[n+1];
        //空树这里也看做一个二叉树
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                //根节点值为j时：左子树种类*右子树的种类。
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
