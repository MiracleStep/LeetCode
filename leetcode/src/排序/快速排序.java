package 排序;

import java.util.Arrays;

public class 快速排序 {
    static int[] arrays = new int[]{12, 35, 23, 65, 21, 44, 55};
    public static void main(String[] args) {
        quickSort(0, arrays.length);
        System.out.println(Arrays.toString(arrays));
    }

    private static void quickSort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(begin, end);
        quickSort(begin, mid);
        quickSort(mid + 1, end);
    }

    private static int pivotIndex(int begin, int end) {
        int pivot = arrays[begin];
        end--;//使end指向最后一个节点的索引
        while (begin < end){
            while (begin < end) {
                if (arrays[end] >= pivot) {
                    end--;
                } else {
                    arrays[begin++] = arrays[end];
                    break;
                }
            }
            while (begin < end) {
                if (arrays[begin] <= pivot) {
                    begin++;
                } else {
                    arrays[end--] = arrays[begin];
                    break;
                }
            }
        }
        arrays[begin] = pivot;//begin == end
        return begin;
    }
}
