package 贪心法;

public class _45_跳跃游戏II {
    public int jump(int[] nums) {
        int res = 0;
        int maxCoverage = 0;
        int endPoint = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxCoverage = Math.max(maxCoverage, i + nums[i]);
            if (i == endPoint) {
                res++;
                endPoint = maxCoverage;
                if (endPoint >= nums.length - 1) {//剪枝：判断是否能够提前结束
                    return res;
                }
            }
        }
        return res;
    }
}
