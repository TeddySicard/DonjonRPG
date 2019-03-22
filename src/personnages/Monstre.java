package personnages;

import util.PointDeVie;

public abstract class Monstre extends Personnage {

	public Monstre(int hp, int strength, int critique) {
		super(hp, strength, critique);
	}

	public abstract String toString();

	public abstract String crier();

	public void useSkill(Personnage joueur) { // Attaque du monstre sur le joueur
		int dmg = PointDeVie.attaque(this, joueur);
		if (!((PersonnagePrincipal) joueur).isAlone()) { // Si le joueur est accompagn� du support
			System.out.println("Le " + this.toString() + " vous a inflig� " + dmg + " points de d�gats et "
					+ PointDeVie.attaque(this, ((PersonnagePrincipal) joueur).getMateFollow())
					+ " points de d�gats � Laya.");
			if (((PersonnagePrincipal) joueur).getMateFollow().isKO()) // V�rifie la mort du support apr�s son attaque
				System.out.println("Laya est morte");
		} else
			System.out.println("Le " + this.toString() + " vous a inflig� " + dmg + " points de d�gats.");

	}
}
