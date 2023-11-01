package 蓝桥杯;

import java.util.HashSet;
import java.util.Set;

public class _2019_不同字串 {
	public static void main(String[] args) {
		String s = "0100110001010001";
		int len = s.length();
		Set<String> hset = new HashSet<>();
		for(int l = 0;l < len;l++) {
			for(int r = l;r < len;r++) {
				hset.add(s.substring(l, r+1));
			}
		}
		System.out.println(hset.size());
	}
}
