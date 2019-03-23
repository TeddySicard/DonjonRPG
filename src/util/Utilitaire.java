package util;

import java.util.InputMismatchException;

import main.Main;

public class Utilitaire {

	public static void affiche(String txt) throws InterruptedException { // Affiche le texte apr�s un d�lai
		System.out.println(txt);
		Thread.sleep(1000);
	}

	public static int yesNoQuestions(String question) throws InterruptedException { // G�n�re des questions � 2 r�ponses
																					// possible et retourne la r�ponse
		int actCode;
		actCode = Utilitaire.recupererInt(question);
		System.out.println("\n\n\n\n\n\n\n");
		while (actCode != 1 && actCode != 2) { // Tant que la r�ponse ne correspond pas aux possibilit�s
			System.out.println("Saisie invalide, veuillez r�essayer.");
			actCode = Utilitaire.recupererInt(question);
			System.out.println("\n\n\n\n\n\n\n");
		}
		return actCode;
	}

	public static int recupererInt(String txt) throws InterruptedException { // R�cup�re un entier
		boolean erreur = false;
		int actCode = 0;
		do { // R�p�te la boucle tant qu'un entier n'est pas entr�
			try { // S'assure qu'un entier est entr�
				Utilitaire.affiche(txt);
				actCode = Main.nombre.nextInt();
				erreur = false;
			} catch (InputMismatchException e) { // Si un entier n'a pas �t� rentr�
				System.out.println("\n\n\n\n\n\n\n");
				System.out.println("Saisie invalide, veuillez r�essayer.");
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
