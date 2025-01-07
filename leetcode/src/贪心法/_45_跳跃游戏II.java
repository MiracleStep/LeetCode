package 贪心法;

public class _45_跳跃游戏II {
    public int jump(int[] nums) {
        int res = 0;
        int maxCoverage = 0;
        int endPoint = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxCoverage = Math.max(nums[i] + i, maxCoverage);
            if (i == endPoint) {
                endPoint = maxCoverage;
                res++;
                if (endPoint >= nums.length - 1) return res;
            }
        }
        return res;
    }
}
