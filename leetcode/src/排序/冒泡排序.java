package 排序;

import java.util.Arrays;

public class 冒泡排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        for (int end = arrays.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (arrays[begin] < arrays[begin - 1]) {
                    int tmp = arrays[begin];
                    arrays[begin] = arrays[begin - 1];
                    arrays[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
        System.out.println(Arrays.toString(arrays));
    }
}
