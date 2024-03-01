package 堆;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });//维护空间大小为k
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            heap.offer(new int[]{num, count});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll()[0];
        }
        return res;
    }
}
