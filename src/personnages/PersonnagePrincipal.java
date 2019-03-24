package personnages;

import java.util.ArrayList;
import java.util.List;

import util.PointDeVie;
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

////////////////////////////////Getters && Setters//////////////////////////////////////
	public Support getMateFollow() {
		return mateFollow;
	}

	public void setMateFollow(Support mateFollow) {
		this.mateFollow = mateFollow;

	}

	public void useSkill(Personnage ennemi) throws InterruptedException { // Attaque du joueur
		Utilitaire.lettreParLettre("Vous avez inflig� " + PointDeVie.attaque(this, ennemi) + " points de d�gats.");

	}

	public void equipWeapon(Arme arme) throws InterruptedException { // Equipe une arme
		if (this.hasWeapon()) { // Si le joueur a d�j� une arme sur lui
			if (this.getStrength() >= arme.getStrength()) // Si l'arme du joueur fait plus mal que l'arme trouv�e
				Utilitaire.lettreParLettre("Votre arme actuelle inflige plus de d�gats. Vous ne changez donc pas d'arme");
			else { // Si son arme actuelle est moins puissant
				Arme weapon;
				this.setStrength(arme.getStrength());
				weapon = this.weaponHeld;
				this.weaponHeld = arme;
				Utilitaire.lettreParLettre("Vous avez jet� " + weapon + " au profit d'" + arme + ".");
			}
		} else { // S'il n'a pas d'arme
			this.setStrength(arme.getStrength());
			this.weaponHeld = arme;
			Utilitaire.lettreParLettre("Vous n'aviez pas d'arme, vous r�cup�rez donc " + arme);
		}
	}

	public boolean hasWeapon() { // V�rifie le port d'arme
		if (weaponHeld == null)
			return false;
		else
			return true;
	}

	public boolean isAlone() {// V�rifie la pr�sence du support
		if (getMateFollow() != null)
			if (!getMateFollow().isKO()) // V�rifie si le support est mort
				return false;
			else
				return true;
		else
			return true;
	}

	public void gameOver() throws InterruptedException { // Game over
		Utilitaire.lettreParLettre("Vous �tes mort\nGame over");
		System.exit(0);

	}

	public void earnKey(Key key) { // Ajouter une cl� au trousseau de cl�
		bunchOfKeys.add(key);
	}

	public void unlock(Porte porte) throws InterruptedException { // D�verrouille une porte
		for (Key aKey : bunchOfKeys) { // Pour toute les cl�s du trousseau
			if (porte.unlock(aKey)) { // Si une cl� est compatible
				bunchOfKeys.remove(aKey); // La retire du trousseau
				porte.setCat(0); // D�verrouille la porte
				Utilitaire.lettreParLettre("Porte d�verrouill�e.");
				return;
			}

		}
		Utilitaire.lettreParLettre("Vous n'avez pas de cl� compatible.");
	}

	public void unlock(Chest coffre) throws InterruptedException { // Permet de d�verrouiller un coffre
		int actCode;
		for (Key aKey : bunchOfKeys) { // Pour toute les cl�s du trousseau
			if (coffre.unlock(aKey)) { // Si une cl� est compatible
				bunchOfKeys.remove(aKey); // La retire du trousseau
				coffre.setCat(0); // D�verrouille le coffre
				actCode = Utilitaire.yesNoQuestions(
						"Coffre d�verrouill�. Voulez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
				if (actCode == 1) { // Si joueur veut l'ouvrir
					this.open(coffre);
				} else {
					Utilitaire.lettreParLettre("Vous laissez le coffre ferm�");
				}
				return;
			}

		}

		Utilitaire.lettreParLettre("Vous n'avez pas de cl� compatible.");
	}

	public void open(Chest coffre) throws InterruptedException { // Permet d'ouvrir un coffre
		if (coffre.isLocked()) // Si le coffre est verrouill�
			this.unlock(coffre);
		else {
			int actCode;
			if (coffre.getContenu() == null) { // Si le coffre est vide
				Utilitaire.lettreParLettre("Coffre vide");
			} else if (coffre.getContenu() instanceof Arme) { // Si le coffre contient une arme
				Utilitaire.lettreParLettre("Le coffre contenait " + coffre.getContenu().toString());
				this.equipWeapon((Arme) coffre.getContenu());
				coffre.setContenu(null); // Supprime l'arme du coffre
			} else if (coffre.getContenu() instanceof Potion) { // Si le coffre contient une potion
				actCode = Utilitaire.yesNoQuestions("Vous avez trouv� une " + coffre.getContenu()
						+ ". Souhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
				if (actCode == 1) { // Si le joueur veut l'utiliser
					this.drink((Potion) coffre.getContenu());
					coffre.setContenu(null); // Supprime la potion du coffre
				} else {
					Utilitaire.lettreParLettre("Vous laissez la potion dans le coffre");
				}

			} else if (coffre.getContenu() instanceof Piege) { // Si le coffre contient un pi�ge
				Utilitaire.lettreParLettre("Le coffre contenait un m�canisme pi�g�.");
				((Piege) coffre.getContenu()).triggerTrap(this);
				coffre.setContenu(null); // Supprime le pi�ge du coffre
			} else if (coffre.getContenu() instanceof Key) { // Si le coffre contient une cl�
				if (((Key) coffre.getContenu()).getCat() == 1) // Si c'est une cl� de coffre
					System.out
							.println("Le coffre contenait une cl� de coffre. Vous l'ajoutez � votre trousseau de cl�.");
				else // Si c'est une cl� de porte
					System.out
							.println("Le coffre contenait une cl� de porte. Vous l'ajoutez � votre trousseau de cl�.");
				this.earnKey((Key) coffre.getContenu());
				coffre.setContenu(null); // Supprime la cl� du coffre
			}

		}
	}

	public void drink(Potion potion) throws InterruptedException { // Boire la potion
		potion.utiliser(this);
	}

}