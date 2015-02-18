//http://www.programcreek.com/2011/07/java-equals-and-hashcode-contract/
//https://eyalsch.wordpress.com/2009/11/23/comparators/
import java.util.HashMap;
public class hashcodeEquals {
	private String color;
	public hashcodeEquals(String color) {
		this.color = color;
	}
	//need hashCode otherwise you can't retrieve from hashmap
	public int hashCode() {
		return this.color.length();
	}
	public boolean equals(Object obj) {
		if (!(obj instanceof hashcodeEquals))
			return false;
		if (obj == this)
			return true;
		return this.color.equals(((hashcodeEquals) obj).color);
	}
	public static void main(String[] args) {
		hashcodeEquals a1 = new hashcodeEquals("green");
		hashcodeEquals a2 = new hashcodeEquals("red");
		HashMap<hashcodeEquals,Integer> m = new HashMap<hashcodeEquals,Integer>();
		m.put(a1,10);
		m.put(a2,20);
		System.out.println(m.get(new hashcodeEquals("green")));
	}
}

