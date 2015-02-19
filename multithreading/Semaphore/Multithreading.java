public class Multithreading {
	public static void main(String[] args) {
		int noThreadsInCriticalSection = 3;
		Semaphore mutex = new Semaphore(noThreadsInCriticalSection);
		for(int i = 1; i <= 10 ; i++) {
			new MutexThread(mutex, "Thread " + i);
		}
	}
} 
