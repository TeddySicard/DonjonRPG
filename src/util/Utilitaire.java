package util;

import java.util.InputMismatchException;

import main.Main;

public class Utilitaire {

	public static void affiche(String txt) throws InterruptedException {
		System.out.println(txt);
		Thread.sleep(1000);
	}

	public static int yesNoQuestions(String question) throws InterruptedException {
		int actCode;
		actCode = Utilitaire.recupererInt(question);
		System.out.println("\n\n\n\n\n\n\n");
		while (actCode != 1 && actCode != 2) {
			System.out.println("Saisie invalide, veuillez réessayer.");
			actCode = Utilitaire.recupererInt(question);
			System.out.println("\n\n\n\n\n\n\n");
		}
		return actCode;
	}

	public static int recupererInt(String txt) throws InterruptedException {
		boolean erreur = false;
		int actCode = 0;
		do {
			try {
				Utilitaire.affiche(txt);
				actCode = Main.nombre.nextInt();
				erreur = false;
			} catch (InputMismatchException e) {
				System.out.println("\n\n\n\n\n\n\n");
				System.out.println("Saisie invalide, veuillez réessayer.");
				erreur = true;
				Main.nombre.next();
			}
		} while (erreur);
		return actCode;
	}
}
