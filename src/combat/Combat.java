package combat;


import personnages.Monstre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Combat {

	public static void combattre(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		int actCode;
		System.out.println("\nCombat enclench� contre un " + ennemi.toString() + " !!!");
		while (!joueur.isKO() && !ennemi.isKO()) {
			actCode = Utilitaire.yesNoQuestions("Que voulez vous faire ?\n1 pour attaquer\n2 pour esquiver"); //R�cup�re la commande entr�e
			if (actCode == 1) {					//Commande d'attaque
				joueur.useSkill(ennemi);
				if (!ennemi.isKO()) 			//V�rifie si l'ennemi est mort pour l'emp�cher d'attaquer si c'est le cas
					ennemi.useSkill(joueur);
				if (!joueur.isAlone()) 			//V�rifie la pr�sence de l'alli� aux c�t�s du joueur pour lui faire utiliser ses pouvoirs
					joueur.getMateFollow().useSkill(joueur);
			} else {							//Commande de d�fense
				Combat.esquive(joueur, ennemi);
			}
			Combat.affPV(joueur, ennemi);	//Commande d'affichage des points de vie
		}
		System.out.println("\nCombat termin� !!");	//Fin de combat
		if (joueur.isKO()) {	//V�rifie si le joueur est mort == �cran game over
			joueur.gameOver();
		}
		else {					//Joueur victorieux
			System.out.println("Vous avez tu� le "+ennemi.toString()+"\n\n\n");
		}
	}

	public static void esquive(PersonnagePrincipal joueur, Monstre ennemi) {
		int x;
		x = (int) (Math.random() * 10);		//G�n�re de l'al�atoire entre 0 et 9
		if (x <= 1) {						//1/5 proba de contre-attaquer
			int dmg;
			dmg = ennemi.getHp();
			System.out.println("Vous arrivez � contre-attaquer en esquivant.");
			ennemi.setHp(ennemi.getHp() - (joueur.getStrength()));
			dmg -= ennemi.getHp();
			System.out.println("Vous avez inflig� " + dmg + " points de d�gats.");
		} else if (x <= 3) {				//1/5 proba d'�chouer l'esquive
			int dmg;
			dmg = joueur.getHp();
			System.out.println("Vous �chouez votre esquive.");
			joueur.setHp(joueur.getHp() - (ennemi.getStrength()) / 2);
			dmg -= - joueur.getHp();
			System.out.println("L'ennemi vous a inflig� " + dmg + " points de d�gats.");
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
