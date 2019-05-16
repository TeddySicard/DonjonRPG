package armes;

import donjon.Chest;
import donjon.Salle;
import objets.ObjSol;
import personnages.PersonnagePrincipal;
import util.Utilitaire;
import objets.ObjCoffre;

/**
 * 
 * @author Ted
 *
 */
public abstract class Arme implements ObjSol, ObjCoffre {
	private int strength; // Strength of the weapon

	public Arme(int strength) {
		super();
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}

	public abstract String toString();

	/**
	 * Make the player get the weapon found on the ground when he exams the room
	 * where he's located
	 */
	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Vous avez trouvé " + salle.getObjSol().toString() + " dans la salle");
		Utilitaire.lettreParLettre(joueur.equipWeapon((Arme) salle.getObjSol()));
		salle.setObjSol(null); // Delete the weapon from the room
	}

	/**
	 * Make the player get the weapon found on the ground when he opens the chest he
	 * is looking at
	 */
	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre("Le coffre contenait " + coffre.getContenu().toString());
		Utilitaire.lettreParLettre(joueur.equipWeapon((Arme) coffre.getContenu()));
		coffre.setContenu(null); // Delete the weapon from the chest
	}

}
