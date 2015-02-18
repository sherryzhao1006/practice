public class Solution {
	//#10
	public static Node reverseList(Node head){
		if(head == null)
			return head;
		Node prev = null;
		Node curr = head;
		Node next = curr;
		while(curr!=null){
			next = next.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;	
	}
	//#11
	public boolean containsTree(Node t1,Node t2){
		if(t2 == null)
			return true;
		return subTree(t1,t2);
	}
	public boolean subTree(Node t1,Node t2){
		if(t1 == null)
			return false;
		if(t1.val == t2.val){
			if(matchTree(t1,t2))
				return true;
		}
		return subTree(t1.left,t2) || subTree(t1.right,t2);
	}
	public boolean matchTree(Node t1, Node t2){
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		return t1.val == t2.val && matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
	}
	//#12 (String to Int)
	//http://javahungry.blogspot.com/2014/02/how-to-convert-string-to-int-in-java-without-using-integer-parseint-method-code-with-example.html
	public static int stringToInt(String str) {
		boolean isNeg = false;
		int st = 0;
		if(str[0] == '-'){
			isNeg = true;
			st = 1;
		}
		int len = str.length();
		int total = 0;
		while( st < len) {
			int currNum = str.charAt(st)-'0';
			total = total*10 + currNum;
			//don't forget to increment st
			st++;
		}
		if(isNeg)
			total = -total;
		return total;
	}
	//#12 (Int to String)
	//largest int : 2147483648 (10 digits)
	public static final int MAX_DIGITS_FOR_INT = 10;
	public static String (int num) {
		boolean isNeg = false;
		if(num < 0) {
			isNeg = true;
			num *= -1;
		}
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			char c = (char)((num%10) + '0');
			sb.insert(0,c);
			num /= 10;
		}
		return sb.toString();
	}
}
