class A{
	
}

class PrintingTask extends A implements Runnable /*Thread{ */
{
	
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("[SecondThread] printing book pages for python.py pages # "+i);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
	
}

public class MultiThreading{

	public static void main(String[] args) {
		System.out.println("Main Thread Started");
		
//		PrintingTask pt = new PrintingTask();
//		pt.start();
		
		Runnable ref = new PrintingTask();
		Thread th = new Thread(ref);
		th.start();
		for(int i=1;i<=10;i++) {
			System.out.println("[MainThread] printing book pages for java.java pages--------- # "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("th name is :"+th.getName()+" th priority is "+th.getPriority());
		System.out.println("main thread name is :"+Thread.currentThread().getName()+" main thread priority is "+Thread.currentThread().getPriority());
		System.out.println("Main Thread Finished");

	}

}
