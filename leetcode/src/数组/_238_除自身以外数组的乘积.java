package 数组;

public class _238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[nums.length];
        //前缀乘积
        int[] pre = new int[len];
        //后缀乘积
        int[] post = new int[len];
        pre[0] = post[len - 1] = 1;
        //计算前缀和后缀乘积
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
            post[len - i - 1] = post[len - i] * nums[len - i];
        }

        for (int i = 0; i < len; i++) {
            answer[i] = pre[i] * post[i];
        }
        return answer;
    }
}
