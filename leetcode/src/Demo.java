import java.util.Arrays;

/**
 * @author Mirac
 * @date 8/1/2025
 */
public class Demo {
    static int[] arrays = new int[]{50, 21, 80, 43, 38, 14, 56};
    static int heapSize = arrays.length;
    public static void main(String[] args) {
        for (int index = (heapSize >> 1) - 1; index >= 0; index--) {
            siftDown(index);
        }
        int k = 4;
        while (k-- > 0) {
            swap(0, --heapSize);
            siftDown(0);
        }
        System.out.println(Arrays.toString(arrays));
    }

    private static void swap(int i, int i1) {
        int tmp = arrays[i];
        arrays[i] = arrays[i1];
        arrays[i1] = tmp;
    }

    private static void siftDown(int index) {
        int cur = arrays[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = arrays[childIndex];
            if (childIndex + 1 < heapSize && arrays[childIndex + 1] < child) {
                childIndex = childIndex + 1;
                child = arrays[childIndex];
            }
            if (child < cur) {
                arrays[index] = child;
                index = childIndex;
            } else {
                break;
            }
        }
        arrays[index] = cur;
    }
}
