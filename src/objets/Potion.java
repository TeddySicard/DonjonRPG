package objets;

import donjon.Chest;
import donjon.Salle;
import personnages.Personnage;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public abstract class Potion implements ObjSol, ObjCoffre{
	private int power;

	public Potion(int power) {
		super();
		this.power = power;
	}

	public int getpower() {
		return power;
	}

	@Override
	public abstract String toString();

	public abstract void utiliser(Personnage joueur) throws InterruptedException;
	
	@Override
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		int actCode = Utilitaire.yesNoQuestions("Vous avez trouvé une " + salle.getObjSol()
		+ "\nSouhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
		if (actCode == 1) {
			joueur.drink((Potion) salle.getObjSol());
			salle.setObjSol(null); // Supprime la potion de la salle
		} else {
			Utilitaire.lettreParLettre("Vous laissez la potion sur place");
		}
	}
	
	@Override
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException {
		int actCode = Utilitaire.yesNoQuestions("Vous avez trouvé une " + coffre.getContenu()
		+ ". Souhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
		if (actCode == 1) { // Si le joueur veut l'utiliser
			joueur.drink((Potion) coffre.getContenu());
			coffre.setContenu(null); // Supprime la potion du coffre
		} else 
			Utilitaire.lettreParLettre("Vous laissez la potion dans le coffre");
		
	}
}
