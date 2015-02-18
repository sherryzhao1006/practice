import java.util.*;
public class NameList {
	private List names = Collections.synchronizedList(new LinkedList());
	public void add(String name) {
		names.add(name);
	}
	public String removeFirst() {
		if (names.size() > 0)
			return (String) names.remove(0);
		else
			return null;
	}
	public static void main(String[] args) {
		final NameList nl = new NameList();
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

//Error 
//OzymandiasException in thread "Thread-1" 
//java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
//	at java.util.LinkedList.checkElementIndex(LinkedList.java:555)
//	at java.util.LinkedList.remove(LinkedList.java:525)
//	at java.util.Collections$SynchronizedList.remove(Collections.java:2486)
//	at NameList.removeFirst(NameList.java:9)
//	at NameList$1NameDropper.run(NameList.java:18)

