package 蓝桥杯;

import java.util.Scanner;
import java.util.TreeSet;

public class _2021_模拟_删除字符 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		StringBuilder s = new StringBuilder(str);
		int cnt = 0;
		while(n > 0) {
			n--;
			for(int i = 0;i < str.length()-1;i++) {
				if(s.charAt(i)> s.charAt(i+1)) {
					s.deleteCharAt(i);
					break;
				}
			}
		}
		
		System.out.println(s.toString());
		sc.close();
	}
}
