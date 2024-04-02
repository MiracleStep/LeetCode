package 位运算;

public class LCR_006_两数之和_II_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int cur = numbers[left] + numbers[right];
            if (cur > target) {
                right--;
            } else if (cur < target) {
                left++;
            } else {
                res[0] = left;
                res[1] = right;
                return res;
            }
        }
        return res;
    }
}
