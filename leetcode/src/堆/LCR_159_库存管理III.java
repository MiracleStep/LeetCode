package 堆;

public class LCR_159_库存管理III {
    public int[] inventoryManagement(int[] stock, int cnt) {
        quickSort(stock, cnt - 1, 0, stock.length - 1);
        int[] res = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            res[i] = stock[i];
        }
        return res;
    }

    private void quickSort(int[] stock, int index, int begin, int end) {
        if (begin >= end) return;

        int mid = begin + (end - begin) / 2;
        int pivot = stock[mid];
        stock[mid] = stock[begin];
        int left = begin, right = end;
        while (left < right) {
            while (left < right) {
                if (stock[right] >= pivot) {
                    right--;
                } else {
                    stock[left++] = stock[right];
                    break;
                }
            }
            while (left < right) {
                if (stock[left] <= pivot) {
                    left++;
                } else {
                    stock[right--] = stock[left];
                    break;
                }
            }
        }
        stock[left] = pivot;

        if (left < index) {
            quickSort(stock, index, left + 1, end);
        } else if (left > index) {
            quickSort(stock, index, begin, left - 1);
        } else {
            return;
        }
    }
}
