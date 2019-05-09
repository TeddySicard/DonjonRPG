package util;

import java.util.InputMismatchException;

import main.Main;

/**
 * 
 * @author Ted
 *
 */
public class Utilitaire {
	private static int vitessetxt;
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

	public static void affiche(String txt) throws InterruptedException { // Affiche le texte apr�s un d�lai
		Utilitaire.lettreParLettre(txt);
		Thread.sleep(750);
	}

	public static int yesNoQuestions(String question) throws InterruptedException { // G�n�re des questions � 2 r�ponses
																					// possible et retourne la r�ponse
		int actCode;
		actCode = Utilitaire.recupererInt(question);
		Utilitaire.sautDeLignes();
		while (actCode != 1 && actCode != 2) { // Tant que la r�ponse ne correspond pas aux possibilit�s
			Utilitaire.lettreParLettre("Saisie invalide, veuillez r�essayer.");
			actCode = Utilitaire.recupererInt(question);
			Utilitaire.sautDeLignes();
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
				Utilitaire.sautDeLignes();
				Utilitaire.lettreParLettre("Saisie invalide, veuillez r�essayer.");
				erreur = true;
				Main.nombre.next();
			}
		} while (erreur);
		return actCode;
	}

	public static void lettreParLettre(String txt) throws InterruptedException {
		int longueur = txt.length();
		for (int i = 0; i < longueur; i++) {
			System.out.print(txt.charAt(i));
			if (txt.charAt(i) == '\n')
				Thread.sleep(70 * vitessetxt);
			else
				Thread.sleep(5 * vitessetxt);
		}
		Thread.sleep(70 * vitessetxt);
		System.out.println();
	}
	
	public static void rejouerDemande() throws InterruptedException {
		int ans = Utilitaire.yesNoQuestions("Partie n�" + Utilitaire.getNbPartie() + " finie.\nVoulez-vous rejouer ?\n1 pour oui\n2 pour non");
			if (ans == 1)
				Main.main(null);
			else
				System.exit(0);
	}
	
	public static void sautDeLignes() {
		System.out.println("\n\n\n\n\n\n\n");

	}

}
