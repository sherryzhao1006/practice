public class firstThread extends Thread {
	int total;
        private  MultithreadingCareerCup foo;
	int i;
	public firstThread(MultithreadingCareerCup foo,int i) {
		this.i = i;
		this.foo = foo;	
	}
	@Override
	public void run() {

		if(this.i==0) {
			foo.first();
		} else if(this.i == 1) {
			foo.second();
		} else {
			foo.third();
		}
	}
}
