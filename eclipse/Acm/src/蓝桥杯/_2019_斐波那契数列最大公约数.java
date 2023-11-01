package 蓝桥杯;

import java.math.BigInteger;

public class _2019_斐波那契数列最大公约数 {
	public static void main(String[] args) {
		BigInteger[] dp = new BigInteger[2021];
		dp[1] = dp[2] = BigInteger.ONE;
		for(int i = 3;i <= 2020;i++) {
			dp[i] = dp[i-1].add(dp[i-2]);
		}
		BigInteger gcd = gcd(dp[2020], dp[520]);
		System.out.println(gcd.toString());
	}
	
	static BigInteger gcd(BigInteger a, BigInteger b) {
		return b.compareTo(BigInteger.ZERO) == 0?a : gcd(b, a.mod(b));
	}
	
}
