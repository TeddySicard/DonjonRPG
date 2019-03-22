package util;

import personnages.Personnage;

public class PointDeVie {
	
	public static int attaque(Personnage attaquant, Personnage receveur) {	//Attaque d'un personnage sur un autre retournant les dégats
		int dmg;
		dmg = receveur.getHp();
		receveur.setHp(receveur.getHp() - attaquant.getStrength());
		attaquant.coupCritique(receveur, attaquant.getCritique());
		dmg -= receveur.getHp();
		return dmg;
	}
	
	public static void overhealCheck (Personnage personnage) {	//Vérifie que le personnage ne se soigne pas plus que possible
		if (personnage.getHp() >= personnage.getMaxHp())	//Si ses PV sont supérieurs à ses PV max
			personnage.setHp(personnage.getMaxHp());	// PV = PV max
	}

}
