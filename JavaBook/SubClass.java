public class SubClass extends SuperClass{
	public void showSample(){
		System.out.println("Another thing.");
	}
	public static void main(String args[]){
		SubClass sc = new SubClass();
		sc.showSample();
	}
}
