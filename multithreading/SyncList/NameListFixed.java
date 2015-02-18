import java.util.*;
public class NameListFixed {
	private List names = Collections.synchronizedList(new LinkedList());
	public synchronized void add(String name) {
		names.add(name);
	}
	public synchronized String removeFirst() {
		if (names.size() > 0)
			return (String) names.remove(0);
		else
			return null;
	}
	public static void main(String[] args) {
		final NameListFixed nl = new NameListFixed();
		nl.add("Ozymandias");
		class NameDropper extends Thread {
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}
}
