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
		x = (int) (Math.random() * 10); // G�n�re une valeur al�atoire � chaque appel de la m�thode
		if (x <= 4) { // Proba 1/2 de se r�aliser
			joueur.setHp(joueur.getHp() + this.getStrength());
			this.setHp(this.getHp() + this.getStrength());
			PointDeVie.overhealCheck(joueur);
			PointDeVie.overhealCheck(this);
			Utilitaire.lettreParLettre("Laya vous a soign� et s'est �galement soign�e");
		}

	}

	@Override
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {

		Utilitaire.lettreParLettre("Vous apprenez qu'elle s'appelle Laya et qu'elle poss�de des pouvoirs de gu�rison");
		Utilitaire.lettreParLettre("Laya vous � rejoint, elle pourra vous soigner lors de vos futurs combats\n\n");
		joueur.setMateFollow((Support) salle.getPnj());// Ajoute le support en tant que co-�quipier du joueur

	}

}
