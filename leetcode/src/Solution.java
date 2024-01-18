class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < len; i++) { //相当于计算前缀和
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int post = 1;
        for (int i = len - 2; i >= 0; i--) {
            post *= nums[i + 1];//计算后缀和
            ans[i] *= post;
        }
        return ans;
    }
}