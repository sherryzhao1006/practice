import java.util.*;
class Data implements Comparable<Data> {
	public char letter;
	public int freq;
	public Data(char letter,int freq) {
		this.letter = letter;
		this.freq = freq;
	}
	@Override
	public boolean equals(Object obj) {
		Data d = (Data) obj;
		if( (this.letter - d.letter) == 0) 
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		return (7*letter);
	}
	//Default sorting is done using the letter
	@Override
	public int compareTo(Data data) {
		return letter- data.letter;
	}
}
class FreqComparator implements Comparator<Data> {
	//This will sort by freq
	@Override
	public int compare(Data d1,Data d2) {
		if(d1.letter != d2.letter) {
			int freqDiff = d1.freq-d2.freq;
			if(freqDiff != 0)
				return freqDiff;
			else {
				//they both have the same freq
				//then sort by letter order
				return d1.letter -d2.letter;
			}
		}
		return 0;
	}
}
public class WordFreq {
	public static void main(String[] args) {
		HashSet<Data> hashset = new HashSet<Data>();
		Data d1 = new Data('A',10);
		Data d2 = new Data('B',5);
		Data d3 = new Data('C',34);
		Data d4 = new Data('D',333);
		hashset.add(d1);
		hashset.add(d2);
		for(Data data : hashset) {
		System.out.println("Alpha : " + data.letter + ", Freq : " + data.freq);
		}
		Set<Data> treeSet = new TreeSet<Data>(new FreqComparator());
		treeSet.add(d1);
		treeSet.add(d2);
		treeSet.add(d3);
		treeSet.add(d4);
		System.out.println("Freq : " );
		for (Data data : treeSet) {
			System.out.println("Alpha : " + data.letter + ", Freq : " + data.freq);
		}
	}
}
