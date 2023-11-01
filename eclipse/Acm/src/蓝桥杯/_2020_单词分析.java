package 蓝桥杯;

import java.util.Scanner;

public class _2020_单词分析 {
	static int[] a = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		char[] s = str.toCharArray();
		for(int i = 0;i < s.length;i++) {
			a[s[i] - 'a']++;
		}
		
		char maxs = 'a';
		int max = a[0];
		for(int i = 1;i < 26;i++) {
			if(max < a[i]) {
				maxs = (char)('a'+i);
				max = a[i];
			}
		}
		System.out.println(maxs);
		System.out.println(max);
		sc.close();
	}
}
