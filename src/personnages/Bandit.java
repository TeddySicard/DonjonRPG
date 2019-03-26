package personnages;

import util.PointDeVie;
import util.Utilitaire;

public class Bandit extends Personnage{
	
	public Bandit() {
		super(100, 23, 0);
	}

	@Override
	public void useSkill(Personnage personnage) throws InterruptedException {
		Utilitaire.lettreParLettre("Le bandit vous � inflig� inflig� " + PointDeVie.attaque(this, personnage) + " points de d�gats.");

	}

}
