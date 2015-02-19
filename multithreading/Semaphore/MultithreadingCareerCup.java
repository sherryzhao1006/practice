public class MultithreadingCareerCup   {
	Semaphore mutex1;
	Semaphore mutex2;
	Semaphore mutex3;
	public MultithreadingCareerCup() {

		int noThreadsInCriticalSection = 1;
		mutex1 = new Semaphore(noThreadsInCriticalSection);
		mutex2 = new Semaphore(noThreadsInCriticalSection);
		mutex3 = new Semaphore(noThreadsInCriticalSection);
		mutex1.down();
		mutex2.down();
		mutex3.down();
	}
	public void first() {
		System.out.println("First");
			mutex1.up();
	}
	public void second() {
                        mutex1.down();
			mutex1.up();

			System.out.println("Second");
			mutex2.up();

	}
	public void third() {
                        mutex2.down();
			mutex2.up();

			System.out.println("Third");
			mutex3.up();

	}
	public static void main(String[] args) {
		MultithreadingCareerCup foo = new MultithreadingCareerCup();

		firstThread firstOne = new firstThread(foo,0);
		firstThread firstSecond = new firstThread(foo,1);
		firstThread firstThird = new firstThread(foo,2);
		firstOne.start();
		firstSecond.start();
		firstThird.start();
	}
} 
