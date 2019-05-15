package main;

import java.util.Scanner;

import donjon.Donjon;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Main {
	public static Scanner nombre = new Scanner(System.in);
	public static Scanner caractere = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		Utilitaire.setNbPartie(Utilitaire.getNbPartie() + 1);
		Utilitaire.setVitessetxt(2);
		int actCode = Utilitaire.recupererInt(
				"Avant de commencer, veuillez choisir la vitesse de lecture des dialogues\n1 pour lent\n2 pour moyen (actuellement utilisé)\n3 pour rapide\n4 pour instantané");
		while (actCode != 1 && actCode != 2 && actCode != 3 && actCode != 4) {
			Utilitaire.lettreParLettre("Saisie incorrecte, veuillez réessayer");
			actCode = Utilitaire.recupererInt(
					"Avant de commencer, veuillez choisir la vitesse de lecture des dialogues\n1 pour lent\n2 pour moyen (actuellement utilisé)\n3 pour rapide\n 4 pour instantané");
		}
		Utilitaire.setVitessetxt(4 - actCode);
		Utilitaire.sautDeLignes();
		int num = Utilitaire
				.yesNoQuestions("Quel donjon souhaitez vous lancer ?\n1 pour le donjon 1\n2 pour le donjon 2");

		Donjon donjon = new Donjon(num);
		Utilitaire.lettreParLettre("Bienvenue à vous dans le DONJON " + donjon.getNom() + " !!!");
		Utilitaire.lettreParLettre("Vous êtes enfermés dans un cachot du donjon, et votre but est de vous en échapper");
		Utilitaire.lettreParLettre(
				"Vous devrez pour cela affronter une horde de monstre et éviter les pièges sans vous perdre");
		Utilitaire.lettreParLettre(
				"Nous vous conseillons de vous armer d'une feuille et d'un crayon de bois afin de pouvoir tracer la carte des lieux");
		donjon.demarrer();
		nombre.close();
		caractere.close();

	}

}
