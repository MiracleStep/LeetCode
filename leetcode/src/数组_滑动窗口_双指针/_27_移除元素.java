package 数组_滑动窗口_双指针;

public class _27_移除元素 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int i = new _27_移除元素().removeElement(a, 2);
        System.out.println(i);
    }

    //快慢指针法:相当于fast在喂食，每当喂slow一口值，slow就向前走一步。而fast则是往前找不背丢掉的食物。
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
