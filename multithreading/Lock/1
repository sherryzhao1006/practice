public class useMyLock {
	public  static void main(String args[]) {
	        Counter1 cntr = new Counter1();
		incThread tInc = new incThread(cntr);
		decThread tDec = new decThread(cntr);
		tInc.start();
		tDec.start();
	}
}
