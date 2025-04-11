public class Main {
    public static void main(String[] args) {
        String poiHotel = "希尔顿";
        String descHotel = "携程度假";
        int m = poiHotel.length();
        int n = descHotel.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;//删除操作
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;//删除操作
        }
        //状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (poiHotel.charAt(i - 1) == descHotel.charAt(j - 1)) {
                    //相等：不需要新的操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不相等：从左到右分别是：新增一个字符、删除一个字符、替换一个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        int num = dp[m][n];
        int rate = num * 100 / n;
        if (rate > 66) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}