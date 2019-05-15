package objets;

import personnages.Personnage;
import util.PointDeVie;
import util.Utilitaire;

/**
 * HealingPot is a class instantiating a specific potion, with final values
 * 
 * @author Ted
 *
 */
public class HealingPot extends Potion {

	public HealingPot() {
		super((int) Math.random() * 15 + 15); // Génère une valeur aléatoire à l'instanciation (entre 15 et 29)
	}

	@Override
	public String toString() {
		return "potion de soin";
	}

	/**
	 * Uses the HealingPot
	 */
	@Override
	public void utiliser(Personnage joueur) throws InterruptedException {
		joueur.setHp(joueur.getHp() + this.getpower());
		PointDeVie.overhealCheck(joueur);
		Utilitaire.lettreParLettre(
				"Vous buvez la potion de soin, vous avez maintenant " + joueur.getHp() + " points de vie.");

	}

}
