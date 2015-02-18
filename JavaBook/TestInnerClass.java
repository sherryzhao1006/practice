import java.util.*;

public class TestInnerClass{
    
    public static void main(String[] args){
		OuterClass oc = new OuterClass();
		oc.createInner();
		OuterClass.print();
    }
}

class OuterClass{
    public OuterClass(){
        System.out.println("outer class created");
    }
    public static void print(){
	System.out.println("HELLO");
    }
    //createInner can't be static method
    void createInner(){
        InnerClass ic = new InnerClass();
    }
    class InnerClass{
        InnerClass(){
            System.out.println("inner class created");
        }
        
    }
        
}
