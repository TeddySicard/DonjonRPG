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
		System.out.println("Le piège vous a infligé "+ dmg +" points de dégats");
		if (joueur.isKO()) {
			joueur.gameOver();
		}
	}
	public String toString() {
		return "piege";
	}

}
