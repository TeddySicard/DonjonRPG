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
		x = (int) (Math.random() * 10); // Génère une valeur aléatoire à chaque appel de la méthode
		if (x <= 4) { // Proba 1/2 de se réaliser
			this.setHp(this.getHp() + this.getStrength());
			PointDeVie.overhealCheck(joueur);
			PointDeVie.overhealCheck(this);
			Utilitaire.lettreParLettre("Laya vous a soigné et s'est également soignée");
		}

	}
}
