package personnages;

import java.util.ArrayList;
import java.util.List;

import util.PointDeVie;
import util.Utilitaire;
import armes.Arme;
import donjon.Chest;
import donjon.Porte;
import objets.Key;
import objets.Potion;

/**
 * 
 * @author Ted
 *
 */
public class PersonnagePrincipal extends Personnage {
	private Arme weaponHeld;
	private Support mateFollow;
	public List<Key> bunchOfKeys;
	public final static int HP = 150;
	public final static int ATK = 4;
	public final static int CRIT = 1;

	public PersonnagePrincipal() {
		super(HP, ATK, CRIT);
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
			else { // Si son arme actuelle est moins puissante
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
		Utilitaire.sautDeLignes();
		System.out.println("                      :::!~!!!!!:.\r\n" + 
				"                  .xUHWH!! !!?M88WHX:.\r\n" + 
				"                .X*#M@$!!  !X!M$$$$$$WWx:.\r\n" + 
				"               :!!!!!!?H! :!$!$$$$$$$$$$8X:\r\n" + 
				"              !!~  ~:~!! :~!$!#$$$$$$$$$$8X:\r\n" + 
				"             :!~::!H!<   ~.U$X!?R$$$$$$$$MM!\r\n" + 
				"             ~!~!!!!~~ .:XW$$$U!!?$$$$$$RMM!\r\n" + 
				"               !:~~~ .:!M\"T#$$$$WX??#MRRMMM!\r\n" + 
				"               ~?WuxiW*`   `\"#$$$$8!!!!??!!!\r\n" + 
				"             :X- M$$$$       `\"T#$T~!8$WUXU~\r\n" + 
				"            :%`  ~#$$$m:        ~!~ ?$$$$$$\r\n" + 
				"          :!`.-   ~T$$$$8xx.  .xWW- ~\"\"##*\"\r\n" + 
				".....   -~~:<` !    ~?T#$$@@W@*?$$      /`\r\n" + 
				"W$@@M!!! .!~~ !!     .:XUW$W!~ `\"~:    :\r\n" + 
				"#\"~~`.:x%`!!  !H:   !WM$$$$Ti.: .!WUn+!`\r\n" + 
				":::~:!!`:X~ .: ?H.!u \"$$$B$$$!W:U!T$$M~\r\n" + 
				".~~   :X@!.-~   ?@WTWo(\"*$$$W$TH$! `\r\n" + 
				"Wi.~!X$?!-~    : ?$$$B$Wu(\"**$RM!\r\n" + 
				"$R@i.~~ !     :   ~$$$$$B$$en:``\r\n" + 
				"?MXT@Wx.~    :     ~\"##*$$$$M~");
		Thread.sleep(1000*Utilitaire.getVitessetxt());
		Utilitaire.lettreParLettre("\n\n\n\n\nVous �tes mort\nGame over");
		Utilitaire.rejouerDemande();
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
			if (coffre.getContenu() == null)  // Si le coffre est vide
				Utilitaire.lettreParLettre("Coffre vide");
			else 
				coffre.getContenu().trouverObjCoffre(coffre, this);

		}
	}

	public void drink(Potion potion) throws InterruptedException { // Boire la potion
		potion.utiliser(this);
	}

}