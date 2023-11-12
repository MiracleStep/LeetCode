package 贪心法;

public class _55_跳跃游戏 {
    //贪心法
    public boolean canJump(int[] nums) {
        int maxCoverage = 0;
        for(int i = 0;i < nums.length;i++){
            if(i <= maxCoverage){
                maxCoverage = Math.max(maxCoverage, i + nums[i]);
                if(maxCoverage >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
