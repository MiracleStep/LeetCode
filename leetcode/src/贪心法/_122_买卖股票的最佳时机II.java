package 贪心法;

import sun.applet.AppletClassLoader;

public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        //贪心策略：只要今天股价比昨天高，就交易。
        int res = 0;
        if (prices.length < 2) {
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }
}
