package donjon;

import objets.ObjCoffre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Piege implements ObjCoffre {
	
	private int strength;

	public Piege(Salle salle) {
		salle.setPiege(this);
		this.strength = (int) (Math.random() * 10 + 15); // Valeur générée aléatoirement lors de l'instanciation du
		// piège (entre 15 et 24)
	}
	public Piege() {
		this.strength = (int) (Math.random() * 10 + 15); // Valeur générée aléatoirement lors de l'instanciation du
		// piège (entre 15 et 24)
	}

	public int getStrength() {
		return strength;
	}


	public void triggerTrap(PersonnagePrincipal joueur) throws InterruptedException { // Active le piège
		int dmg;
		dmg = joueur.getHp();
		joueur.setHp(joueur.getHp() - this.getStrength());
		dmg -= joueur.getHp();
		System.out.println("Le piège vous a infligé " + dmg + " points de dégats");
		if (joueur.isKO()) { // Si le joueur meurt
			joueur.gameOver();
		}
	}

	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Le coffre contenait un mécanisme piégé.");
		((Piege) coffre.getContenu()).triggerTrap(joueur);
		coffre.setContenu(null); // Supprime le piège du coffre
	}

}
