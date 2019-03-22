package donjon;

import personnages.PersonnagePrincipal;

public class Piege {
	private int strength;

	public Piege() {
		super();
		this.strength = (int) (Math.random() * 10 + 15); // Valeur générée aléatoirement lors de l'instanciation du
															// piège (entre 15 et 24)
	}

	public int getStrength() {
		return strength;
	}

	public void triggerTrap(PersonnagePrincipal joueur) { // Active le piège
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg -= joueur.getHp();
		System.out.println("Le piège vous a infligé " + dmg + " points de dégats");
		if (joueur.isKO()) { // Si le joueur meurt
			joueur.gameOver();
		}
	}

}
