package main;

import java.util.Scanner;

import donjon.Donjon;

public class Main {
	public static Scanner sc1 = new Scanner(System.in);
	public static Scanner sc2 = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		System.out.println(
				"Bienvenue � vous dans le DONJON DORLYS !!!");
		System.out.println("Vous �tes enferm�s dans un cachot du donjon, et votre but est de vous en �chapper");
		System.out
				.println("Vous devrez pour cela affronter une horde de monstre et �viter les pi�ges sans vous perdre");
		System.out.println(
				"Nous vous conseillons de vous armer d'une feuille et d'un crayon de bois afin de pouvoir tracer la carte des lieux");
		Donjon donjon = new Donjon();
		donjon.generer();
		donjon.demarrer();
		sc1.close();
		sc2.close();

	}

}
