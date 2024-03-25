package 排序;

import java.util.Arrays;

public class 堆排序 {
    static int[] arrays = new int[]{50, 21, 80, 43, 38, 14};
    private static int heapSize;
    public static void main(String[] args) {
        heapSort();
        System.out.println(Arrays.toString(arrays));
    }

    private static void heapSort() {
        //原地建堆
        heapSize = arrays.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {//最后一个非叶子结点索引：(heapSize / 2) - 1
            siftDown(i);
        }
        //利用堆进行排序
        while (heapSize > 1) {
            //交换堆顶元素和尾部元素
            swap(0, --heapSize);
            // 对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }

    }
    //下滤 时间复杂的：O(logn)
    private static void siftDown(int index) {
        int cur = arrays[index];//当前下滤的节点
        int half = heapSize >> 1;
        while (index < half) {//index可以是所有非叶子结点的索引
            //默认是左子结点跟父节点比
            int childIndex = (index << 1) + 1;
            int child = arrays[childIndex];
            //右子节点比左子结点大
            if (childIndex + 1 < heapSize && arrays[childIndex + 1] > arrays[childIndex]) {//存在右子节点并且右子节点大于左子结点
                //替换为右子节点
                childIndex = childIndex + 1;
                child = arrays[childIndex];
            }
            if (child > arrays[index]) {
                //当前节点小于子节点
                 arrays[index] = child;
                 index = childIndex;
            } else {
                break;
            }
        }
        arrays[index] = cur;
    }

    private static void swap(int i, int j) {
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;
    }
}
