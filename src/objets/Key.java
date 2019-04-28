package objets;

import donjon.Salle;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Key implements ObjCoffre, ObjSol{
	private int cat;

	public Key(int cat) {
		super();
		this.cat = cat;
	}

	public int getCat() {
		return cat;
	}

	public String toString() {
		if (this.getCat() == 1)
			return "clé de coffre";
		else
			return "clé de porte";

	}

	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		if (((Key) coffre.getContenu()).getCat() == 1) // Si c'est une clé de coffre
			Utilitaire.lettreParLettre("Le coffre contenait une clé de coffre. Vous l'ajoutez à votre trousseau de clé.");
		else // Si c'est une clé de porte
			Utilitaire.lettreParLettre("Le coffre contenait une clé de porte. Vous l'ajoutez à votre trousseau de clé.");
		joueur.earnKey((Key) coffre.getContenu());
		coffre.setContenu(null); // Supprime la clé du coffre
	}

	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre(
				"Vous trouvez une "+ this.toString()+". Vous l'ajoutez à votre trousseau de clé.");
	joueur.earnKey((Key) salle.getObjSol());
	salle.setObjSol(null); // Supprime la clé de la place
	}

}
