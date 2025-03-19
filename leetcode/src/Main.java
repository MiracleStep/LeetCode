public class Main {
    private static int heapSize;
    public static void main(String[] args) {
        int[] arrays = new int[20];
        heapSize = arrays.length;
        for (int i = (heapSize >> 2) - 1; i >= 0; i--) {
            siftDown(arrays, i);
        }
        while (heapSize > 1) {
            int tmp = arrays[0];
            arrays[0] = arrays[--heapSize];
        }
    }

    private static void siftDown(int[] arrays, int index) {
        int cur = arrays[index];
        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = arrays[childIndex];
            if (childIndex + 1 < heapSize && arrays[childIndex + 1] > child) {
                childIndex = childIndex + 1;
                child = arrays[childIndex + 1];
            }
            if (child > cur) {
                arrays[index] = child;
                index = childIndex;
            } else {
                break;
            }
        }
        arrays[index] = cur;
    }
}