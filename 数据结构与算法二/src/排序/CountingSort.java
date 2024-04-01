package 排序;

public class CountingSort {
    private static int[] array = null;

    public static void sort(int[] array){
        CountingSort.array = array;

        int max = array[0];
        int min = array[0];
        for(int i = 0;i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        int[] counts = new int[max - min + 1];
        for(int i = 0;i < array.length; i++){
            counts[array[i] - min]++;
        }
        //累加计数
        for(int i = 1;i < counts.length; i++){
            counts[i] += counts[i - 1];
        }

        //从后往前遍历元素，将它放在有序数组的合适位置
        int[] newArray = new int[array.length];
        for(int i = array.length - 1; i >= 0; i--){
            newArray[--counts[array[i] - min]] = array[i];
        }

        //将有序数组赋值到array
        for(int i = 0; i < newArray.length;i++){
            array[i] =  newArray[i];
        }

        for (int i = 0; i < CountingSort.array.length; i++){
            System.out.print(CountingSort.array[i] + "_");
        }
    }
}
