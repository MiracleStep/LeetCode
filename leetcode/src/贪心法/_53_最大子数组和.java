package 贪心法;

public class _53_最大子数组和 {
    //贪心：找局部最大和的连续子数组，得到全局的最大连续子数组的和。
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int preMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(preMax < 0){
                preMax = nums[i];
            } else {
                preMax = preMax + nums[i];
            }
            if(res < preMax){
                res = preMax;
            }
        }
        return res;
    }
}
