package 贪心法;

public class _134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int profit = 0;
        int minPf = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < n; i++) {
            profit += gas[i] - cost[i];
            if (profit < minPf) {
                minPf = profit;
                minIndex = i;//找收益最小点。
            }
        }
        //亏空最严重的一个点必须放在最后一步走，等着前面剩余的救助
        //也就是说收益最小点的下一个点就是起始点
        //但是整体收益<0，肯定无法走
        return profit < 0 ? -1 : (minIndex + 1) % n;
    }
}
