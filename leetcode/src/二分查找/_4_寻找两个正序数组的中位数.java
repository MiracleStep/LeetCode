package 二分查找;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int totalLength = m + n;
        double res = 0;
        if (totalLength % 2 == 1) {
            res = findKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {
            res = (findKthElement(nums1, nums2, totalLength / 2) + findKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
        return res;
    }

    //寻找两个有序数组中的第k小的数
    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int left1 = 0;
        int left2 = 0;
        while (true) {
            if (left1 >= nums1.length) { //nums1没有可以用的了
                return nums2[left2 + k - 1];
            } else if (left2 >= nums2.length) { //nums2没有可以用的了
                return nums1[left1 + k - 1];
            } else if (k == 1) { //k == 1返回最小的那一个就是第1小的
                return Math.min(nums1[left1], nums2[left2]);
            } else {
                int mid = k / 2 - 1;
                int index1 = left1 + mid;
                int index2 = left2 + mid;
                if (index1 >= nums1.length) index1 = nums1.length - 1;
                if (index2 >= nums2.length) index2 = nums2.length - 1;
                if (nums1[index1] <= nums2[index2]) { //排除num1的部分元素
                    k -= index1 - left1 + 1;
                    left1 = index1 + 1;
                } else { //排除num2的部分元素
                    k -= index2 - left2 + 1;
                    left2 = index2 + 1;
                }
            }
        }
    }
    //合并数组
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int count = 0;
        int i = 0, j = 0;
        while (count != nums.length) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}
