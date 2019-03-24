package objets;

import personnages.Personnage;

public abstract class Potion {
	private int power;

	public Potion(int power) {
		super();
		this.power = power;
	}

	public int getpower() {
		return power;
	}

	@Override
	public abstract String toString();

	public abstract void utiliser(Personnage joueur) throws InterruptedException;
}
