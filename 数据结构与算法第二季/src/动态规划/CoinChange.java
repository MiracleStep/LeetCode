package 动态规划;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coins(41, new int[]{1, 5, 20, 25}));
    }

    //通用实现
    int coins(int n, int[] faces){
        if (n < 1 || faces == null || faces.length == 0)return -1;
        int[] dp = new int[n + 1];
        for (int i = 1;i <= n;i++){
            int min = Integer.MAX_VALUE;
            for (int face : faces) {
                if (i >= face && dp[i - face] != -1 && dp[i - face] < min){
                    min = dp[i - face];
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min + 1;
            }
        }
        return dp[n];
    }

    int coint(int n){
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = new int[n + 1];
        for (int i = 1;i <= n;i++){
            int min = Integer.MAX_VALUE;
            if (i >=  1 && dp[i - 1] < min){
                min = dp[i - 1];
                faces[i] = 1;
            }
            if (i >= 5 && dp[i - 5] < min){
                min = dp[i - 5];
                faces[i] = 5;
            }
            if (i >= 20 && dp[i - 20] < min){
                min = dp[i - 20];
                faces[i] = 20;
            }
            if (i >= 25 && dp[i - 25] < min){
                min = dp[i - 25];
                faces[i] = 25;
            }
            dp[i] = min + 1;
        }
        print(faces, n);
        return dp[n];
    }

    private void print(int[] faces, int n) {
        while (n > 0){
            System.out.println(faces[n]+" ");
            n -= faces[n];
        }
    }
}
