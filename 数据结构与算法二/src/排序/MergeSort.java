package 排序;

public class MergeSort {
    private static int[] array = null;
    private static int[] leftArray;
    public static void sort(int[] array){
        leftArray = new int[array.length >> 1  ];
        MergeSort.array = array;
        mergeSort(0, array.length);

        for (int i = 0;i < MergeSort.array.length;i++){
            System.out.print(MergeSort.array[i] + "_");
        }
    }


    private static void mergeSort(int begin, int end){
        if(end - begin < 2) return;

        int mid = (begin + end) >> 1;
        mergeSort(begin, mid);
        mergeSort(mid, end);
        merge(begin, mid, end);
    }

    /* [begin, mid) [mid, end) **/
    private static void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        //备份左边数组
        for(int i = li;i < le;i++){
            leftArray[i] = array[begin + i];
        }

        while(li < le){ // 如果左边还没有结束
            if(ri < re && array[ri] < leftArray[li]){
                array[ai++] = array[ri++];
            }else {
                array[ai++] = leftArray[li++];
            }
        }
    }


}
