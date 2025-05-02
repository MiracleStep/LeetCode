package 数组;

public class _LCR_126_斐波那契数 {
    public int fib(int n) {
        int mod = 1000000007;
        if (n == 0 || n == 1) {
            return n;
        }
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        // }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }
        return c;
    }
}
