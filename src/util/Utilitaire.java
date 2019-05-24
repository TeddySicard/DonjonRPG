package util;

import java.util.InputMismatchException;

import main.Main;

/**
 * This class helps to manage several reccurent functions
 * 
 * @author Ted
 *
 */
public class Utilitaire {
	private static int vitessetxt = 2;
	private static int nbPartie = 0;

	public static int getVitessetxt() {
		return vitessetxt;
	}

	public static void setVitessetxt(int vitessetxt) {
		Utilitaire.vitessetxt = vitessetxt;
	}

	public static int getNbPartie() {
		return nbPartie;
	}

	public static void setNbPartie(int nbPartie) {
		Utilitaire.nbPartie = nbPartie;
	}

	/**
	 * This avoid the following text to be displayed right after the one entered in
	 * parameter if the player is spamming
	 * 
	 * @param txt is the text you want to display
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public static void affiche(String txt) throws InterruptedException {
		Utilitaire.lettreParLettre(txt);
		Thread.sleep(750);
	}

	/**
	 * Generates questions with 2 answers possible and treats the player's respond
	 * 
	 * @param question is the question asked
	 * @return the player's answer
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public static int yesNoQuestions(String question) throws InterruptedException {
		int actCode;
		actCode = Utilitaire.recupererInt(question);
		Utilitaire.sautDeLignes();
		while (actCode != 1 && actCode != 2) { // While the answer doesn't correspond to the possible answers
			Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");
			actCode = Utilitaire.recupererInt(question);
			Utilitaire.sautDeLignes();
		}
		return actCode;
	}

	/**
	 * Gets an int after a question (Avoid errors)
	 * 
	 * @param txt is the question the player will answer
	 * @return the int entered
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public static int recupererInt(String txt) throws InterruptedException {
		boolean erreur = false;
		int actCode = 0;
		do {
			try { // Treats errors
				Utilitaire.affiche(txt);
				actCode = Main.nombre.nextInt();
				erreur = false;
			} catch (InputMismatchException e) { // If an int isn't entered
				Utilitaire.sautDeLignes();
				Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");
				erreur = true;
				Main.nombre.next();
			}
		} while (erreur); // While an int isn't entered
		return actCode;
	}

	/**
	 * Displays the string character by character
	 * 
	 * @param txt is the string you want to display character by character
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public static void lettreParLettre(String txt) throws InterruptedException {
		int longueur = txt.length();
		for (int i = 0; i < longueur; i++) {
			System.out.print(txt.charAt(i));
			if (txt.charAt(i) == '\n') // Checks line breaks to display slower
				Thread.sleep(70 * vitessetxt);
			else
				Thread.sleep(5 * vitessetxt);
		}
		Thread.sleep(70 * vitessetxt); // Line break
		System.out.println();
	}

	/**
	 * Asks the player if he wants to replay
	 * @return true if he does false if he doesn't
	 * 
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception
	 */
	public static void rejouerDemande() throws InterruptedException {
		int ans = Utilitaire.yesNoQuestions(
				"Partie n°" + Utilitaire.getNbPartie() + " finie.\nVoulez-vous rejouer ?\n1 pour oui\n2 pour non");
		if (ans == 1)
			Main.main(null);
		else
			System.exit(0);
	}

	/**
	 * Makes a defined amount of line breaks
	 */
	public static void sautDeLignes() {
		System.out.println("\n\n\n\n\n\n\n");

	}

}
