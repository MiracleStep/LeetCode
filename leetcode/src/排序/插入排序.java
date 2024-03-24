package 排序;

import java.util.Arrays;

public class 插入排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        for (int i = 1; i < arrays.length; i++) {
            int cur = i;
            int val = arrays[cur];
            while (cur > 0 && arrays[cur] < arrays[cur - 1]) {
                arrays[cur] = arrays[cur - 1];
                cur--;
            }
            arrays[cur] = val;
        }
        System.out.println(Arrays.toString(arrays));
    }
    private static void swap(int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}
