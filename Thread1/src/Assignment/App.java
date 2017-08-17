package com.wan;

import java.util.LinkedList;
import java.util.List;

public class App {
	public static void main(String[] args){
		List<Integer> waitList = new LinkedList<Integer>();
		Producer prod = new Producer(waitList);
		Consumer cons = new Consumer(waitList);
		
		Thread pt = new Thread(prod);
		Thread ct = new Thread(cons);
		pt.start();
		ct.start();
	}
}
