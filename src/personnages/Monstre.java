package personnages;

public abstract class Monstre extends Personnage {

	public Monstre(int hp, int strength, int critique) {
		super(hp, strength, critique);
	}

	public abstract String toString();

	public abstract String crier();

	public void useSkill(Personnage joueur) {
		PersonnagePrincipal ennemi = (PersonnagePrincipal) joueur;
		int dmg;
		dmg = ennemi.getHp();
		ennemi.setHp(ennemi.getHp() - this.getStrength());
		super.coupCritique(ennemi, this.getCritique());
		dmg = dmg - ennemi.getHp();
		if (!ennemi.isAlone()) {
			int dmg2;
			dmg2 = ennemi.getMateFollow().getHp();
			ennemi.getMateFollow().setHp(ennemi.getMateFollow().getHp() - this.getStrength());
			super.coupCritique(ennemi.getMateFollow(), 0);
			dmg2 = dmg2 - ennemi.getMateFollow().getHp();
			System.out.println("Le " + this.toString() + " vous a infligé " + dmg + " points de dégats et " + dmg2
					+ " points de dégats à Laya.");
			if (ennemi.getMateFollow().isKO())
				System.out.println("Laya est morte");
		} else
			System.out.println("Le " + this.toString() + " vous a infligé " + dmg + " points de dégats.");

	}
}
