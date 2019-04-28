package armes;

import donjon.Salle;
import objets.ObjSol;
import personnages.PersonnagePrincipal;
import util.Utilitaire;
import objets.Chest;
import objets.ObjCoffre;

public abstract class Arme implements ObjSol, ObjCoffre {
	private int strength;

	public Arme(int strength) {
		super();
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

	public abstract String toString();
	
	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Vous avez trouvé " + salle.getObjSol().toString() + " dans la salle");
		joueur.equipWeapon((Arme) salle.getObjSol());
		salle.setObjSol(null); // Supprime l'arme du sol
	}
	
	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Le coffre contenait " + coffre.getContenu().toString());
		joueur.equipWeapon((Arme) coffre.getContenu());
		coffre.setContenu(null); // Supprime l'arme du coffre
	}

}
