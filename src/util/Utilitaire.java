package util;

import java.util.InputMismatchException;

import main.Main;

public class Utilitaire {

	public static void affiche(String txt) throws InterruptedException { // Affiche le texte après un délai
		System.out.println(txt);
		Thread.sleep(1000);
	}

	public static int yesNoQuestions(String question) throws InterruptedException { // Génère des questions à 2 réponses
																					// possible et retourne la réponse
		int actCode;
		actCode = Utilitaire.recupererInt(question);
		System.out.println("\n\n\n\n\n\n\n");
		while (actCode != 1 && actCode != 2) { // Tant que la réponse ne correspond pas aux possibilités
			System.out.println("Saisie invalide, veuillez réessayer.");
			actCode = Utilitaire.recupererInt(question);
			System.out.println("\n\n\n\n\n\n\n");
		}
		return actCode;
	}

	public static int recupererInt(String txt) throws InterruptedException { // Récupère un entier
		boolean erreur = false;
		int actCode = 0;
		do { // Répète la boucle tant qu'un entier n'est pas entré
			try { // S'assure qu'un entier est entré
				Utilitaire.affiche(txt);
				actCode = Main.nombre.nextInt();
				erreur = false;
			} catch (InputMismatchException e) { // Si un entier n'a pas été rentré
				System.out.println("\n\n\n\n\n\n\n");
				System.out.println("Saisie invalide, veuillez réessayer.");
				erreur = true;
				Main.nombre.next();
			}
		} while (erreur);
		return actCode;
	}
////////////////////////////////////////A continuer/////////////////////////////////////////////
	public static void lettreParLettre(String txt) {
		int longueur = txt.length();
		StringBuilder retour = new StringBuilder();
		for (int i = 0; i < longueur; i++) {
			System.out.print(txt.charAt(i));
		}
	}
}
