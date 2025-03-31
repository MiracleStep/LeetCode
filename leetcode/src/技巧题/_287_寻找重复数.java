package 技巧题;

public class _287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;

        // 在 [1..n] 查找 nums 中重复的元素
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];//跳一次
            fast = nums[nums[fast]];//跳两次
            if (slow == fast) {
                int tmp = 0;
                while (tmp != slow) {
                    tmp = nums[tmp];
                    slow = nums[slow];
                }
                return slow;
            }
        }
    }
}
