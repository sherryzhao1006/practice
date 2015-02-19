public class Odd3 extends Thread {
	private OddMutex e;
	public Odd3(OddMutex e) {
		this.e = e;
	}
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("result: " + e.next());
		}
	}
	public static void main(String[] args) {
		OddMutex e1 = new OddMutex(5);
		Odd3 t11 = new Odd3(e1);
		Odd3 t22 = new Odd3(e1);
		t11.start();
		t22.start();
	}
}
