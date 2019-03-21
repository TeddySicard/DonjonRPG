package test;

import donjon.Donjon;

public class Test_portes {

	public static void main(String[] args) throws InterruptedException {
		Donjon donjon = new Donjon();
		donjon.generer();
		donjon.entrerSalle(donjon.salles[7][6]);
	}

}
