package personnages;

import util.Utilitaire;

/**
 * This class creates a character
 * 
 * @author Ted
 *
 */
public abstract class Personnage {

	private int hp;
	private int strength;
	private int maxHp;
	private int critique;

	/**
	 * Creates a character by adding the needed values
	 * 
	 * @param hp       is for the character's max/base hp
	 * @param strength is for the character's strength
	 * @param critique is the critical strike chance
	 */
	public Personnage(int hp, int strength, int critique) {
		super();
		this.hp = hp;
		this.strength = strength;
		this.maxHp = hp;
		this.critique = critique;
	}

////////////////////////////////Getters && Setters//////////////////////////////////////////
	public int getCritique() {
		return critique;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if (hp <= 0) // Look at the HP to be sure they don't go under 0
			this.hp = 0;
		else
			this.hp = hp;
	}

	/**
	 * Allows a critical strike
	 * 
	 * @param ennemi is the character hitten by the critical strike
	 * @param valeur is the critical strike chance of the attacking character
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void coupCritique(Personnage ennemi, double valeur) throws InterruptedException { // Allows a critical strike
		int x;
		x = (int) (Math.random() * 10);
		if (x <= valeur) { // Proba valeur+1/10
			ennemi.setHp(ennemi.getHp() - (this.getStrength()));
			Utilitaire.lettreParLettre("Coup critique !!!");
		}

	}

	public abstract void useSkill(Personnage personnage) throws InterruptedException;

	/**
	 * Gets the character's state (Alive or dead)
	 * 
	 * @return true if dead false if alive
	 */
	public boolean isKO() {
		if (this.hp <= 0) {
			return true;
		} else {
			return false;
		}

	}

}
