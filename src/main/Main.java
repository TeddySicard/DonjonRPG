package main;

import java.util.Scanner;

import donjon.Donjon;

public class Main {
	public static Scanner sc1 = new Scanner(System.in);
	public static Scanner sc2 = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		System.out.println(
				"Bienvenue à vous dans le DONJON DORLYS !!!");
		System.out.println("Vous êtes enfermés dans un cachot du donjon, et votre but est de vous en échapper");
		System.out
				.println("Vous devrez pour cela affronter une horde de monstre et éviter les pièges sans vous perdre");
		System.out.println(
				"Nous vous conseillons de vous armer d'une feuille et d'un crayon de bois afin de pouvoir tracer la carte des lieux");
		Donjon donjon = new Donjon();
		donjon.generer();
		donjon.demarrer();
		sc1.close();
		sc2.close();

	}

}
