package 哈希;

import java.util.HashSet;

public class _202_快乐数 {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true){
            if (n == 1) return true;
            if (hashSet.contains(n)) return false; // 陷入循环，return false；
            hashSet.add(n);
            n = getNextNum(n);
        }
    }

    public int getNextNum(int n){
        int sqSum = 0;
        while (n != 0){
            sqSum += (n%10)*(n%10);
            n /= 10;
        }
        return sqSum;
    }
}
