package objets;

import personnages.Personnage;
import util.PointDeVie;

public class HealingPot extends Potion {

	@Override
	public String toString() {
		return "potion de soin";
	}

	public HealingPot() {
		super((int) Math.random() * 15 + 15);	//Génère une valeur aléatoire à l'instanciation (entre 15 et 29)
	}

	@Override
	public void utiliser(Personnage joueur) {
		joueur.setHp(joueur.getHp() + this.getpower());
		PointDeVie.overhealCheck(joueur);;
		System.out.println("Vous buvez la potion de soin, vous avez maintenant " + joueur.getHp() + " points de vie.");

	}

}
