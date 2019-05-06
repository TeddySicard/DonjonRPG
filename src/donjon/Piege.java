package donjon;

import objets.ObjCoffre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Piege implements ObjCoffre {
	
	private int strength;

	public Piege(Salle salle) {
		salle.setPiege(this);
		this.strength = (int) (Math.random() * 10 + 15); // Valeur g�n�r�e al�atoirement lors de l'instanciation du
		// pi�ge (entre 15 et 24)
	}
	public Piege() {
		this.strength = (int) (Math.random() * 10 + 15); // Valeur g�n�r�e al�atoirement lors de l'instanciation du
		// pi�ge (entre 15 et 24)
	}

	public int getStrength() {
		return strength;
	}


	public void triggerTrap(PersonnagePrincipal joueur) throws InterruptedException { // Active le pi�ge
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg -= joueur.getHp();
		System.out.println("Le pi�ge vous a inflig� " + dmg + " points de d�gats");
		if (joueur.isKO()) { // Si le joueur meurt
			joueur.gameOver();
		}
	}

	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Le coffre contenait un m�canisme pi�g�.");
		((Piege) coffre.getContenu()).triggerTrap(joueur);
		coffre.setContenu(null); // Supprime le pi�ge du coffre
	}

}
