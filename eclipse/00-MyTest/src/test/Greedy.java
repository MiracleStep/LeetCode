package test;

import java.util.Arrays;

public class Greedy {
	public static void main(String[] args) {
		int[] weights = {3,5,4,10,7,14,2,11};
		Arrays.sort(weights);
		int capacity = 30,weight = 0,count = 0;
		for(int i =0;i<weights.length;i++) {
			int neweight = weight + weights[i];
			if(neweight <=capacity) {
				weight = neweight;
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(weight);
	}
}
