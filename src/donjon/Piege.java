package donjon;

import personnages.PersonnagePrincipal;

public class Piege {
	private int strength;

	public Piege() {
		super();
		this.strength = (int) (Math.random()*10+15);
	}

	public int getStrength() {
		return strength;
	}
	public void triggerTrap(PersonnagePrincipal joueur) {
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg = dmg - joueur.getHp();
		System.out.println("Le pi�ge vous a inflig� "+ dmg +" points de d�gats");
		if (joueur.isKO()) {
			joueur.gameOver();
		}
	}
	public String toString() {
		return "piege";
	}

}
