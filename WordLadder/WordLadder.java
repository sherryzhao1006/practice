import java.util.*;
public class WordLadder {
	public static void main(String[] args) {
		String[] words = {"maps", "tan", "tree", "apple", "cans", "help", "aped", "free", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril"};
		HashSet<String> dict = setupDictionary(words);
		LinkedList<String> list = transform("tree", "flat",dict);
		System.out.println(list.toString());			
	}
	public static LinkedList<String> transform(String startWord, String stopWord,Set<String> dictionary){
		startWord = startWord.toUpperCase();
		stopWord = stopWord.toUpperCase();
		Queue<String> q = new LinkedList<String>();
		Map<String,String> bm = new TreeMap<String,String>();
		Set<String> visitedSet = new HashSet<String>();
	
		q.add(startWord);
		visitedSet.add(startWord);
		while(!q.isEmpty()) {
			String currWord = q.poll();
			for( String s : getOneEditWords(currWord)) {
				if (s.equals(stopWord)) {
					LinkedList<String> res = new LinkedList<String>();
					res.add(s);
					while(currWord != null) {
						res.add(0,currWord);
						currWord = bm.get(currWord);
					}
					return res;
				} 
				if (dictionary.contains(s)) {
					if(!visitedSet.contains(s)) {
						q.add(s);
						visitedSet.add(s);
						bm.put(s,currWord);
					}
				}
			}
		}
		return null;
	}
	public static HashSet<String> setupDictionary(String[] words) {
		HashSet<String> hash = new HashSet<String>();
		for (String word : words) {
			hash.add(word.toUpperCase());
		}
		return hash;
	}
	public static Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		for (int i=0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for (char c = 'A'; c <= 'Z' ; c++) {
				if (c != word.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}
}
