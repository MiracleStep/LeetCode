package 哈希;

import java.util.*;

public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> addSet = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            hashSet.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(hashSet.contains(nums2[i])){
                addSet.add(nums2[i]);
            }
        }
        int[] res = new int[addSet.size()];
        int count = 0;
        for(int i : addSet){
            res[count++] = i;
        }
        return res;
    }
}
