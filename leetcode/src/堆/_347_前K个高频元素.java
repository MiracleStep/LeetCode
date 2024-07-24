package 堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });

        for (int key : map.keySet()) {
            heap.offer(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[heap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
