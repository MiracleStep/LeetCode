package 数组;

public class _238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //前缀乘积，只需要定义len即可
        int[] pre = new int[n];
        //后缀乘积
        int[] post = new int[n];
        pre[0] = post[n - 1] = 1;
        //计算前缀和后缀乘积
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[n - i - 1] = post[n - i] * nums[n - i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
