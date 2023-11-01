package 蓝桥杯;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 标题统计 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		char[] s = str.toCharArray();
		for(int i = 0;i < s.length;i++) {
			if(s[i]<='Z'&&s[i]>='A') {
				cnt++;
			}else if(s[i]<='9'&&s[i]>='0') {
				cnt++;
			}else if(s[i]<='z'&&s[i]>='a') {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
