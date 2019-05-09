package personnages;

import donjon.Salle;
import util.PointDeVie;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public abstract class Monstre extends Personnage {
	
	public Salle salle;

	public Monstre(int hp, int strength, int critique, Salle salle) {
		super(hp, strength, critique);
		salle.setMonstre(this);
	}

	public abstract String toString();

	public abstract String crier();

	public void useSkill(Personnage joueur) throws InterruptedException { // Attaque du monstre sur le joueur
		int dmg = PointDeVie.attaque(this, joueur);
		if (!((PersonnagePrincipal) joueur).isAlone()) { // Si le joueur est accompagné du support
			Utilitaire.lettreParLettre("Le " + this.toString() + " vous a infligé " + dmg + " points de dégats et "
					+ PointDeVie.attaque(this, ((PersonnagePrincipal) joueur).getMateFollow())
					+ " points de dégats à Laya.");
			if (((PersonnagePrincipal) joueur).getMateFollow().isKO()) // Vérifie la mort du support après son attaque
				Utilitaire.lettreParLettre("Laya est morte");
		} else
			Utilitaire.lettreParLettre("Le " + this.toString() + " vous a infligé " + dmg + " points de dégats.");

	}
}
