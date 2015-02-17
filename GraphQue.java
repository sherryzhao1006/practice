//http://www.careercup.com/question?id=6558888935555072
import java.util.*;
class Node {
    int id;
    List<Node> neighbors;
    Node(int x) {
        id = x;
        neighbors = new ArrayList<Node>();
    }
}
public class GraphQue {

        public static Map<Integer,Node> g = new HashMap<Integer,Node>();
	public static Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);

	int tc = Integer.parseInt(in.next());
	for(int i = 0; i < tc; i++) {
		int f = Integer.parseInt(in.next());
		int s = Integer.parseInt(in.next());
		Node firstNode = null;
		Node secondNode = null;
		if(!g.containsKey(f)){
			firstNode = new Node(f);
			g.put(f,firstNode);
		} else {
			firstNode = g.get(f);
		}
		if(!g.containsKey(s)){
			secondNode = new Node(s);
			g.put(s,secondNode);
		} else {
			secondNode = g.get(s);
		}
		//connect 1 and 2
		firstNode.neighbors.add(secondNode);
	}
	//BFS();
	DFS();
    }
    public static void DFS() {
	List<Set<Integer>> res = new ArrayList<Set<Integer>>();

	for(Integer value : g.keySet()) {
		if(!visited.containsKey(value)){
			Set<Integer> localRes = new HashSet<Integer>(); 
			DFSUtil(g.get(value),localRes);
			res.add(localRes);
		}
	}
	for(Set<Integer> myset : res) {
		for(Integer value : myset) {
			System.out.print(value + " " );
		}	
		System.out.println();
	}	
    }
    public static void DFSUtil(Node root,Set<Integer> localRes) {
	System.out.println(root.id);
	localRes.add(root.id);
	visited.put(root.id,true);
	for(int i = 0; i < root.neighbors.size();i++) {
		if(!visited.containsKey(root.neighbors.get(i).id)){
			DFSUtil(root.neighbors.get(i),localRes);	
		}
	}

    }
    public static void BFS() {
	Set<Map.Entry<Integer,Node>> set = g.entrySet();
	Iterator i = set.iterator();
	while(i.hasNext()) {
		Map.Entry<Integer,Node> me = (Map.Entry<Integer,Node>)i.next();
		if(!visited.containsKey(me.getValue().id)) {
			visited.put(me.getValue().id,true);
			BFSUtil(me.getValue());
		}
        }
    }
    public static void BFSUtil(Node root) {
	
	Queue<Node> q = new LinkedList<Node>();
	q.add(g.get(root.id));
	while(!q.isEmpty()) {
		Node cur = q.poll();
		System.out.print("," + cur.id);
		for(int i=0; i < cur.neighbors.size();i++) {
			if(!visited.containsKey(cur.neighbors.get(i).id)) {
				visited.put(cur.neighbors.get(i).id,true);
				q.add(cur.neighbors.get(i));
			}
		}
	}
    }
}
