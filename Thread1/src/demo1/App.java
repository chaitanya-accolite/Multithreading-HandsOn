package demo1;

public class App {
	
	/*
	 * Shows how to create thread by extending Thread class
	 * */
	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		Runner runner2 = new Runner();
		runner2.start();
	}

}
