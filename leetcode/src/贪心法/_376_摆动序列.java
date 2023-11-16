package 贪心法;

public class _376_摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        // [1, 7, 4, 9, 2, 5]
        // [1, 4, 7, 2, 5]
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int tend = 0;//tend：0表示初始化，1表示前一个是上升序列，-1前一个是下降序列。
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            int result = nums[i] - nums[i-1];
            if(tend >= 0 && result < 0){
                ans++;
                tend = -1;
            } else if(tend <= 0 && result > 0){
                ans++;
                tend = 1;
            }
        }
        return ans;
    }
}
