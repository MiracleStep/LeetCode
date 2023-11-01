package 哈希;

import java.util.HashMap;

public class _454_四数相加II {
    //两两分组hash
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;

        for(int i : nums1){
            for(int j : nums2){
                sum = i + j;
                map.put(-sum, map.getOrDefault(-sum, 0) + 1);
            }
        }
        for(int i : nums3){
            for(int j : nums4){
                sum = i + j;
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}
