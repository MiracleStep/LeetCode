package 排序;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 9, 27, 25, 56, 37};
//        bubbleSort(array);
//        selectSort(array);
//        heapSort(array);
//        insertSort(array);

//        insertSortByBinarySearch(array);
//        MergeSort.sort(array);
//        QuickSort.sort(array);
        CountingSort.sort(array);
    }


    private static void selectSort(int[] array){
        for(int end = array.length-1; end > 0;end--){
            int maxIndex = 0;
            for(int begin = 1;begin <= end; begin++){
                if(array[maxIndex] <= array[begin]){
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }
    }


    private static void bubbleSort(int[] array) {
        for(int end = array.length - 1;end > 0;end--){
            int sortedIndex = 0;
            for(int begin = 1;begin <= end; begin++){
                if(array[begin] < array[begin-1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;

                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

    private static void insertSortByBinarySearch(int[] array) {
        for(int begin = 1;begin < array.length; begin++){
            int v = array[begin];
            int inseartIndex = BinarySearch.search(array, v, begin-1);
            for(int i = begin - 1;i >= inseartIndex;i--){
                int tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
            }
        }
    }

    private static void insertSort(int[] array) {
        for(int begin = 1;begin < array.length; begin++){
            int cur = begin;
            int v = array[cur];
            while(cur > 0 && array[begin] < array[cur-1]){
                array[cur] = array[cur-1];
                cur--;
            }
            array[cur] = v;
        }
    }

    private static void heapSort(int[] array) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < array.length;i++){
            heap.add(array[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(heap.poll());
        }

        for (int i = 0;i < array.length;i++){
            System.out.print(list.get(i) + "_");
        }
        System.out.println();
    }


}
