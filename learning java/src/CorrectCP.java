class Q{
	int n;
	boolean valueSet = false;
	//if any value is produced by the producer and still not consumed by the consumer then valueSet is set
	// to true.
	
	synchronized int get(){
		while(!valueSet) {
			try {
				wait();
				// since when valueset is false ....which means there are no products for sale at present 
				//  so the consumer has to wait
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted exception caught");
			}
		}
		
		System.out.println("Got :"+ n);
		valueSet = false;
		notify();
		//since this part runs when valueSet is true and when valueSet is true producer waits so we 
		// notify the producer to wake up by notify()
		return n;
	}
	
	synchronized void put(int n) {
		while(valueSet) {
			try {
				wait();
				// since when valueset is true ....which means there are products for sale at present 
				//  so the producer has to wait until the produced products are consumed
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted exception caught");
			}
		}
		this.n= n;
		System.out.println("Put :" + n);
		valueSet = true;
		notify();
	}
}

class Producer implements Runnable{
	Q q;
	Thread t;
	
	Producer(Q q){
		this.q = q;
		t = new Thread(this,"Producer");
	}
	
	public void run() {
		int i=0;
		
		while(true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable{
	Q q;
	Thread t;
	
	Consumer(Q q){
		this.q = q;
		t = new Thread(this,"Consumer");
	}
	
	public void run() {
		while(true) {
			q.get();
		}
	}
}

public class CorrectCP {
	public static void main(String args[]) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		//start the threads
		p.t.start();
		c.t.start();
		
		System.out.println("press ctrl+c to stop");
	}
}
