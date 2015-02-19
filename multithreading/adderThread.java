public class adderThread extends Thread {
	int total;
	@Override
	public void run() {
		synchronized(this) {
			for(int i=0; i < 1000000; i++) {
				total += i;
			}
			notify();
		}
	}
}
