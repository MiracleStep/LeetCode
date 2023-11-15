package 贪心法;

public class _122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int maxProfile = 0;
        for(int i = 1;i < prices.length; i++){
            int profile = prices[i] - prices[i - 1];
            if(profile > 0){
                maxProfile += profile;
            }
        }
        return maxProfile;
    }
}
