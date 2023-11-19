package 贪心法;

public class _738_单调递增的数字 {
    public int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int flag = nums.length;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]){
                nums[i]--;//大的尽可能变小
                flag = i + 1;//记录索引位置
            }
        }
        for(int i = flag; i < nums.length;i++){
            nums[i] = '9';
        }
        return Integer.parseInt(new String(nums));
    }
}
