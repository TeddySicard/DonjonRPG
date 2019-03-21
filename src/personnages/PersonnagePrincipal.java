package personnages;

import java.util.ArrayList;
import java.util.List;
import util.Utilitaire;
import armes.Arme;
import donjon.Piege;
import donjon.Porte;
import objets.Chest;
import objets.Key;
import objets.Potion;

public class PersonnagePrincipal extends Personnage {
	private Arme weaponHeld;
	private Support mateFollow;
	public List<Key> bunchOfKeys;

	public PersonnagePrincipal() {
		super(150, 4, 1);
		this.weaponHeld = null;
		this.setMateFollow(null);
		bunchOfKeys = new ArrayList<>();

	}

	public Support getMateFollow() { //
		return mateFollow; //
	} //
		//

	public void setMateFollow(Support mateFollow) { // GETTERS & SETTERS
		this.mateFollow = mateFollow; //
										//
	} //
		// ATTAQUE DU JOUEUR//

	public void useSkill(Personnage ennemi) {
		int dmg;
		dmg = ennemi.getHp();
		ennemi.setHp(ennemi.getHp() - this.getStrength());
		super.coupCritique(ennemi, this.getCritique());
		dmg = dmg - ennemi.getHp();
		System.out.println("Vous avez infligé " + dmg + " points de dégats.");

	}

	// EQUIPER UNE ARME//
	public void equipWeapon(Arme arme) {
		if (this.hasWeapon()) {
			if (this.getStrength() >= arme.getStrength())
				System.out.println("Votre arme actuelle inflige plus de dégats. Vous ne changez donc pas d'arme");
			else if (this.hasWeapon()) {
				Arme weapon;
				this.setStrength(arme.getStrength());
				weapon = this.weaponHeld;
				this.weaponHeld = arme;
				System.out.println("Vous avez jeté " + weapon + " au profit d'" + arme + ".");
			}
		} else {
			this.setStrength(arme.getStrength());
			this.weaponHeld = arme;
			System.out.println("Vous n'aviez pas d'arme, vous récupérez donc " + arme);
		}
	}

	// VERIFIER LE PORT D'ARME//
	public boolean hasWeapon() {
		if (weaponHeld == null)
			return false;
		else
			return true;
	}

	// VERIFIER LA PRESENCE DU SUPPORT//
	public boolean isAlone() {
		if (getMateFollow() != null)
			if (!getMateFollow().isKO())
				return false;
			else
				return true;
		else
			return true;
	}

	// GAME OVER//
	public void gameOver() {
		System.out.println("Vous êtes mort\nGame over");
		System.exit(1);

	}

	// OBTENIR UNE CLE
	public void earnKey(Key key) {
		bunchOfKeys.add(key);
	}
	
	// DEVEROUILLER UNE PORTE//
	public void unlock(Porte porte) {
		boolean success;
		success = false;
		for (Key aKey : bunchOfKeys) {
			if (porte.unlock(aKey)) {
				bunchOfKeys.remove(aKey);
				porte.setCat(0);
				success = true;
				break;
			}

		}
		if (success) {
			System.out.println("Porte déverrouillée.");

		}

		else
			System.out.println("Vous n'avez pas de clé compatible.");
	}
	

	
	// DEVEROUILLER UN COFFRE//
	public void unlock(Chest coffre) throws InterruptedException {
		int actCode;
		boolean success;
		success = false;
		for (Key aKey : bunchOfKeys) {
			if (coffre.unlock(aKey)) {
				bunchOfKeys.remove(aKey);
				coffre.setCat(0);
				success = true;
				break;
			}

		}
		if (success) {
			actCode = Utilitaire.yesNoQuestions("Coffre déverrouillé. Voulez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
			if (actCode == 1) {
				this.open(coffre);
			} else {
				System.out.println("Vous laissez le coffre fermé");
			}

		}

		else
			System.out.println("Vous n'avez pas de clé compatible.");
	}

	// OUVRIR LE COFFRE//
	public void open(Chest coffre) throws InterruptedException {
		if (coffre.isLocked())
			this.unlock(coffre);
		else {
			int actCode;
			if (coffre.getContenu() == null) {
				System.out.println("Coffre vide");
			} else if (coffre.getContenu() instanceof Arme) {
				System.out.println("Le coffre contenait " + coffre.getContenu().toString());
				this.equipWeapon((Arme) coffre.getContenu());
				coffre.setContenu(null);
			} else if (coffre.getContenu() instanceof Potion) {
				actCode = Utilitaire.yesNoQuestions("Vous avez trouvé une " + coffre.getContenu()
				+ ". Souhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
				if (actCode == 1) {
					this.drink((Potion) coffre.getContenu());
					coffre.setContenu(null);
				} else {
					System.out.println("Vous laissez la potion dans le coffre");
				}

			} else if (coffre.getContenu() instanceof Piege) {
				System.out.println("Le coffre contenait un mécanisme piégé.");
				Piege piege = ((Piege) coffre.getContenu());
				piege.triggerTrap(this);
				coffre.setContenu(null);
			} else if (coffre.getContenu() instanceof Key) {
				if (((Key) coffre.getContenu()).getCat() == 1)
					System.out
							.println("Le coffre contenait une clé de coffre. Vous l'ajoutez à votre trousseau de clé.");
				else
					System.out
							.println("Le coffre contenait une clé de porte. Vous l'ajoutez à votre trousseau de clé.");
				this.earnKey((Key) coffre.getContenu());
				coffre.setContenu(null);
			}

		}
	}

	// BOIRE POTION//
	public void drink(Potion potion) {
		potion.utiliser(this);
	}

	// ACTIVER PIEGE//
	public void actTrap(Piege trap) {
		this.setHp(this.getHp() - trap.getStrength());
		System.out.println("Vous perdez " + trap.getStrength() + "PV.");
		if (this.isKO())
			this.gameOver();

	}

}