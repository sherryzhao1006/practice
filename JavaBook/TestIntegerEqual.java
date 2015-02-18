class TestIntegerEqual
{
    public static void main(String[] args){
	Integer a = new Integer(2);
	Integer b = new Integer(2);

        System.out.println("a == b is " + (a == b));//compare by reference
        System.out.println("a.equals(b) is " +a.equals(b));//compare by val
       
    }
   
}
