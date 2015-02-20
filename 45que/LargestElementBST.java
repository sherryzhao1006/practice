import java.util.*;
class Node {
    int id;
    Node left;
    Node right;
    Node(int x) {
        id = x;
    }
   
}
public class LargestElementBST {
	public static void main(String[] args){
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		int[] max = new int[1];
		Node res = nthSmallestElement(root,5,max);
		System.out.println("ans: " + res.id);
	}
        public static Node nthSmallestElement(Node node,int n,int[] index){
                if(node == null)
                        return null;
                Node temp = nthSmallestElement(node.left,n,index);
             	if(temp != null)
			return temp;
		index[0]++;
                if(index[0] == n){
			System.out.println("HERE");
                        return node;
		}
                return nthSmallestElement(node.right,n,index);
        }
	

}
