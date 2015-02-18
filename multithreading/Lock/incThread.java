public class incThread extends Thread {
	final private Counter1 cntr;
	public incThread(Counter1 c) {
		this.cntr = c;
		this.setName("increment thread");
	}
	public void run() {
		cntr.increment();
	}
}
