package 排序;

public class BinarySearch {
    public static int binarySearch(int[] array, int v){
        if(array == null || array.length == 0) return -1;

        int begin = 0;
        int end = array.length;
        while (begin < end){
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else if(v > array[mid]){
                begin = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int search(int[] array, int target, int right){
        if(array == null || array.length == 0) return -1;
        int left = 0;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(array[mid] > target){
                right = mid - 1;
            }else if(array[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
