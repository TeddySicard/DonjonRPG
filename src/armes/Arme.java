package armes;

public abstract class Arme {
	private int strength;

	public Arme(int strength) {
		super();
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

	public abstract String toString();

}
