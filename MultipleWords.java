import java.util.*;
class LengthComparator implements Comparator<String> {
	public int compare(String o1, String o2){
		//return (o1.length() - o2.length());//ascending(low to high)
		return (o2.length() - o1.length()); //descending(high to low)
	}
}
public class MultipleWords {
	public static void main(String[] args) {
		String arr[] = {"tester","testertest","test"};
		Arrays.sort(arr,new LengthComparator());
		printLongestWord(arr);
	}
	public static String printLongestWord(String arr[]) {
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		for(String s : arr) {
			map.put(s,true);
		}
		for(String s : arr) {
			if(canBuildWords(s,true,0,map)) {
				System.out.println(s);
				return s;
			}	
		}
		return null;
	}
	public static boolean canBuildWords(String str,boolean isOrigin,int index,HashMap<String,Boolean> map) {
		if(isOrigin == false && str.equals("")) {
			return true;
		}
		for(int i = index+1; i <= str.length() ; i++) {
			String str1 = str.substring(index,i);
			String str2 = str.substring(i);
			if(map.containsKey(str1)) {
				if(canBuildWords(str2,false,i,map)){
					return true;
				}
			}
		} 
		return false;
	} 
}
