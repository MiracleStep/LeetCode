package 数组_滑动窗口_双指针;

public class _209_长度最小的子数组 {
    public static void main(String[] args) {
        System.out.println(new _209_长度最小的子数组().minSubArrayLen2(4, new int[]{1,4,4}));
    }
    // 双指针
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length || sum >= target; ){
            if (sum >= target){
                minLen = Math.min(minLen, j - i);
                sum -= nums[i++];
            } else {
                sum += nums[j++];
            }
        }
        if (minLen == Integer.MAX_VALUE){
            minLen = 0;
        }
        return minLen;
    }

    // 优化，双指针 *
    public int minSubArrayLen2(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
            while (sum >= target){
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
        }
        if (minLen == Integer.MAX_VALUE){
            minLen = 0;
        }
        return minLen;
    }
}
