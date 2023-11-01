package test;

import java.util.Comparator;

public class Cat extends Animal implements Comparator{

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("王俊智大帅逼");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
