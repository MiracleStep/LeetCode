package 排序;

import java.util.Arrays;

public class 选择排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        for (int end = arrays.length - 1; end > 0; end--) {
            int max = 0;
            for (int i = 1; i <= end; i++) {
                if (arrays[max] < arrays[i]) {
                    max = i;
                }
            }
            swap(max, end);
        }
        System.out.println(Arrays.toString(arrays));
    }
    private static void swap(int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}
