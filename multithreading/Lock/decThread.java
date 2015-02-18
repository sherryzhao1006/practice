public class decThread extends Thread {
	final private Counter1 cntr;
	public decThread(Counter1 c) {
		this.cntr = c;
		this.setName("decrement thread");
	}
	public void run() {
		cntr.decrement();
	}
}
