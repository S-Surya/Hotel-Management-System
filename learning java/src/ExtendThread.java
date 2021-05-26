class NewThread extends Thread{
	NewThread(){
		super("Demo Thread");
		//since you have to create a reference of the thread class and construct a thread by passing 
		// the thread name as a string . we have done the same thing as the thing we have done in the 
		// implementing runnable . here we used the super constructor since we are extending newthread from
		// thread itself.
		System.out.println("Child Thread:" + this);
	}


public void run() {
	try {
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread:" + i);
			Thread.sleep(500);
			
		}
	}
	catch(InterruptedException e) {
		System.out.println("Child thread interrupted:"+e);
	}
	System.out.println("Exiting child thread");
}
}




public class ExtendThread {
	public static void main(String args[]) {
		NewThread nt = new NewThread();
		//the second difference between runnable and extending thread method is that calling the start
		// and thats obvious
		nt.start();
		
		
		try {
			for(int n=5;n>0;n--) {
				System.out.println("Main Thread:" + n);
				Thread.sleep(1000);
				
			}
		}
		catch(InterruptedException e) {
			System.out.println("Main Thread Interrupted");
		}
	}

}
