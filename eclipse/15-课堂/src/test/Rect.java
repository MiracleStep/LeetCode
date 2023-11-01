package test;

import java.util.Random;

public class Rect {
	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			System.out.println("!!!!!!!!!!!!!!");
		});
		thread.start();
	}
	
}
