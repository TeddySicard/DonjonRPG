package objets;

import personnages.Personnage;
import util.Utilitaire;

public class AtkPot extends Potion {

	@Override
	public String toString() {
		return "potion d'attaque";
	}

	public AtkPot() {
		super((int) Math.random() * 5 + 5); // Génère une valeur aléatoire à l'instanciation (entre 5 et 9)
	}

	@Override
	public void utiliser(Personnage joueur) throws InterruptedException {
		joueur.setStrength(joueur.getStrength() + this.getpower());
		Utilitaire.lettreParLettre("Vous buvez la potion, vous avez maintenant " + joueur.getStrength() + " points d'attaque.");
	}

}
