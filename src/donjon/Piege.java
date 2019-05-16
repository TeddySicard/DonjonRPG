package donjon;

import main.Main;
import objets.ObjCoffre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Piege implements ObjCoffre {
	
	private int strength;

	/**
	 * Create a trap and put it in a room
	 * 
	 * @param salle is the room the trap will be in
	 */
	public Piege(Salle salle) {
		salle.setPiege(this);
		this.strength = (int) (Math.random() * 10 + 15); // Randomly generated value (from 15 to 24)
	}
	
	/**
	 * Create a trap
	 */
	public Piege() {
		this.strength = (int) (Math.random() * 10 + 15); // Randomly generated value (from 15 to 24)
	}

	public int getStrength() {
		return strength;
	}

	/**
	 * Triggers the trap
	 * 
	 * @param joueur is the player you are triggering the trap on
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void triggerTrap(PersonnagePrincipal joueur) throws InterruptedException { // Active le piège
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg -= joueur.getHp();
		System.out.println("Le piège vous a infligé " + dmg + " points de dégats");
		if (joueur.isKO()) { // If the player dies
			Main.gameOver();
		}
	}

	/**
	 * Find the trap in a chest
	 */
	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Le coffre contenait un mécanisme piégé.");
		((Piege) coffre.getContenu()).triggerTrap(joueur);
		coffre.setContenu(null); // Delete the trap from a chest
	}

}
