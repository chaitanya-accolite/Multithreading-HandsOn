package demo2;

public class App {

	/*
	 * Shows how to create thread by implement Runnable class
	 * */
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		t1.start();
		t2.start();
	}

}
