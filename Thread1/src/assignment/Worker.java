package com.training.assignment;

import java.util.ArrayList;
import java.util.Random;

public class Worker {
	ArrayList<Integer> buffer = new ArrayList<Integer>(5);
	
	public synchronized void changeBuffer() {
		while(true) {
			while(buffer.size()==5){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Random rgen = new Random();
			int random = 5 + (rgen.nextInt() % 100);
			buffer.add(random < -1 ? -1*random : random);
			System.out.println("Adding... " + buffer.toString());
			notify();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void readBuffer() {
		while(true) {
			while(buffer.size()==0){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Removed " + buffer.get(0) + " from buffer");
			buffer.remove(0);
			notify();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doWork() {
		Thread producer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				changeBuffer();
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				readBuffer();
			}
		});
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
