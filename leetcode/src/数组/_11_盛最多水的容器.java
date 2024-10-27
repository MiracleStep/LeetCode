package 数组;

/**
 * @author Mirac
 * @date 26/10/2024
 */
public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int curArea = 0;
            if (height[left] <= height[right]) {
                curArea = (right - left) * height[left];
                while (left < right && height[left] >= height[++left]);
            } else {
                curArea = (right - left) * height[right];
                while (left < right && height[right] >= height[--right]);
            }
            res = Math.max(res, curArea);
        }
        return res;
    }
}
