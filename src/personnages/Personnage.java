package personnages;

import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public abstract class Personnage {

	private int hp;
	private int strength;
	private int maxHp;
	private int critique;

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
		if (hp <= 0) // Permet de réguler les PV pour qu'ils ne descendent pas en dessous de 0
			this.hp = 0;
		else
			this.hp = hp;
	}

	public void coupCritique(Personnage ennemi, double valeur) throws InterruptedException { // Permet de faire un coup critique
		int x;
		x = (int) (Math.random() * 10);
		if (x <= valeur) { // Proba valeur+1/10
			ennemi.setHp(ennemi.getHp() - (this.getStrength()));
			Utilitaire.lettreParLettre("Coup critique !!!");
		}

	}

	public abstract void useSkill(Personnage personnage) throws InterruptedException;

	public boolean isKO() { // Vérifie si le joueur est KO
		if (this.hp <= 0) { // Si ses PV sont nuls
			return true;
		} else {
			return false;
		}

	}

}
