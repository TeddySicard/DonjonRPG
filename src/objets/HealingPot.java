package objets;

import personnages.Personnage;

public class HealingPot extends Potion {

	@Override
	public String toString() {
		return "potion de soin";
	}

	public HealingPot() {
		super((int) Math.random() * 15 + 15);
	}

	@Override
	public void utiliser(Personnage joueur) {
		joueur.setHp(joueur.getHp() + this.getpower());
		if (joueur.getHp() >= joueur.getMaxHp())
			joueur.setHp(joueur.getMaxHp());
		System.out.println("Vous buvez la potion de soin, vous avez maintenant " + joueur.getHp() + " points de vie.");

	}

}
