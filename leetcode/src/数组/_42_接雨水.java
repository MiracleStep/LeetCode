package 数组;

public class _42_接雨水 {
    //动态规划
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            // i坐标左右两边最大值的最小值
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
    //双指针
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1;
        int rightMax = 0, leftMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                //此时右边rightMax不可能变为leftMax更小了,因此可以计算left所在索引的雨水高度
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
