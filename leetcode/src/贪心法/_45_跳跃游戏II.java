package 贪心法;

public class _45_跳跃游戏II {
    //贪心法
    public int jump(int[] nums) {
        int curCoverage = 0;
        int nextCoverage = 0;
        int res = 0;
        for(int i = 0;i < nums.length - 1; i++){
            //记录从当前节点跳到下一个节点的最大范围。
            nextCoverage = Math.max(nextCoverage, i + nums[i]);
            if(curCoverage >= nums.length - 1){
                return res;
            }
            if(i == curCoverage){//到达覆盖范围的最后一个节点
                res++;
                curCoverage = nextCoverage;
            }
        }
        return res;
    }
}
