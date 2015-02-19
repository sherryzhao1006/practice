public class OddMutex {
	private int n = 1;
	Semaphore mutex;
	OddMutex (int initial) {
		mutex = new Semaphore(1);
		n = initial;
	}	
	public int next() {
		mutex.down();
		++n;
		try { Thread.sleep(1000);
		} catch (InterruptedException e) {}
		++n;
		mutex.up();
		return n;
	}
}
