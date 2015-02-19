//http://tutorials.jenkov.com/java-concurrency/thread-signaling.html
//http://java-success.blogspot.in/2012/04/java-multi-threading-interview.html


//notify method wakes up only one thread waiting on the object and that thread starts execution. So if there are multiple threads waiting for an object, this method will wake up only one of them. The choice of the thread to wake depends on the OS implementation of thread management.
//source
//http://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example

//1)synchronized keyword is used for exclusive accessing.
//2)No two invocations of synchronized methods on the same object can interleave 
//with each other
//3)synchronized statements must specify the object that provides the intrinsic lock
// this is for block synchronized (not for method synchronized). for block synchronized you need to say
// synchronized(obj).method synchornized uses class obj.
// wait() tells the calling thread to give up the monitor(lock) and go to sleep
//
import java.util.*;
public class waitNotify {
	public static void main(String[] args) {
		adderThread adder = new adderThread();

		adder.start();
/*
try {
		Thread.sleep(8000);
} catch (InterruptedException e) {
                                e.printStackTrace();
                        }
*/
		synchronized(adder) {
			try {


				System.out.println("Waiting for adder");
				adder.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Total is: " + adder.total);
		}		
	}
}
