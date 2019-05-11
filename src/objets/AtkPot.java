package objets;

import personnages.Personnage;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class AtkPot extends Potion {

	public AtkPot() {
		super((int) Math.random() * 5 + 5); // Randomly generated value (from 5 to 9)
	}

	@Override
	public String toString() {
		return "potion d'attaque";
	}

	/**
	 * Uses the ATKpot
	 */
	@Override
	public void utiliser(Personnage joueur) throws InterruptedException {
		joueur.setStrength(joueur.getStrength() + this.getpower());
		Utilitaire.lettreParLettre(
				"Vous buvez la potion, vous avez maintenant " + joueur.getStrength() + " points d'attaque.");
	}

}
