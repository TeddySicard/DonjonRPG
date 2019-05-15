package objets;

import donjon.Chest;
import donjon.Salle;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Key implements ObjCoffre, ObjSol {
	private int cat;

	/**
	 * create a key
	 * 
	 * @param cat represent the key category (1 is for a chest key 2 is for a door
	 *            key)
	 */
	public Key(int cat) {
		super();
		this.cat = cat;
	}

	public int getCat() {
		return cat;
	}

	/**
	 * Create a string showing the key's specs
	 */
	public String toString() {
		return "clé " + (this.getCat() == 1 ? "de coffre" : "de porte");

	}

	/**
	 * Finds the key in a chest
	 */
	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre(
				"Le coffre contenait une " + this.toString() + ". Vous l'ajoutez à votre trousseau de clé.");
		joueur.earnKey((Key) coffre.getContenu());
		coffre.setContenu(null); // Supprime la clé du coffre
	}

	/**
	 * Finds the key in a room
	 */
	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire
				.lettreParLettre("Vous trouvez une " + this.toString() + ". Vous l'ajoutez à votre trousseau de clé.");
		joueur.earnKey((Key) salle.getObjSol());
		salle.setObjSol(null); // Supprime la clé de la place
	}

}
