package 哈希;

public class _383_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length(), n = magazine.length();
        int[] mCount = new int[26];
        for (int i = 0; i < n; i++) {
            int idx = magazine.charAt(i) - 'a';
            mCount[idx]++;
        }

        for (int i = 0; i < m; i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (--mCount[idx] < 0) return false;
        }
        return true;
    }
}
