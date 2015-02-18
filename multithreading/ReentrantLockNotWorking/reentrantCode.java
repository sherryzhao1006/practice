public class reentrantCode {
	myLock lock;
	reentrantCode() {
		lock = new myLock();
	}
	public void enter() {

		System.out.println("inside enter method: try to acquire lock " + Thread.currentThread().getName());
		lock.lock();
		System.out.println("inside enter method: acquired lock " + Thread.currentThread().getName());
		reenter();
		lock.unlock();
		System.out.println("inside enter method: unlocked the lock" + Thread.currentThread().getName());
	}
	public void reenter() {

		System.out.println("Insider Reenter method: try to acquire lock " + Thread.currentThread().getName());
		lock.lock();

		System.out.println("Insider Reenter method: acquired lock " + Thread.currentThread().getName());
		lock.unlock();
		
		System.out.println("Insider Reenter method: unlocked the lock " + Thread.currentThread().getName());
	}
} 
