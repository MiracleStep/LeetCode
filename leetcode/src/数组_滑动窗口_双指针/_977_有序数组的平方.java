package 数组_滑动窗口_双指针;

public class _977_有序数组的平方 {
    public static void main(String[] args) {
        new _977_有序数组的平方().sortedSquares(new int[]{-4,-1,0,3,10});
    }
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] newArray = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right){
            if (nums[left] * nums[left] >= nums[right] * nums[right]){
                newArray[index--] = nums[left] * nums[left];
                left++;
            } else {
                newArray[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return newArray;
    }
}
