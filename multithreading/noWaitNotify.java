public class noWaitNotify {
    public static void main(String[] args) {
	adderThread adder = new adderThread();
	adder.start();
	System.out.println("Total is : " + adder.total);
    }
}
