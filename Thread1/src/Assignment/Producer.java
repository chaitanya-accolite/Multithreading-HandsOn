package com.wan;

import java.util.List;

public class Producer implements Runnable{
	private List<Integer> waitList;
	int i=0;
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Producer Started");
		while(true){
			synchronized(waitList){
				while(waitList.size() == 1){
					System.out.println("Queue is Full.");
				try {
					waitList.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
			synchronized(waitList){
				i++;
				System.out.println("Produced " + i);
				waitList.add(i);
				waitList.notify();
			}
		}
	}
	public Producer(List<Integer> waitList) {
		super();
		this.waitList = waitList;
	}
	
}
