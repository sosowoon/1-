package project;

import java.util.ArrayList;

public class ThreadEX implements Runnable {

	int TestNum = 0;

	@Override
	public void run() {
		ArrayList<MyExerDTO> list = new ArrayList<MyExerDTO>();
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("=======================");
				TestNum++;
			}
			System.out.println("ThreadName =" + Thread.currentThread().getName() + "TestNum =" + TestNum);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}