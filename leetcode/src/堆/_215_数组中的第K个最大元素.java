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

    //快速排序
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    //结束条件就是到达倒数第k个，因为根据快排的规定，选择的轴点元素位置不会改变，只会继续对左右元素进行排序
    private int quickSort(int[] nums, int begin, int end, int k) {
        if (begin == end) return nums[begin];
        int pivot = nums[begin], left = begin, right = end;
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
        //轴点元素位置
        if (left == k) return nums[left];
        if (left > k) {
            return quickSort(nums, begin, left - 1, k);
        } else {
            return quickSort(nums, left + 1, end, k);
        }
    }
}
