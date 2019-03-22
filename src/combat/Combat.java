package combat;


import personnages.Monstre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Combat {

	public static void combattre(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		int actCode;
		System.out.println("\nCombat enclenché contre un " + ennemi.toString() + " !!!");
		while (!joueur.isKO() && !ennemi.isKO()) {
			actCode = Utilitaire.yesNoQuestions("Que voulez vous faire ?\n1 pour attaquer\n2 pour esquiver"); //Récupère la commande entrée
			if (actCode == 1) {					//Commande d'attaque
				joueur.useSkill(ennemi);
				if (!ennemi.isKO()) 			//Vérifie si l'ennemi est mort pour l'empêcher d'attaquer si c'est le cas
					ennemi.useSkill(joueur);
				if (!joueur.isAlone()) 			//Vérifie la présence de l'allié aux côtés du joueur pour lui faire utiliser ses pouvoirs
					joueur.getMateFollow().useSkill(joueur);
			} else {							//Commande de défense
				Combat.esquive(joueur, ennemi);
			}
			Combat.affPV(joueur, ennemi);	//Commande d'affichage des points de vie
		}
		System.out.println("\nCombat terminé !!");	//Fin de combat
		if (joueur.isKO()) {	//Vérifie si le joueur est mort == écran game over
			joueur.gameOver();
		}
		else {					//Joueur victorieux
			System.out.println("Vous avez tué le "+ennemi.toString()+"\n\n\n");
		}
	}

	public static void esquive(PersonnagePrincipal joueur, Monstre ennemi) {
		int x;
		x = (int) (Math.random() * 10);		//Génère de l'aléatoire entre 0 et 9
		if (x <= 1) {						//1/5 proba de contre-attaquer
			int dmg;
			dmg = ennemi.getHp();
			System.out.println("Vous arrivez à contre-attaquer en esquivant.");
			ennemi.setHp(ennemi.getHp() - (joueur.getStrength()));
			dmg -= ennemi.getHp();
			System.out.println("Vous avez infligé " + dmg + " points de dégats.");
		} else if (x <= 3) {				//1/5 proba d'échouer l'esquive
			int dmg;
			dmg = joueur.getHp();
			System.out.println("Vous échouez votre esquive.");
			joueur.setHp(joueur.getHp() - (ennemi.getStrength()) / 2);
			dmg -= - joueur.getHp();
			System.out.println("L'ennemi vous a infligé " + dmg + " points de dégats.");
		} else {							//3/5 proba d'esquiver
			System.out.println("Vous esquivez l'attaque ennemi.");
		}
	}
	public static void affPV(PersonnagePrincipal joueur, Monstre ennemi) {
		if (joueur.isAlone()) {				//Affiche les pv pour le joueur et l'ennemi
			System.out.println("PV Joueur = " + joueur.getHp() + "\nPV " + ennemi.toString() + " = "
					+ ennemi.getHp());
		}
		else {								//Affiche les pv pour le joueur, le support et l'ennemi
			System.out.println("PV Joueur = " + joueur.getHp() + "\nPV Laya = " + joueur.getMateFollow().getHp()
					+ "\nPV " + ennemi.toString() + " = " + ennemi.getHp());
		}
	}
}
