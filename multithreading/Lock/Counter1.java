public class Counter1 {
	private myLock lock = new myLock();
	private int count;
	Counter1() {
		count = 0;
	}
	public int increment() {
		System.out.println("Acquiring Lock : increment Thread");
		lock.lock();
		System.out.println("Got the Lock: increment Thread");
		int newCount = ++count;
		System.out.println("incrementing : increment Thread");
		lock.unlock();
		System.out.println("Unlocked Lock: increment Thread");
		return newCount;
	}
	public int decrement() {
		System.out.println("Acquiring Lock : decrement Thread");
		lock.lock();
		System.out.println("Got the Lock: decrement Thread");
		int newCount = --count;
		System.out.println("incrementing : decrement Thread");
		lock.unlock();
		System.out.println("Unlocked Lock: decrement Thread");
		return newCount;
	}
}
