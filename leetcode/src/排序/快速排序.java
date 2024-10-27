package 排序;

import java.util.Arrays;

public class 快速排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        quickSort(0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }

    private static void quickSort(int begin, int end) {
        if (begin >= end) return;//如果只有一个元素直接返回，递归基
        //选取一个轴点元素
        int pivot = arrays[begin], left = begin, right = end;
        while(left < right) {
            while (left < right) {
                if (arrays[right] >= pivot) {
                    right--;
                } else {
                    arrays[left++] = arrays[right];
                    break;
                }
            }
            while (left < right) {
                if (arrays[left] <= pivot) {
                    left++;
                } else {
                    arrays[right--] = arrays[left];
                    break;
                }
            }
        }
        arrays[left] = pivot;//left == right
        quickSort(begin, left - 1);  //快排左边的部分
        quickSort(left + 1, end);  //快排右边的部分
    }
}
