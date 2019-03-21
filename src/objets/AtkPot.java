package objets;

import personnages.Personnage;

public class AtkPot extends Potion {

	@Override
	public String toString() {
		return "potion d'attaque";
	}

	public AtkPot() {
		super((int) Math.random() * 5 + 5);
	}

	@Override
	public void utiliser(Personnage joueur) {
		joueur.setStrength(joueur.getStrength() + this.getpower());
		System.out.println("Vous buvez la potion, vous avez maintenant " + joueur.getStrength() + " points d'attaque.");
	}

}
