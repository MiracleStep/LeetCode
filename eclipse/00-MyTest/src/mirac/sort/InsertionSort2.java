package mirac.sort;

import java.util.Arrays;

public class InsertionSort2 extends Sort {

	@Override
	protected void sort() {

		for(int begin = 1;begin < array.length;begin++) {
			
			int cur = begin;
			int tmp = array[begin];
			while(cur > 0&&tmp < array[cur-1]) {
				array[cur] = array[cur-1];
				cur--;
			}
			array[cur] = tmp;
		}
	}

	
}
