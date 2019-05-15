package objets;

import personnages.Personnage;
import util.Utilitaire;

/**
 * HPGainPot is a class instantiating a specific potion, with final values
 * 
 * @author Ted
 *
 */
public class HPGainPot extends Potion {

	public HPGainPot() {
		super((int) (Math.random() * 15 + 15)); // Génère une valeur aléatoire à l'instanciation (entre 15 et 29)
	}

	@Override
	public String toString() {
		return "potion de gain de PV max";
	}

	/**
	 * Uses the HPGainPot
	 */
	@Override
	public void utiliser(Personnage joueur) throws InterruptedException {
		joueur.setMaxHp(joueur.getMaxHp() + this.getpower());
		joueur.setHp(joueur.getHp() + this.getpower());
		Utilitaire.lettreParLettre("Vous buvez la potion, vos PV max ont augmenté. Vous avez maintenant "
				+ joueur.getHp() + " points de vie et " + joueur.getMaxHp() + " PV maximum.");

	}

}
