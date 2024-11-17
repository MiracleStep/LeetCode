package 数组;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 1 && n == 0) return;
        if (m == 0 && n == 1) {
            nums1[0] = nums2[0];
            return;
        }
        int left = m - 1, right = n - 1;
        int cur = m + n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[cur--] = nums1[left--];
            } else {
                nums1[cur--] = nums2[right--];
            }
        }

        while (left >= 0) {
            nums1[cur--] = nums1[left--];
        }

        while (right >= 0) {
            nums1[cur--] = nums2[right--];
        }
    }
}
