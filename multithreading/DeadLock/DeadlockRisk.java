public class DeadlockRisk {
	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();
	public int read() {
		synchronized(resourceA) {
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException ex) {}

		System.out.println("Inside read and got resourceA");
				synchronized(resourceB) {
					return resourceB.value + resourceA.value;
				}	


		}
	}
	public void write(int a,int b) {
		synchronized(resourceB) {

		System.out.println("Inside write and got resourceB");
			synchronized(resourceA) {
				resourceA.value = a;
				resourceB.value = b;
			}
		}
	}
}
