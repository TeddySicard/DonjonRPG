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
		Utilitaire.lettreParLettre("Vous avez infligé " + PointDeVie.attaque(this, ennemi) + " points de dégats.");

	}

	public void equipWeapon(Arme arme) throws InterruptedException { // Equipe une arme
		if (this.hasWeapon()) { // Si le joueur a déjà une arme sur lui
			if (this.getStrength() >= arme.getStrength()) // Si l'arme du joueur fait plus mal que l'arme trouvée
				Utilitaire.lettreParLettre("Votre arme actuelle inflige plus de dégats. Vous ne changez donc pas d'arme");
			else { // Si son arme actuelle est moins puissante
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
		Utilitaire.lettreParLettre("\n\n\n\n\nVous êtes mort\nGame over");
		Utilitaire.rejouerDemande();
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