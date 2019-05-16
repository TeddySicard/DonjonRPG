package main;

import java.util.Scanner;

import combat.Combat;
import donjon.Donjon;
import donjon.Escalier;
import donjon.Porte;
import donjon.Salle;
import personnages.PersonnagePrincipal;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Main {
	public static Scanner nombre = new Scanner(System.in);
	public static Scanner caractere = new Scanner(System.in);
	public static PersonnagePrincipal joueur; // The player inside the dungeon
	public static Donjon donjon;


	public static void main(String[] args) throws InterruptedException {
		Utilitaire.setNbPartie(Utilitaire.getNbPartie() + 1);
		int actCode = Utilitaire
				.recupererInt("Avant de commencer, veuillez choisir la vitesse de lecture des dialogues\n1 pour lent "
						+ (Utilitaire.getVitessetxt() == 3 ? "(actuellement utilisé)" : "") + "\n2 pour moyen "
						+ (Utilitaire.getVitessetxt() == 2 ? "(actuellement utilisé)" : "") + "\n3 pour rapide "
						+ (Utilitaire.getVitessetxt() == 1 ? "(actuellement utilisé)" : "") + "\n4 pour instantané "
						+ (Utilitaire.getVitessetxt() == 0 ? "(actuellement utilisé)" : ""));
		while (actCode != 1 && actCode != 2 && actCode != 3 && actCode != 4) {
			Utilitaire.lettreParLettre("Saisie incorrecte, veuillez réessayer");
			actCode = Utilitaire.recupererInt(
					"Avant de commencer, veuillez choisir la vitesse de lecture des dialogues\n1 pour lent\n2 pour moyen (actuellement utilisé)\n3 pour rapide\n 4 pour instantané");
		}
		Utilitaire.setVitessetxt(4 - actCode);
		Utilitaire.sautDeLignes();
		int num = Utilitaire
				.yesNoQuestions("Quel donjon souhaitez vous lancer ?\n1 pour le donjon 1\n2 pour le donjon 2");

		donjon = new Donjon(num);
		joueur = new PersonnagePrincipal();
		Utilitaire.lettreParLettre("Bienvenue à vous dans le DONJON " + donjon.getNom() + " !!!");
		Utilitaire.lettreParLettre("Vous êtes enfermés dans un cachot du donjon, et votre but est de vous en échapper");
		Utilitaire.lettreParLettre(
				"Vous devrez pour cela affronter une horde de monstre et éviter les pièges sans vous perdre");
		Utilitaire.lettreParLettre(
				"Nous vous conseillons de vous armer d'une feuille et d'un crayon de bois afin de pouvoir tracer la carte des lieux");
		demarrer(donjon);
		nombre.close();
		caractere.close();

	}

	public static void demarrer(Donjon donjon) throws InterruptedException {
		entrerSalle(donjon.getSalles()[donjon.getCoordX()][donjon.getCoordY()][donjon.getCoordZ()]);// Gets the
																											// contact
		// informations
		// of the starting room
	}

	/**
	 * Allows game's action to chain up when you're entering in a room
	 * 
	 * @param donjon is the dungeon you are playing in
	 * @param salle is the room you are entering in
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void entrerSalle(Salle salle) throws InterruptedException {
		boolean isHere = true; // Checks the player's presence in the room
		int actCode;
		if (salle.isVictoire()) { // Check if the room is the winning room
			Utilitaire.lettreParLettre("\n\n\n\n\n111111	   111111          1       1       1       1111\r\n"
					+ "1     1	   1     1       1   1     1       1     1      1\r\n"
					+ "1      1   1      1     1     1    1       1   1          1\r\n"
					+ "1     1	   1     1     1       1   1       1  1            1\r\n"
					+ "111111     111111      111111111   1       1  1            1\r\n"
					+ "1     1	   1    1      1       1   1       1  1            1\r\n"
					+ "1      1   1     1     1       1    1     1    1          1\r\n"
					+ "1     1    1      1    1       1     1   1       1      1\r\n"
					+ "111111     1       1   1       1       1           1111");
			Thread.sleep(1000 * Utilitaire.getVitessetxt());
			Utilitaire.lettreParLettre("\n\n\n\n\nVous êtes sorti du donjon...");
			Utilitaire.lettreParLettre("Vous avez gagné");
			Utilitaire.rejouerDemande();
		}
		if (salle.getPiege() != null) {// Checks if a trap is in the room
			Utilitaire.lettreParLettre("La porte contenait un mécanisme vous tirant des flèches dessus");
			salle.getPiege().triggerTrap(joueur);
			Utilitaire.lettreParLettre("Vous retournez dans la salle précédente");
			Thread.sleep(600 * Utilitaire.getVitessetxt());
			donjon.changerSalle(salle, salle.getPortes().get(0));// Get back to the last room
		}
		if (salle.getMonstre() != null) {// Checks if a monster is in the room
			Utilitaire.lettreParLettre(salle.getMonstre().crier());
			Utilitaire.lettreParLettre("Un " + salle.getMonstre().toString() + " se trouve dans la salle");
			Combat.combattre(joueur, salle.getMonstre());
			salle.setMonstre(null);// Delete the monster from the room
			Thread.sleep(600 * Utilitaire.getVitessetxt());
		}
		if (salle.getPnj() != null) {// Check if a support or a bandit is in the room
			actCode = Utilitaire.yesNoQuestions(
					"Dans la salle se trouve une personne mystérieuse, à l'air inquiétant, qui se propose de vous aider à vous échapper\nAcceptez-vous ?\n1 pour Oui\n2 pour Non");
			if (actCode == 1) {
				Utilitaire.lettreParLettre("Vous faites connaissance avec la personne mystérieuse");
				salle.getPnj().rencontrer(salle, joueur);
			} else {
				Utilitaire.lettreParLettre(
						"Vous refusez l'aide de la personne mystérieuse, contrariée, elle s'en va\n\n");
			}
			salle.setPnj(null); // Remove the PNJ from the room
			Thread.sleep(600 * Utilitaire.getVitessetxt());
		}
		if (salle.getCoffre() != null) {// Checks if a chest is in the room
			actCode = Utilitaire.yesNoQuestions("Dans la salle se trouve un coffre "
					+ (salle.getCoffre().isLocked() ? "Verrouillé" : "") + "\nSouhaitez-vous "
					+ (salle.getCoffre().isLocked() ? "le déverrouiller" : "l'ouvrir") + " ?\n1 pour "
					+ (salle.getCoffre().isLocked() ? "le déverrouiller" : "l'ouvrir") + "\n2 pour le laisser"); // Displays
																													// the
																													// question
																													// depending
																													// of
																													// the
																													// chest's
																													// state
																													// (unlocked
																													// or
																													// locked)

			if (actCode == 1) {
				joueur.open(salle.getCoffre());// Open/Try to open the chest
			} else {
				Utilitaire.lettreParLettre(
						"Vous laissez le coffre " + (salle.getCoffre().isLocked() ? "verrouillé" : "fermé")); // Displays
																												// the
																												// text
																												// depending
																												// of
																												// the
																												// chest's
																												// state
																												// (unlocked
																												// or
																												// locked)
			}
			Thread.sleep(600 * Utilitaire.getVitessetxt());
		}
		do { // Displays this text while the player is in the room
			StringBuilder str = new StringBuilder("\nDans la salle se trouve :");
			for (Porte porte : salle.getPortes()) { // This will test all the doors
				if (porte != null) // Checks if the door exists
					str.append("\nUne " + porte.toString()); // Displays the presence of the room
			}
			for (Escalier escalier : salle.getEscaliers()) { // This will test all the stairs
				if (escalier != null)// Checks if the stairs exists
					str.append("\nUn " + escalier.toString());// Displays the presence of the stairs
			}
			str.append("\n\nQue souhaitez-vous faire ?\n");
			for (Porte porte : salle.getPortes()) { // This will test all the doors
				if (porte != null) { // Checks if the door exists
					str.append("\n" + porte.getDirection() + " pour "
							+ (porte.getCat() == 0 ? "emprunter la " : "déverrouiller la ") + porte.toString()); // Displays
																													// the
																													// text
																													// depending
																													// of
																													// the
																													// room's
																													// state
																													// (unlocked
																													// or
																													// locked)
				}
			}
			for (Escalier escalier : salle.getEscaliers()) { // This will test all the stairs
				if (escalier != null) // Checks if the stairs exists
					str.append("\n" + (escalier.getDirection() + 4) + " pour emprunter l'" + escalier.toString());

			}
			str.append("\n7 pour examiner la pièce");
			actCode = Utilitaire.recupererInt(str.toString());
			Utilitaire.sautDeLignes();
			while (actCode != 1 && actCode != 2 && actCode != 3 && actCode != 4 && actCode != 5 && actCode != 6
					&& actCode != 7) { // Checks the entered input is possible
				Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");
				actCode = Utilitaire.recupererInt(str.toString());
				Utilitaire.sautDeLignes();
			}
			if (actCode == 1 || actCode == 2 || actCode == 3 || actCode == 4)
				testPorte(actCode, salle, isHere);
			else if (actCode == 5 || actCode == 6)
				testEscalier(actCode, salle, isHere);
			else
				exam(salle);
			Thread.sleep(600 * Utilitaire.getVitessetxt()); // Makes a small pause between the moment the text from the
															// input is displayed and the text of the do/while loop is
		} while (isHere);
	}
	
	/**
	 * Allows to check what type of object if inside of the room
	 * 
	 * @param salle is the room you are checking
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void exam(Salle salle) throws InterruptedException {
		if (salle.getObjSol() == null) // No object in the room
			Utilitaire.lettreParLettre("Vous ne trouvez rien d'intéressant dans la salle");
		else
			salle.getObjSol().trouverObjSol(salle, joueur);
	}
	
	/**
	 * Checks if a door exists in the room or not and try to use it
	 * 
	 * @param actCode is the door id you want to test
	 * @param salle   is the room where you want to test the door
	 * @param isHere  is to avoids errors by being on 2 rooms simultaneously
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void testPorte(int actCode, Salle salle, boolean isHere) throws InterruptedException {

		for (Porte portes : salle.getPortes()) { // Checks the door's presence
			if (portes != null) { // Avoid crash
				if (portes.getDirection() == actCode) { // If the door exists
					if (portes.getCat() != 0) { // If the door is locked
						donjon.changerSalle(salle, portes);
						if (portes.getCat() == 0) // If the door is correctly unlocked
							System.out.print("Vous pouvez maintenant l'emprunter\n");
					} else { // if the door is unlocked
						Utilitaire.lettreParLettre("Vous changez de salle");
						isHere = false;
						donjon.changerSalle(salle, portes);
					}
					return;
				}
			}
		}
		Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer."); // Displays if the door doesn't exist

	}

	/**
	 * Checks if stairs exists in the room or not and try to use it
	 * 
	 * @param actCode is the stairs id you want to test
	 * @param salle   is the room where you want to test the stairs
	 * @param isHere  is to avoids errors by being on 2 rooms simultaneously
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void testEscalier(int actCode, Salle salle, boolean isHere) throws InterruptedException {
		for (Escalier escalier : salle.getEscaliers()) { // Check the stairs's presence
			if (escalier != null) { // Avoid crash
				if (escalier.getDirection() == actCode - 4) { // If the stairs exists
					Utilitaire.lettreParLettre("Vous changez de salle");
					isHere = false;
					donjon.changerEtage(salle, escalier);
					return;
				}
			}
		}
		Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer."); // Displays if the stairs doesn't exist

	}
	
	/**
	 * Game over screen
	 * 
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void gameOver() throws InterruptedException {
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

}
