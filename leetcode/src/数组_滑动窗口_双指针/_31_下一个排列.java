package 数组_滑动窗口_双指针;

public class _31_下一个排列 {
    public void nextPermutation(int[] nums) {
        //3421
        int n = nums.length;
        int i = n - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                //找到升序的两个数nums[i] < nums[i + 1]， 其后面都是降序
                int j = i + 1;
                while (j < n && nums[j] > nums[i]) j++;
                swap(nums, i, j - 1);//交换比nums[i]大的最小的数
                reverse(nums, i + 1, n - 1);//其后面的降序直接翻转
                break;
            }
        }
        if (i == -1) { //已经是最大的了
            reverse(nums, 0, n - 1);
        }
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
