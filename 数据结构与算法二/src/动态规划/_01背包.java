package 动态规划;

public class _01背包 {
    public static void main(String[] args) {
        System.out.println(select(new int[]{6,3,5,4,6}, new int[]{2,2,6,5,4}, 10));
    }

    static int select(int[] values, int[] weights, int capacity){
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++){
            for (int j = 1; j <= capacity; j++){
                if (j < weights[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[values.length][capacity];
    }

    static int select2(int[] values, int[] weights, int capacity){
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++){
            for (int j = capacity; j >= 1; j--){
                if (j < weights[i - 1]) continue;
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    static int select3(int[] values, int[] weights, int capacity){
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int j = 1; j <= capacity; j++){
            dp[j] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= values.length; i++){
            for (int j = capacity; j >= 1; j--){
                if (j < weights[i - 1]) continue;
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }
}
