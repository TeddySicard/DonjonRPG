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
			return "cl� de coffre";
		else
			return "cl� de porte";

	}

	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		if (((Key) coffre.getContenu()).getCat() == 1) // Si c'est une cl� de coffre
			Utilitaire.lettreParLettre("Le coffre contenait une cl� de coffre. Vous l'ajoutez � votre trousseau de cl�.");
		else // Si c'est une cl� de porte
			Utilitaire.lettreParLettre("Le coffre contenait une cl� de porte. Vous l'ajoutez � votre trousseau de cl�.");
		joueur.earnKey((Key) coffre.getContenu());
		coffre.setContenu(null); // Supprime la cl� du coffre
	}

	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre(
				"Vous trouvez une "+ this.toString()+". Vous l'ajoutez � votre trousseau de cl�.");
	joueur.earnKey((Key) salle.getObjSol());
	salle.setObjSol(null); // Supprime la cl� de la place
	}

}
