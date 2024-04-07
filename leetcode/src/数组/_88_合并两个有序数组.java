package 数组;

public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int cur = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[cur--] = nums2[j--];
            } else if (j == -1) {
                nums1[cur--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }
    }
}
