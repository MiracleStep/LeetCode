package 贪心法;

public class _11_盛最多水的容器 {
    //优化
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxRes = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);//计算当前面积
            if (area > maxRes) {
                maxRes = area;
            }
            //移动双指针
            if (height[left] <= height[right]) { //左边更矮
                // left++;
                int preHeight = height[left];
                do {
                    left++; //持续移动左节点，直到找到更高的。
                } while (left < right && height[left] <= preHeight);
            } else { //右边更矮
                // right--;
                int preHeight = height[right];
                do {
                    right--;
                } while (left < right && height[right] <= preHeight);
            }
        }
        return maxRes;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int ans = 0;
            if (height[left] <= height[right]) {
                ans = height[left] * (right - left);
                left++;
            } else {
                ans = height[right] * (right - left);
                right--;
            }
            res = Math.max(res, ans);
        }
        return res;
    }
}
