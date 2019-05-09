package personnages;

import donjon.Salle;
import util.PointDeVie;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Support extends Personnage implements PNJ {

	public final static int HP = 100;
	public final static int ATK = 7;
	public final static int CRIT = 0;

	public Support(Salle salle) {
		super(HP, ATK, CRIT);
		salle.setPnj(this);
	}

	@Override
	public void useSkill(Personnage joueur) throws InterruptedException { // Soigne le joueur
		int x;
		x = (int) (Math.random() * 10); // Génère une valeur aléatoire à chaque appel de la méthode
		if (x <= 4) { // Proba 1/2 de se réaliser
			joueur.setHp(joueur.getHp() + this.getStrength());
			this.setHp(this.getHp() + this.getStrength());
			PointDeVie.overhealCheck(joueur);
			PointDeVie.overhealCheck(this);
			Utilitaire.lettreParLettre("Laya vous a soigné et s'est également soignée");
		}

	}

	@Override
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {

		Utilitaire.lettreParLettre("Vous apprenez qu'elle s'appelle Laya et qu'elle possède des pouvoirs de guérison");
		Utilitaire.lettreParLettre("Laya vous à rejoint, elle pourra vous soigner lors de vos futurs combats\n\n");
		joueur.setMateFollow((Support) salle.getPnj());// Ajoute le support en tant que co-équipier du joueur

	}

}
