/*
import java.io.*;
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Main {
    public static void main (String[] args) {
	ListNode root = new ListNode(1);
	root.next = new ListNode(2);
	root.next.next = new ListNode(3);
	int k=2;
	int i =1;
	if(root != null){
		ListNode p = root;
		while(p.next != null && i < k){
			p = p.next;
			i++;
		}	
		ListNode temp = root;
		while(p.next != null){
			temp = temp.next;
			p = p.next;
		}
	}
    }
}
*/

//https://www.codeeval.com/open_challenges/10/
//array version

import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] strArray = line.split(" ");
            int lastN = Integer.parseInt(strArray[strArray.length-1]);
            char[] intArray = new char[strArray.length-1];
            if(lastN > intArray.length)
                continue;
            for(int i=0; i < strArray.length-1; i++){
                intArray[i] = (strArray[i]).charAt(0);
            }
            int k =1;
            while(k < intArray.length && k < lastN) {
                k++;
            }
            int st =1;
            while(k < (intArray.length)){
                st++;
                k++;
            }
            System.out.println(intArray[st-1]);
            // Process line of input Here
        }
    }
}

