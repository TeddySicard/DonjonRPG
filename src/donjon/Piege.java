package donjon;

import personnages.PersonnagePrincipal;

public class Piege {
	private int strength;

	public Piege() {
		super();
		this.strength = (int) (Math.random() * 10 + 15); // Valeur g�n�r�e al�atoirement lors de l'instanciation du
															// pi�ge (entre 15 et 24)
	}

	public int getStrength() {
		return strength;
	}

	public void triggerTrap(PersonnagePrincipal joueur) { // Active le pi�ge
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg -= joueur.getHp();
		System.out.println("Le pi�ge vous a inflig� " + dmg + " points de d�gats");
		if (joueur.isKO()) { // Si le joueur meurt
			joueur.gameOver();
		}
	}

}
