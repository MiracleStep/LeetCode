package 贪心法;

import java.util.Arrays;

public class _135_分发糖果 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        //左比较：达到局部最优，右比左多。
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            }
        }
        //右比较：达到局部最优，左比右多。
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                //已经大于则不变，不大于则左变右+1
                candy[i] = Math.max(candy[i], candy[i+1] + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += candy[i];
        }
        return res;
    }
}
