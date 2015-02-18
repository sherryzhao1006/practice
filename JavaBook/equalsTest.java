public class equalsTest {
	public static void main(String[] args) {
		
	}
}
class Moof {
	private int moofValue;
	Moof(int val) {
		moofValue = val;
	}
	public int getMoofValue() {
		return moofValue;
	}
	public boolean equals (Object o) {
		if ((o instanceof Moof) && (((Moof) o).getMoofValue() == this.moofValue))
			return true;
		else
			return false;
	}
}
