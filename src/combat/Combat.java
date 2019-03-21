package combat;


import personnages.Monstre;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

public class Combat {

	public static void combattre(PersonnagePrincipal joueur, Monstre ennemi) throws InterruptedException {
		int actCode;
		System.out.println("\nCombat enclench� contre un " + ennemi.toString() + " !!!");
		while (!joueur.isKO() && !ennemi.isKO()) {
			actCode = Utilitaire.yesNoQuestions("Que voulez vous faire ?\n1 pour attaquer\n2 pour esquiver");
			if (actCode == 1) {
				joueur.useSkill(ennemi);
				if (!ennemi.isKO()) 
					ennemi.useSkill(joueur);
				if (!joueur.isAlone()) 
					joueur.getMateFollow().useSkill(joueur);
				Combat.affPV(joueur, ennemi);
			} else {
				Combat.esquive(joueur, ennemi);
				Combat.affPV(joueur, ennemi);
			}
		}
		System.out.println("\nCombat termin� !!");
		if (joueur.isKO()) {
			joueur.gameOver();
		}
		else {
			System.out.println("Vous avez tu� le "+ennemi.toString()+"\n\n\n");
			ennemi = null;
		}
	}

	public static void esquive(PersonnagePrincipal joueur, Monstre ennemi) {
		int x;
		x = (int) (Math.random() * 10);
		if (x <= 1) {
			int dmg;
			dmg = ennemi.getHp();
			System.out.println("Vous arrivez � contre-attaquer en esquivant.");
			ennemi.setHp(ennemi.getHp() - (joueur.getStrength()));
			dmg = dmg - ennemi.getHp();
			System.out.println("Vous avez inflig� " + dmg + " points de d�gats.");
		} else if (x <= 3) {
			int dmg;
			dmg = joueur.getHp();
			System.out.println("Vous �chouez votre esquive.");
			joueur.setHp(joueur.getHp() - (ennemi.getStrength()) / 2);
			dmg = dmg - joueur.getHp();
			System.out.println("L'ennemi vous a inflig� " + dmg + " points de d�gats.");
		} else {
			System.out.println("Vous esquivez l'attaque ennemi.");
		}
	}
	public static void affPV(PersonnagePrincipal joueur, Monstre ennemi) {
		if (joueur.isAlone()) {
			System.out.println("PV Joueur = " + joueur.getHp() + "\nPV " + ennemi.toString() + " = "
					+ ennemi.getHp());
		}
		else {
			System.out.println("PV Joueur = " + joueur.getHp() + "\nPV Laya = " + joueur.getMateFollow().getHp()
					+ "\nPV " + ennemi.toString() + " = " + ennemi.getHp());
		}
	}
}
