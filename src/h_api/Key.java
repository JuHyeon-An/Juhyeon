package h_api;

public class Key {

	public int number;

	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		return this.number;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Key) {
			Key k = (Key) obj;
			if (k.number == this.number) {
				b = true;
			}
		}
		return b;

	}

}
