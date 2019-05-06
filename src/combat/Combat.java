package combat;

import personnages.Monstre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Combat {

	public static void combattre(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		int actCode;
		Utilitaire.lettreParLettre("\nCombat enclenché contre un " + ennemi.toString() + " !!!");
		while (!joueur.isKO() && !ennemi.isKO()) {
			actCode = Utilitaire.yesNoQuestions("Que voulez vous faire ?\n1 pour attaquer\n2 pour esquiver"); // Get
																												// the
																												// entered
																												// command
			if (actCode == 1) { // Attack command
				joueur.useSkill(ennemi);
				if (!ennemi.isKO()) // Check the monster's status to prevent him from attacking if he's already dead
					ennemi.useSkill(joueur);
				if (!joueur.isAlone()) // Check the support's presence beside the player to use his skills
					joueur.getMateFollow().useSkill(joueur);
			} else { // Dodging command
				Combat.esquive(joueur, ennemi);
			}
			Combat.affPV(joueur, ennemi); // Displays Health Points
		}
		if (joueur.isKO()) { // Checks the player's death == Game Over Screen
			joueur.gameOver();
		} else { // Joueur victorieux
			Utilitaire.lettreParLettre("\nCombat terminé !!"); // Ending of the fight
			Utilitaire.lettreParLettre("Vous avez tué le " + ennemi.toString() + "\n\n\n");
		}
	}

	public static void esquive(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		int x;
		x = (int) (Math.random() * 10); // Random generation of a number between 0 and 9
		if (x <= 1) { // 1/5 probability to counter-attack
			int dmg;
			dmg = ennemi.getHp();
			Utilitaire.lettreParLettre("Vous arrivez à contre-attaquer en esquivant.");
			ennemi.setHp(ennemi.getHp() - (joueur.getStrength()));
			dmg -= ennemi.getHp();
			Utilitaire.lettreParLettre("Vous avez infligé " + dmg + " points de dégats.");
		} else if (x <= 3) { // 1/5 probability to fail the dodge
			int dmg;
			dmg = joueur.getHp();
			Utilitaire.lettreParLettre("Vous échouez votre esquive.");
			joueur.setHp(joueur.getHp() - (ennemi.getStrength()) / 2);
			dmg -= joueur.getHp();
			Utilitaire.lettreParLettre("L'ennemi vous a infligé " + dmg + " points de dégats.");
		} else { // 3/5 probability to dodge
			Utilitaire.lettreParLettre("Vous esquivez l'attaque ennemi.");
		}
	}

	public static void affPV(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		if (joueur.isAlone()) { // Displays the player's and the monster's HP
			Utilitaire.lettreParLettre("PV Joueur = " + joueur.getHp() + "\nPV " + ennemi.toString() + " = " + ennemi.getHp());
		} else { //  Displays the player's , the support and the monster's HP
			Utilitaire.lettreParLettre("PV Joueur = " + joueur.getHp() + "\nPV Laya = " + joueur.getMateFollow().getHp()
					+ "\nPV " + ennemi.toString() + " = " + ennemi.getHp());
		}
	}
}
