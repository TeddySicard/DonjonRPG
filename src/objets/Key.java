package objets;

public class Key {
	private int cat;

	public Key(int cat) {
		super();
		this.cat = cat;
	}

	public int getCat() {
		return cat;
	}

	public String toString() {
		if (this.getCat() == 1)
			return "cl� de coffre";
		else
			return "cl� de porte";

	}

}
