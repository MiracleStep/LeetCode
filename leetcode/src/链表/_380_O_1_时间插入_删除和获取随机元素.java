package 链表;

import java.util.HashMap;
import java.util.Random;

public class _380_O_1_时间插入_删除和获取随机元素 {
    HashMap<Integer, Integer> map;//key:值 value:key所对应的数组nums的下标。
    int[] nums;//值保存插入的元素；
    int idx;//记录nums使用到哪里了
    Random random;
    /** Initialize your data structure here. */
    public _380_O_1_时间插入_删除和获取随机元素() {
        map = new HashMap<>();
        nums = new int[200010];
        idx = -1;
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        if (loc != idx) {
            nums[loc] = nums[idx--];//确保idx前面的元素都是存活的（把最后面的放前面去）
            map.put(nums[loc], loc);//更新这个索引
        } else {
            idx--;
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}
