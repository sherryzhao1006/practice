import java.util.*;
public class MutexThread extends Thread {
	private Semaphore mutex;
	public MutexThread(Semaphore mutex,String name) {
		super(name);
		this.mutex = mutex;
		start();
	}
	public void run() {
		while(true) {
			mutex.down();//acquiring lock
			//a semaphore protects the critical section

			System.out.println("Enter Critical Sectioni : " + getName());
			try {
				sleep((int) (Math.random() * 100));
			} catch(InterruptedException e) {}
		
			System.out.println("Leave Critical Sectioni : " + getName());
			mutex.up();
		}
	}
} 
