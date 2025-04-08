package 堆;

import java.util.PriorityQueue;

public class _215_数组中的第K个最大元素 {
    //堆 最简单，但面试不要写。
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums, 0, len - 1, len - k);
        return nums[len - k];
    }

    private void quickSort(int[] nums, int begin, int end, int index) {
        if (begin >= end) return;
        int mid = begin + (end - begin) / 2;
        int pivot = nums[mid];
        nums[mid] = nums[begin];
        int left = begin, right = end;
        while (left < right) {
            while (left < right) {
                if (nums[right] >= pivot) {
                    right--;
                } else {
                    nums[left++] = nums[right];
                    break;
                }
            }
            while (left < right) {
                if (nums[left] <= pivot) {
                    left++;
                } else {
                    nums[right--] = nums[left];
                    break;
                }
            }
        }
        nums[left] = pivot;
        if (left == index) {
            return;
        } else if (left < index) {
            quickSort(nums, left + 1, end, index);
        } else {
            quickSort(nums, begin, left - 1, index);
        }
    }

    //堆排序
    int len;
    public int findKthLargest3(int[] nums, int k) {
        len = nums.length;
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            siftDown(nums, i);
        }
        k--;
        while (k-- > 0) {
            swap(nums, 0, len - 1);
            len--;
            siftDown(nums, 0);
        }
        return nums[0];
    }

    private void siftDown(int[] nums, int index) {
        int cur = nums[index];
        int half = len >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int child = nums[childIndex];
            if (childIndex + 1 < len && nums[childIndex + 1] > child) {
                childIndex = childIndex + 1;
                child = nums[childIndex];
            }
            if (child > cur) {
                nums[index] = child;
                index = childIndex;
            } else {
                break;
            }
        }
        nums[index] = cur;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
