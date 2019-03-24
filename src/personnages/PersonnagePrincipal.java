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
		Utilitaire.lettreParLettre("Vous avez infligé " + PointDeVie.attaque(this, ennemi) + " points de dégats.");

	}

	public void equipWeapon(Arme arme) throws InterruptedException { // Equipe une arme
		if (this.hasWeapon()) { // Si le joueur a déjà une arme sur lui
			if (this.getStrength() >= arme.getStrength()) // Si l'arme du joueur fait plus mal que l'arme trouvée
				Utilitaire.lettreParLettre("Votre arme actuelle inflige plus de dégats. Vous ne changez donc pas d'arme");
			else { // Si son arme actuelle est moins puissant
				Arme weapon;
				this.setStrength(arme.getStrength());
				weapon = this.weaponHeld;
				this.weaponHeld = arme;
				Utilitaire.lettreParLettre("Vous avez jeté " + weapon + " au profit d'" + arme + ".");
			}
		} else { // S'il n'a pas d'arme
			this.setStrength(arme.getStrength());
			this.weaponHeld = arme;
			Utilitaire.lettreParLettre("Vous n'aviez pas d'arme, vous récupérez donc " + arme);
		}
	}

	public boolean hasWeapon() { // Vérifie le port d'arme
		if (weaponHeld == null)
			return false;
		else
			return true;
	}

	public boolean isAlone() {// Vérifie la présence du support
		if (getMateFollow() != null)
			if (!getMateFollow().isKO()) // Vérifie si le support est mort
				return false;
			else
				return true;
		else
			return true;
	}

	public void gameOver() throws InterruptedException { // Game over
		Utilitaire.lettreParLettre("Vous êtes mort\nGame over");
		System.exit(0);

	}

	public void earnKey(Key key) { // Ajouter une clé au trousseau de clé
		bunchOfKeys.add(key);
	}

	public void unlock(Porte porte) throws InterruptedException { // Déverrouille une porte
		for (Key aKey : bunchOfKeys) { // Pour toute les clés du trousseau
			if (porte.unlock(aKey)) { // Si une clé est compatible
				bunchOfKeys.remove(aKey); // La retire du trousseau
				porte.setCat(0); // Déverrouille la porte
				Utilitaire.lettreParLettre("Porte déverrouillée.");
				return;
			}

		}
		Utilitaire.lettreParLettre("Vous n'avez pas de clé compatible.");
	}

	public void unlock(Chest coffre) throws InterruptedException { // Permet de déverrouiller un coffre
		int actCode;
		for (Key aKey : bunchOfKeys) { // Pour toute les clés du trousseau
			if (coffre.unlock(aKey)) { // Si une clé est compatible
				bunchOfKeys.remove(aKey); // La retire du trousseau
				coffre.setCat(0); // Déverrouille le coffre
				actCode = Utilitaire.yesNoQuestions(
						"Coffre déverrouillé. Voulez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
				if (actCode == 1) { // Si joueur veut l'ouvrir
					this.open(coffre);
				} else {
					Utilitaire.lettreParLettre("Vous laissez le coffre fermé");
				}
				return;
			}

		}

		Utilitaire.lettreParLettre("Vous n'avez pas de clé compatible.");
	}

	public void open(Chest coffre) throws InterruptedException { // Permet d'ouvrir un coffre
		if (coffre.isLocked()) // Si le coffre est verrouillé
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
				actCode = Utilitaire.yesNoQuestions("Vous avez trouvé une " + coffre.getContenu()
						+ ". Souhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
				if (actCode == 1) { // Si le joueur veut l'utiliser
					this.drink((Potion) coffre.getContenu());
					coffre.setContenu(null); // Supprime la potion du coffre
				} else {
					Utilitaire.lettreParLettre("Vous laissez la potion dans le coffre");
				}

			} else if (coffre.getContenu() instanceof Piege) { // Si le coffre contient un piège
				Utilitaire.lettreParLettre("Le coffre contenait un mécanisme piégé.");
				((Piege) coffre.getContenu()).triggerTrap(this);
				coffre.setContenu(null); // Supprime le piège du coffre
			} else if (coffre.getContenu() instanceof Key) { // Si le coffre contient une clé
				if (((Key) coffre.getContenu()).getCat() == 1) // Si c'est une clé de coffre
					System.out
							.println("Le coffre contenait une clé de coffre. Vous l'ajoutez à votre trousseau de clé.");
				else // Si c'est une clé de porte
					System.out
							.println("Le coffre contenait une clé de porte. Vous l'ajoutez à votre trousseau de clé.");
				this.earnKey((Key) coffre.getContenu());
				coffre.setContenu(null); // Supprime la clé du coffre
			}

		}
	}

	public void drink(Potion potion) throws InterruptedException { // Boire la potion
		potion.utiliser(this);
	}

}