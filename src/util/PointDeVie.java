package util;

import personnages.Personnage;

/**
 * This class helps to manage the HP's system
 * 
 * @author Ted
 *
 */
public class PointDeVie {

	/**
	 * Makes a character attacking another one
	 * 
	 * @param attaquant is the character who attacks
	 * @param receveur  is the character who recieve the attack
	 * @return the reciever's remaining HP
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public static int attaque(Personnage attaquant, Personnage receveur) throws InterruptedException { // Attaque d'un
																										// personnage
																										// sur un autre
		// retournant les dégats
		int dmg;
		dmg = receveur.getHp();
		receveur.setHp(receveur.getHp() - attaquant.getStrength());
		attaquant.coupCritique(receveur, attaquant.getCritique());
		dmg -= receveur.getHp();
		return dmg;
	}

	/**
	 * Avoid overheal
	 * 
	 * @param personnage is the character you are testing
	 */
	public static void overhealCheck(Personnage personnage) {

		if (personnage.getHp() >= personnage.getMaxHp()) // If his HP is higher than his max HP stats
			personnage.setHp(personnage.getMaxHp()); // HP = max HP
	}

}
