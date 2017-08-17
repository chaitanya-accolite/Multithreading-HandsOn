package com.wan;

import java.util.List;

public class Consumer implements Runnable{
	private List<Integer> waitList;
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized(waitList){
				while(waitList.size() == 0){
					System.out.println("List is Empty");
					try {
						waitList.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			synchronized(waitList){
				System.out.println("Consumed : "+ waitList.remove(0));
				waitList.notify();
			}
		}
	}
	public Consumer(List<Integer> waitList) {
		super();
		this.waitList = waitList;
	}
	
}
