//here in this program there are two threads one is the main thread and the thread which runs on the newthread object
class NewThread1 implements Runnable{
	Thread t1;
	
	NewThread1(){
		t1 = new Thread(this,"CT");
		//here in the above statement this keyword is used to represent that the run method should run on this object when the
		// start method is called on this thread 't1'
	}
	
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				System.out.println("CT :" + i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e) {
			System.out.println("CT Interrupted:" + e);
		}
		System.out.println("exiting CT Thread");
	}
	
}

class ImplementingRunnable{
	public static void main(String args[]) {
		NewThread1 nt = new NewThread1();
		//Thread t = Thread.currentThread();
		//uncomment the above line if you want to obtain a reference to the main thread
		//System.out.println("Current Thread:" + t);
		
		//t.setName("My Thread");
		//uncomment the above line if you want to change the name of the main thread
		//System.out.println("After Name Change :" + t);
		
		nt.t1.start();
		
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


