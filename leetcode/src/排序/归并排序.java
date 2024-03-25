package 排序;

import java.util.Arrays;

public class 归并排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        sort(0, arrays.length);
        System.out.println(Arrays.toString(arrays));
    }
    private static void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = begin + (end - begin) / 2;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private static void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int cur = begin;
        int[] leftArray = new int[le];
        for (int i = li; i < le; i++) {
            leftArray[i] = arrays[begin + i];
        }
        while (li < le) {
            if (ri < re && arrays[ri] < leftArray[li]) {
                arrays[cur++] = arrays[ri++];
            } else {
                arrays[cur++] = leftArray[li++];
            }
        }
    }
}
