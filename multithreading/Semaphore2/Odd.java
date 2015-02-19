public class Odd {
	private int n = 1;
	public int next() {
		++n;
		try { Thread.sleep(10);
		} catch(InterruptedException e) { }
		++n;
		return n;
	}
}
