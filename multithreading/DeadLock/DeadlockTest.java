public class DeadlockTest {

    public static void main(String[] args) {
	final DeadlockRisk dr = new DeadlockRisk();
	class ReadThread extends Thread {
		public void run() {
			dr.read();
		}
	}
	class WriteThread extends Thread {
		public void run() {
			dr.write(1,2);
		}
	}
	Thread t1 = new ReadThread();
	Thread t2 = new WriteThread();
	t1.start();
	t2.start();
    }

}
