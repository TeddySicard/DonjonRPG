package personnages;

import java.util.ArrayList;
import java.util.List;

import util.PointDeVie;
import util.Utilitaire;
import armes.Arme;
import donjon.Chest;
import donjon.Porte;
import objets.Key;
import objets.Potion;

/**
 * This class creates the player with final values
 * 
 * @author Ted
 *
 */
public class PersonnagePrincipal extends Personnage {
	private Arme weaponHeld;
	private Support mateFollow;
	public List<Key> bunchOfKeys;
	public final static int HP = 150;
	public final static int ATK = 4;
	public final static int CRIT = 1;

	public PersonnagePrincipal() {
		super(HP, ATK, CRIT);
		this.weaponHeld = null;
		this.setMateFollow(null);
		bunchOfKeys = new ArrayList<>();

	}

////////////////////////////////Getters && Setters//////////////////////////////////////
	public Support getMateFollow() {
		return mateFollow;
	}

	public void setMateFollow(Support mateFollow) {
		this.mateFollow = mateFollow;

	}
	
	/**
	 * Player's attack
	 * 
	 * @param ennemi is the character's opponent
	 */
	public void useSkill(Personnage ennemi) throws InterruptedException { 
		Utilitaire.lettreParLettre("Vous avez infligé " + PointDeVie.attaque(this, ennemi) + " points de dégats.");

	}

	/**
	 * 	 * Equip a weapon
	 * 
	 * @param arme is the weapon to equip
	 * @return The string resulting of the action done by the player (getting the weapon or not)
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public String equipWeapon(Arme arme) throws InterruptedException { 
		if (this.hasWeapon()) { // If the player already has a weapon on him
			if (this.getStrength() >= arme.getStrength()) // If the player's weapon is stronger than the weapon found
				return "Votre arme actuelle inflige plus de dégats. Vous ne changez donc pas d'arme";
			else { // If his actual weapon is weaker
				Arme weapon;
				this.setStrength(arme.getStrength());
				weapon = this.weaponHeld;
				this.weaponHeld = arme;
				return "Vous avez jeté " + weapon + " au profit d'" + arme + ".";
			}
		} // If he has no weapon
		this.setStrength(arme.getStrength());
		this.weaponHeld = arme;
		return "Vous n'aviez pas d'arme, vous récupérez donc " + arme;
		
	}

	/**
	 * Checks if the player has a weapon 
	 * @return true if he holds a weapon false if he doesn't
	 */
	public boolean hasWeapon() { 
		if (weaponHeld == null)
			return false;
		else
			return true;
	}

	/**
	 * Checks if the support is following the player
	 * 
	 * @return true if she does false if she doesn't
	 */
	public boolean isAlone() {
		if (getMateFollow() != null)
			if (!getMateFollow().isKO())// Checks if the support is dead
				return false;
			else
				return true;
		else
			return true;
	}



	/**
	 * Adds a key in the bunch of keys
	 * 
	 * @param key is the key added to the bunch of keys
	 */
	public void earnKey(Key key) {
		bunchOfKeys.add(key);
	}

	/**
	 * Unlocks a door
	 * 
	 * @param porte is the door you try to unlock
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void unlock(Porte porte) throws InterruptedException {
		for (Key aKey : bunchOfKeys) { // For each key from the bunch of key
			if (porte.unlock(aKey)) { // If the key can unlock the door
				bunchOfKeys.remove(aKey); // Get removed from the bunch of keys
				porte.setCat(0); // Unlocks the door
				Utilitaire.lettreParLettre("Porte déverrouillée.");
				return;
			}

		}
		Utilitaire.lettreParLettre("Vous n'avez pas de clé compatible.");
	}

	/**
	 * Allows the player to unlock a chest
	 * 
	 * @param coffre is the chest the player is trying to unlock
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void unlock(Chest coffre) throws InterruptedException {
		int actCode;
		for (Key aKey : bunchOfKeys) { // For each key from the bunch of key
			if (coffre.unlock(aKey)) { // If a key can unlock the chest
				bunchOfKeys.remove(aKey); // Get removed from the bunch of keys
				coffre.setCat(0); // Unlocks the chest
				actCode = Utilitaire.yesNoQuestions(
						"Coffre déverrouillé. Voulez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
				if (actCode == 1) { // If the player wants to open it
					this.open(coffre);
				} else {
					Utilitaire.lettreParLettre("Vous laissez le coffre fermé");
				}
				return;
			}

		}

		Utilitaire.lettreParLettre("Vous n'avez pas de clé compatible.");
	}

	/**
	 * Allows the player to open the chest
	 * 
	 * @param coffre is the chest the player is trying to open
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)	
	 */
	public void open(Chest coffre) throws InterruptedException { 
		if (coffre.isLocked()) // If the chest is locked
			this.unlock(coffre);
		else {
			if (coffre.getContenu() == null)  // If the chest is empty
				Utilitaire.lettreParLettre("Coffre vide");
			else 
				coffre.getContenu().trouverObjCoffre(coffre, this);

		}
	}
	
	/**
	 * Allows the player to drink the potion
	 * 
	 * @param potion is the potion drank by the player
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public void drink(Potion potion) throws InterruptedException { 
		potion.utiliser(this);
	}

}