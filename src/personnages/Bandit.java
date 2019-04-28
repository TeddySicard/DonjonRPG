package personnages;

import donjon.Salle;
import util.PointDeVie;
import util.Utilitaire;

public class Bandit extends Personnage implements PNJ {
	
	public final static int HP = 100;
	public final static int ATK = 23;
	public final static int CRIT = 0;
	
	public Bandit(Salle salle) {
		super(HP, ATK, CRIT);
		salle.setPnj(this);
		
	}

	@Override
	public void useSkill(Personnage personnage) throws InterruptedException {
		Utilitaire.lettreParLettre("Le bandit vous � inflig� inflig� " + PointDeVie.attaque(this, personnage) + " points de d�gats.");

	}

	@Override
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException {
		Utilitaire.lettreParLettre(
				"La personne s'av�re �tre un bandit, elle vous donne un coup de couteau avant de s'enfuir");
			((Bandit) salle.getPnj()).useSkill(joueur);
	
		
	}

}
