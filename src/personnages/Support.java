package personnages;

import util.PointDeVie;
import util.Utilitaire;

public class Support extends Personnage {
	public Support() {
		super(100, 7, 0);
	}

	@Override
	public void useSkill(Personnage joueur) throws InterruptedException { // Soigne le joueur
		int x;
		x = (int) (Math.random() * 10); // G�n�re une valeur al�atoire � chaque appel de la m�thode
		if (x <= 4) { // Proba 1/2 de se r�aliser
			this.setHp(this.getHp() + this.getStrength());
			PointDeVie.overhealCheck(joueur);
			PointDeVie.overhealCheck(this);
			Utilitaire.lettreParLettre("Laya vous a soign� et s'est �galement soign�e");
		}

	}
}
