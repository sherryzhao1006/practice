public class instanceofTest {
	public static void main(String[] args) {

		Object o = new Parent();
		//wrong
		if(o instanceof Child) {
			System.out.println("true");
		}
		//right
		o = new Child();
		if( o instanceof Parent) {
			System.out.println("true");         
		}		
	}
}
class Parent {
	public Parent() {
	}
}
class Child extends Parent {
	public Child() {
		super();
	}
}

