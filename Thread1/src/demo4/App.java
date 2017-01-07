package demo4;

import java.util.Scanner;

public class App {

	/*
	 * Shows how a shared data can cause a problem.
	 * How to stop another thread
	 * */
	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press Return to shut down..");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		proc1.shutdown();
	}

}
