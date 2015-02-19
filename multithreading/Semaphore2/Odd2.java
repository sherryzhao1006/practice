public class Odd2 extends Thread {
	private Odd e;
	public Odd2(Odd e) {
		this.e = e;
	}
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("result: " + e.next());
		}
	}
	public static void main(String[] args) {
		Odd e = new Odd();
		Odd2 t1 = new Odd2(e);
		Odd2 t2 = new Odd2(e);
		t1.start();
		t2.start();
	}
}
