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

	/**
	 * Creates a monster and puts it in a room
	 * 
	 * @param hp       is the monster's Health Points
	 * @param strength is the monster's strength
	 * @param critique is the monster's critical strike chance
	 * @param salle    is the room where the monster is implemented
	 */
	public Monstre(int hp, int strength, int critique, Salle salle) {
		super(hp, strength, critique);
		salle.setMonstre(this);
	}

	public abstract String toString();

	public abstract String crier();

	/**
	 * Attacks the player
	 * 
	 * @param joueur is the main player
	 */
	@Override
	public void useSkill(Personnage joueur) throws InterruptedException { // Attaque du monstre sur le joueur
		int dmg = PointDeVie.attaque(this, joueur);
		if (!((PersonnagePrincipal) joueur).isAlone()) { // Si le joueur est accompagn� du support
			Utilitaire.lettreParLettre("Le " + this.toString() + " vous a inflig� " + dmg + " points de d�gats et "
					+ PointDeVie.attaque(this, ((PersonnagePrincipal) joueur).getMateFollow())
					+ " points de d�gats � Laya.");
			if (((PersonnagePrincipal) joueur).getMateFollow().isKO()) // V�rifie la mort du support apr�s son attaque
				Utilitaire.lettreParLettre("Laya est morte");
		} else
			Utilitaire.lettreParLettre("Le " + this.toString() + " vous a inflig� " + dmg + " points de d�gats.");

	}
}
