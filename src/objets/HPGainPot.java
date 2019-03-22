package objets;

import personnages.Personnage;

public class HPGainPot extends Potion {

	@Override
	public String toString() {
		return "potion de gain de PV max";
	}

	public HPGainPot() {
		super((int) (Math.random() * 15 + 15)); // Génère une valeur aléatoire à l'instanciation (entre 15 et 29)
	}

	@Override
	public void utiliser(Personnage joueur) {
		joueur.setMaxHp(joueur.getMaxHp() + this.getpower());
		joueur.setHp(joueur.getHp() + this.getpower());
		System.out.println("Vous buvez la potion, vos PV max ont augmenté. Vous avez maintenant " + joueur.getHp()
				+ " points de vie et " + joueur.getMaxHp() + " PV maximum.");

	}

}
