package 排序;

public class QuickSort {

    private static int[] array;

    public static void sort(int[] array){
        QuickSort.array = array;
        sort(0, array.length);

        for (int i = 0;i < QuickSort.array.length;i++){
            System.out.print(QuickSort.array[i] + "_");
        }
    }

    private static void sort(int begin, int end){
        if (end - begin < 2)return;
        //确定轴点位置
        int mid = pivotIndex(begin, end);
        //对子序列进行快速排序
        sort(begin, mid);
        sort(mid + 1, end);
    }

    /**
     * 构造 [begin, end) 范围的轴点元素
     * @return 轴点元素的最终位置
     */
    private static int pivotIndex(int begin, int end){
        int pivot = array[begin];
        // end指向最后一个元素
        end--;

        while (begin < end){
            while (begin < end){
                if(pivot < array[end]){
                    end--;
                }else {
                    array[begin++] = array[end];
                }
            }
            while (begin < end) {
                if (pivot > array[begin]) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                }
            }
        }
        //将轴点元素放入最终位置
        array[begin] = pivot;
        return begin;
    }
}
