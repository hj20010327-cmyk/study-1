package chap12;

public class Task implements Runnable{

	@Override
	public void run() {

		for(int i=0; i<5; i++) {
			System.out.println("Task "+ i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
}
