package 蓝桥杯;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class _2013_世纪末的星期 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		for(int year = 1999;year <= 1000000;year += 100) {
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, 11);
			calendar.set(Calendar.DAY_OF_MONTH, 31);
			if(calendar.get(Calendar.DAY_OF_WEEK) == 1) {
				System.out.println(year);
				break;
			}
		}
	}
	
}
