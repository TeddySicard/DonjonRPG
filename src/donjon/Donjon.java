package donjon;

import armes.Arme;
import armes.Dague;
import armes.DoubleLame;
import armes.Sabre;
import armes.SabreLaser;
import combat.Combat;
import objets.AtkPot;
import objets.Enigme;
import objets.HPGainPot;
import objets.HealingPot;
import objets.Key;
import objets.Potion;
import personnages.Bandit;
import personnages.BossFinal;
import personnages.Golem;
import personnages.Monstre;
import personnages.PNJ;
import personnages.PersonnagePrincipal;
import personnages.Sorcier;
import personnages.Support;
import personnages.Zombie;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Donjon {
	private String nom; // The name of the dungeon
	private int num; // The number of the dungeon
	private PersonnagePrincipal joueur; // The player inside the dungeon
	private Salle[][][] salles; // Matrix where the dungeon will be stored (3 dimensions)
	private int coordX;// Contact informations
	private int coordY;// of the starting room
	private int coordZ;// initialized on dungeon generation

	/**
	 * Dungeon constructor
	 * 
	 * @param num is to get the dungeon id in order to create the dungeon asked
	 */
	public Donjon(int num) {
		this.salles = new Salle[20][20][5]; // Memory allocation (No dungeon is that big)
		this.setNum(num);
		switch (num) { // Depending of the dungeon chosen
		case 1:
			this.setNom("DORLYS");
			break;
		case 2:
			this.setNom("KONTIN");
			break;
		}
		this.joueur = new PersonnagePrincipal();// Create the player while creating the dungeon
		this.generer();
	}

///////////////////////////Getters && Setters//////////////////////////////////
	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public int getCoordZ() {
		return coordZ;
	}

	public void setCoordZ(int coordZ) {
		this.coordZ = coordZ;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// DUNGEON//

	/**
	 * Generates the dungeon following the dungeon id given in the constructor's
	 * parameter
	 */
	@SuppressWarnings("unused") // Some objects are put in a room when they're created, generating a warning
								// despite of it
	public void generer() {
		switch (this.getNum()) {
		case 1:
			// GENERATING KEYS//
			Key cle250 = new Key(1);
			Key cle340 = new Key(2);
			Key cle5170 = new Key(2);
			Key cle6140 = new Key(1);
			Key cle8110 = new Key(2);
			Key cle1170 = new Key(2);
			// GENERATING POTIONS//
			Potion healPot330 = new HealingPot();
			Potion atkPot330 = new AtkPot();
			Potion hpGainPot4160 = new HPGainPot();
			Potion hpGainPot570 = new HPGainPot();
			Potion healPot650 = new HealingPot();
			Potion atkPot780 = new AtkPot();
			Potion healPot7110 = new HealingPot();
			Potion atkPot7130 = new AtkPot();
			Potion healPot1070 = new HealingPot();
			// GENERATING WEAPONS//
			Arme dague4140 = new Dague();
			Arme sabreLaser590 = new SabreLaser();
			Arme doubleLame9140 = new DoubleLame();
			Arme sabre1170 = new Sabre();
			// GENERATING ENIGMAS//
			Enigme enigme870 = new Enigme(1);
			// GENERATING DOORS//
			Porte porteNord = new Porte(1);
			Porte porteSud = new Porte(2);
			Porte porteEst = new Porte(3);
			Porte porteOuest = new Porte(4);
			Porte lockOuest330 = new Porte(4, 2);
			Porte lockOuest760 = new Porte(4, 2);
			Porte lockNorth8110 = new Porte(1, 2);
			Porte lockOuest7110 = new Porte(4, 2);
			Porte lockSouthEn870 = new Porte(2, enigme870);
			// GENERATING ROOMS//
			Salle salle150 = new Salle(0, 4, 0, porteSud);
			Salle salle250 = new Salle(1, 4, 0, porteNord, porteSud, cle250);
			Salle salle310 = new Salle(2, 0, 0, true);
			Salle salle320 = new Salle(2, 1, 0, porteEst, porteOuest);
			Salle salle330 = new Salle(2, 2, 0, porteEst, lockOuest330, atkPot330);
			Salle salle340 = new Salle(2, 3, 0, porteEst, porteOuest, cle340);
			Salle salle350 = new Salle(2, 4, 0, porteNord, porteSud, porteOuest);
			Salle salle3160 = new Salle(2, 15, 0, porteSud);
			Salle salle450 = new Salle(3, 4, 0, porteNord, porteSud);
			Salle salle4140 = new Salle(3, 13, 0, porteSud, porteEst);
			Salle salle4150 = new Salle(3, 14, 0, porteEst, porteOuest);
			Salle salle4160 = new Salle(3, 15, 0, porteNord, porteEst, porteOuest, hpGainPot4160);
			Salle salle4170 = new Salle(3, 16, 0, porteSud, porteEst, porteOuest);
			Salle salle4180 = new Salle(3, 17, 0, porteOuest);
			Salle salle550 = new Salle(4, 4, 0, porteNord, porteSud, porteEst);
			Salle salle560 = new Salle(4, 5, 0, porteEst, porteOuest);
			Salle salle570 = new Salle(4, 6, 0, porteEst, porteOuest, hpGainPot570);
			Salle salle580 = new Salle(4, 7, 0, porteEst, porteOuest);
			Salle salle590 = new Salle(4, 8, 0, porteOuest);
			Salle salle5140 = new Salle(4, 13, 0, porteNord, porteSud);
			Salle salle5170 = new Salle(4, 16, 0, porteNord);
			Salle salle650 = new Salle(5, 4, 0, porteNord, porteSud, healPot650);
			Salle salle6140 = new Salle(5, 13, 0, porteNord, porteSud);
			Salle salle750 = new Salle(6, 4, 0, porteNord, porteEst);
			Salle salle760 = new Salle(6, 5, 0, porteEst, lockOuest760);
			Salle salle770 = new Salle(6, 6, 0, porteSud, porteEst, porteOuest);
			Salle salle780 = new Salle(6, 7, 0, porteEst, porteOuest, atkPot780);
			Salle salle790 = new Salle(6, 8, 0, porteEst, porteOuest);
			Salle salle7100 = new Salle(6, 9, 0, porteEst, porteOuest);
			Salle salle7110 = new Salle(6, 10, 0, porteSud, porteEst, lockOuest7110, healPot7110);
			Salle salle7120 = new Salle(6, 11, 0, porteEst, porteOuest);
			Salle salle7130 = new Salle(6, 12, 0, porteEst, porteOuest, atkPot7130);
			Salle salle7140 = new Salle(6, 13, 0, porteNord, porteSud, porteOuest);
			Salle salle870 = new Salle(7, 6, 0, porteNord, lockSouthEn870);
			Salle salle8110 = new Salle(true, 7, 10, 0, lockNorth8110, cle8110);
			Salle salle8140 = new Salle(7, 13, 0, porteNord, porteSud);
			Salle salle970 = new Salle(8, 6, 0, porteNord, porteSud);
			Salle salle9140 = new Salle(8, 13, 0, porteNord, porteSud, doubleLame9140);
			Salle salle1070 = new Salle(9, 6, 0, porteNord, porteSud, healPot1070);
			Salle salle10140 = new Salle(9, 13, 0, porteNord, porteSud);
			Salle salle1170 = new Salle(10, 6, 0, porteNord, sabre1170);
			Salle salle11140 = new Salle(10, 13, 0, porteNord);
			// GENERATING TRAPS//
			Piege trap150 = new Piege(salle150);
			Piege trap3160 = new Piege(salle3160);
			Piege trap450 = new Piege();
			Piege trap4180 = new Piege(salle4180);
			Piege trap5140 = new Piege();
			Piege trap790 = new Piege();
			// GENERATING CHESTS//
			Chest coffre330 = new Chest(healPot330, salle330);
			Chest coffre450 = new Chest(trap450, salle450);
			Chest coffre4140 = new Chest(dague4140, salle4140);
			Chest coffre590 = new Chest(sabreLaser590, 1, salle590);
			Chest coffre5140 = new Chest(trap5140, salle5140);
			Chest coffre5170 = new Chest(cle5170, 1, salle5170);
			Chest coffre6140 = new Chest(cle6140, salle6140);
			Chest coffre790 = new Chest(trap790, salle790);
			Chest coffre1170 = new Chest(cle1170, salle1170);
			// GENERATING MONSTERS//
			Monstre bossFinal320 = new BossFinal(salle320);
			Monstre zombie330 = new Zombie(salle330);
			Monstre golem350 = new Golem(salle350);
			Monstre sorcier4150 = new Sorcier(salle4150);
			Monstre zombie4160 = new Zombie(salle4160);
			Monstre sorcier560 = new Sorcier(salle560);
			Monstre zombie570 = new Zombie(salle570);
			Monstre golem580 = new Golem(salle580);
			Monstre zombie750 = new Zombie(salle750);
			Monstre zombie780 = new Zombie(salle780);
			Monstre golem7100 = new Golem(salle7100);
			Monstre zombie7110 = new Zombie(salle7110);
			Monstre sorcier8140 = new Sorcier(salle8140);
			Monstre sorcier970 = new Sorcier(salle970);
			Monstre zombie10140 = new Zombie(salle10140);
			// GENERATING SUPPORT && BANDITS//
			PNJ bandit760 = new Bandit(salle760);
			PNJ laya11140 = new Support(salle11140);
			//// IMPLEMENTING ROOMS IN THE MATRIX//
			this.ajouterSalle(salle150);
			this.ajouterSalle(salle250);
			this.ajouterSalle(salle310);
			this.ajouterSalle(salle320);
			this.ajouterSalle(salle330);
			this.ajouterSalle(salle340);
			this.ajouterSalle(salle350);
			this.ajouterSalle(salle3160);
			this.ajouterSalle(salle450);
			this.ajouterSalle(salle4140);
			this.ajouterSalle(salle4150);
			this.ajouterSalle(salle4160);
			this.ajouterSalle(salle4170);
			this.ajouterSalle(salle4180);
			this.ajouterSalle(salle550);
			this.ajouterSalle(salle560);
			this.ajouterSalle(salle570);
			this.ajouterSalle(salle580);
			this.ajouterSalle(salle590);
			this.ajouterSalle(salle5140);
			this.ajouterSalle(salle5170);
			this.ajouterSalle(salle650);
			this.ajouterSalle(salle6140);
			this.ajouterSalle(salle750);
			this.ajouterSalle(salle760);
			this.ajouterSalle(salle770);
			this.ajouterSalle(salle780);
			this.ajouterSalle(salle790);
			this.ajouterSalle(salle7100);
			this.ajouterSalle(salle7110);
			this.ajouterSalle(salle7120);
			this.ajouterSalle(salle7130);
			this.ajouterSalle(salle7140);
			this.ajouterSalle(salle870);
			this.ajouterSalle(salle8110);
			this.ajouterSalle(salle8140);
			this.ajouterSalle(salle970);
			this.ajouterSalle(salle9140);
			this.ajouterSalle(salle1070);
			this.ajouterSalle(salle10140);
			this.ajouterSalle(salle1170);
			this.ajouterSalle(salle11140);
			break;
		case 2:
			////// GENERATING KEYS////
			Key cle390 = new Key(1);
			Key cle640 = new Key(2);
			Key cle531 = new Key(1);
			Key cle741 = new Key(2);
			Key cle761 = new Key(2);
			Key cle7101 = new Key(1);
			///// GENERATING POTIONS////
			Potion healPot340 = new HealingPot();
			Potion atkPot440 = new AtkPot();
			Potion healPot480 = new HealingPot();
			Potion atkPot520 = new AtkPot();
			Potion healPot550 = new HealingPot();
			Potion hpGainPot560 = new HPGainPot();
			Potion healPot631 = new HealingPot();
			Potion hpGainPot791 = new HPGainPot();
			////////// GENERATING WEAPONS///////////
			Arme sabreLaser340 = new SabreLaser();
			Arme dague570 = new Dague();
			Arme doubleLame531 = new DoubleLame();
			Arme sabre781 = new Sabre();

			////////// GENERATING ENIGMAS////////////
			Enigme enigme751 = new Enigme(2);
			// GENERATING DOORS-STAIRS//
			porteNord = new Porte(1);
			porteSud = new Porte(2);
			porteEst = new Porte(3);
			porteOuest = new Porte(4);
			Escalier escalierMontant = new Escalier(1);
			Escalier escalierDescendant = new Escalier(2);
			Porte lockNorth440 = new Porte(1, 2);
			Porte lockNorth540 = new Porte(1, 2);
			Porte lockNorth640 = new Porte(1, 2);
			Porte lockEast751 = new Porte(3, enigme751);
			////////// GENERATING ROOMS/////////////
			Salle salle140 = new Salle(0, 3, 0, true);
			Salle salle240 = new Salle(1, 3, 0, porteNord, porteSud);
			salle340 = new Salle(2, 3, 0, porteNord, porteSud, sabreLaser340);
			Salle salle370 = new Salle(2, 6, 0, porteSud);
			Salle salle390 = new Salle(2, 8, 0, escalierMontant, cle390);
			Salle salle440 = new Salle(3, 3, 0, lockNorth440, porteSud, atkPot440);
			Salle salle470 = new Salle(3, 6, 0, porteNord, porteSud, porteEst);
			Salle salle480 = new Salle(3, 7, 0, porteOuest, escalierMontant, healPot480);
			Salle salle510 = new Salle(4, 0, 0, porteSud, porteEst);
			Salle salle520 = new Salle(4, 1, 0, porteEst, porteOuest, atkPot520);
			Salle salle530 = new Salle(4, 2, 0, porteEst, porteOuest);
			Salle salle540 = new Salle(4, 3, 0, lockNorth540, porteSud, porteEst, porteOuest);
			salle550 = new Salle(4, 4, 0, porteEst, porteOuest, healPot550);
			salle560 = new Salle(4, 5, 0, porteEst, porteOuest, hpGainPot560);
			salle570 = new Salle(4, 6, 0, porteNord, porteOuest);
			Salle salle610 = new Salle(5, 0, 0, porteNord, porteSud);
			Salle salle640 = new Salle(true, 5, 3, 0, lockNorth640, cle640);
			Salle salle710 = new Salle(6, 0, 0, porteNord, escalierMontant);
			Salle salle281 = new Salle(1, 7, 1, porteSud);
			Salle salle381 = new Salle(2, 7, 1, porteNord, porteSud, porteEst);
			Salle salle391 = new Salle(2, 8, 1, porteOuest, escalierDescendant);
			Salle salle431 = new Salle(3, 2, 1, porteSud);
			Salle salle481 = new Salle(3, 7, 1, porteNord, porteSud, escalierDescendant);
			Salle salle531 = new Salle(4, 2, 1, porteNord, porteSud, doubleLame531);
			Salle salle581 = new Salle(4, 7, 1, porteNord, porteSud);
			Salle salle631 = new Salle(5, 2, 1, porteNord, porteSud, healPot631);
			Salle salle681 = new Salle(5, 7, 1, porteNord, porteSud);
			Salle salle711 = new Salle(6, 0, 1, porteEst, escalierDescendant);
			Salle salle721 = new Salle(6, 1, 1, porteEst, porteOuest);
			Salle salle731 = new Salle(6, 2, 1, porteNord, porteEst, porteOuest);
			Salle salle741 = new Salle(6, 3, 1, porteEst, porteOuest);
			Salle salle751 = new Salle(6, 4, 1, lockEast751, porteOuest);
			Salle salle761 = new Salle(6, 5, 1, porteOuest);
			Salle salle781 = new Salle(6, 7, 1, porteNord, porteEst);
			Salle salle791 = new Salle(6, 8, 1, porteEst, porteOuest, hpGainPot791);
			Salle salle7101 = new Salle(6, 9, 1, porteOuest);
			////////// GENERATING TRAPS/////////////
			Piege trap281 = new Piege();
			Piege trap370 = new Piege(salle370);
			Piege trap431 = new Piege(salle431);
			Piege trap510 = new Piege();
			////////// GENERATING CHESTS////////////
			Chest coffre340 = new Chest(healPot340, salle340);
			Chest coffre510 = new Chest(trap510, salle510);
			Chest coffre570 = new Chest(dague570, salle570);
			Chest coffre281 = new Chest(trap281, salle281);
			Chest coffre531 = new Chest(cle531, salle531);
			Chest coffre741 = new Chest(cle741, 1, salle741);
			Chest coffre761 = new Chest(cle761, 1, salle761);
			Chest coffre781 = new Chest(sabre781, 1, salle781);
			Chest coffre7101 = new Chest(cle7101, salle7101);
			////////// GENERATING MONSTERS////////////
			BossFinal bossFinal240 = new BossFinal(salle240);
			Sorcier sorcier340 = new Sorcier(salle340);
			Golem golem440 = new Golem(salle440);
			Zombie zombie510 = new Zombie(salle510);
			sorcier560 = new Sorcier(salle560);
			Zombie zombie531 = new Zombie(salle531);
			Sorcier sorcier581 = new Sorcier(salle581);
			Sorcier sorcier631 = new Sorcier(salle631);
			Zombie zombie781 = new Zombie(salle781);
			Golem golem791 = new Golem(salle791);
			////////// GENERATING SUPPORT && BANDITS/////////
			PNJ bandit390 = new Bandit(salle390);
			PNJ bandit530 = new Bandit(salle530);
			PNJ laya7101 = new Support(salle7101);
			//// IMPLEMENTING ROOMS IN THE MATRIX ////
			this.ajouterSalle(salle140);
			this.ajouterSalle(salle240);
			this.ajouterSalle(salle340);
			this.ajouterSalle(salle370);
			this.ajouterSalle(salle390);
			this.ajouterSalle(salle440);
			this.ajouterSalle(salle470);
			this.ajouterSalle(salle480);
			this.ajouterSalle(salle510);
			this.ajouterSalle(salle520);
			this.ajouterSalle(salle530);
			this.ajouterSalle(salle540);
			this.ajouterSalle(salle550);
			this.ajouterSalle(salle560);
			this.ajouterSalle(salle570);
			this.ajouterSalle(salle610);
			this.ajouterSalle(salle640);
			this.ajouterSalle(salle710);
			this.ajouterSalle(salle281);
			this.ajouterSalle(salle381);
			this.ajouterSalle(salle391);
			this.ajouterSalle(salle431);
			this.ajouterSalle(salle481);
			this.ajouterSalle(salle531);
			this.ajouterSalle(salle581);
			this.ajouterSalle(salle631);
			this.ajouterSalle(salle681);
			this.ajouterSalle(salle711);
			this.ajouterSalle(salle721);
			this.ajouterSalle(salle731);
			this.ajouterSalle(salle741);
			this.ajouterSalle(salle751);
			this.ajouterSalle(salle761);
			this.ajouterSalle(salle781);
			this.ajouterSalle(salle791);
			this.ajouterSalle(salle7101);

		}
	}

	public void demarrer() throws InterruptedException {
		this.entrerSalle(this.salles[this.getCoordX()][this.getCoordY()][this.getCoordZ()]);// Gets the contact
																							// informations
																							// of the starting room
	}

	/**
	 * Adds a room in the matrix
	 * 
	 * @param salle is the room you want to add
	 */
	public void ajouterSalle(Salle salle) {
		this.salles[salle.getX()][salle.getY()][salle.getZ()] = salle;// Add the rooms on the matrix following their
																		// contact informations
		if (salle.isDepart()) { // Catches the starting room's contact informations
			this.setCoordX(salle.getX());
			this.setCoordY(salle.getY());
			this.setCoordZ(salle.getZ());
		}
	}

	/**
	 * Allows game's action to chain up when you're entering in a room
	 * 
	 * @param salle is the room you are entering in
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void entrerSalle(Salle salle) throws InterruptedException {
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
			this.changerSalle(salle, salle.getPortes().get(0));// Get back to the last room
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
			if (salle.getCoffre().isLocked()) // Displays the question depending of the chest's state (unlocked or
												// locked)
				actCode = Utilitaire.yesNoQuestions(
						"Dans la salle se trouve un coffre verrouillé\nSouhaitez-vous le deverrouiller ?\n1 pour le déverrouiller\n2 pour le laisser");
			else
				actCode = Utilitaire.yesNoQuestions(
						"Dans la salle se trouve un coffre\nSouhaitez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
			if (actCode == 1) {
				joueur.open(salle.getCoffre());// Open/Try to open the chest
			} else {
				if (salle.getCoffre().isLocked()) // Displays the text depending of the chest's state (unlocked or
													// locked)
					Utilitaire.lettreParLettre("Vous laissez le coffre verrouillé");
				else
					Utilitaire.lettreParLettre("Vous laissez le coffre fermé");
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
					if (porte.getCat() == 0)// Displays the text depending of the room's state (unlocked or locked)
						str.append("\n" + porte.getDirection() + " pour emprunter la " + porte.toString());
					else
						str.append("\n" + porte.getDirection() + " pour déverrouiller la " + porte.toString());
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
				this.testPorte(actCode, salle, isHere);
			else if (actCode == 5 || actCode == 6)
				this.testEscalier(actCode, salle, isHere);
			else
				this.exam(salle);
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
	public void exam(Salle salle) throws InterruptedException {
		if (salle.getObjSol() == null) // No object in the room
			Utilitaire.lettreParLettre("Vous ne trouvez rien d'intéressant dans la salle");
		else
			salle.getObjSol().trouverObjSol(salle, joueur);
	}

	/**
	 * Allows the player to move from a room to another using a door
	 * 
	 * @param salle is the room where you are
	 * @param porte is the door you want to use
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void changerSalle(Salle salle, Porte porte) throws InterruptedException {
		switch (porte.getCat()) { // Checks the door's state (locked or unlocked)
		case 0: // Unlocked door
			switch (porte.getDirection()) {
			case 1:
				this.entrerSalle(this.salles[salle.getX() - 1][salle.getY()][salle.getZ()]);
				break;
			case 2:
				this.entrerSalle(this.salles[salle.getX() + 1][salle.getY()][salle.getZ()]);
				break;
			case 3:
				this.entrerSalle(this.salles[salle.getX()][salle.getY() + 1][salle.getZ()]);
				break;
			case 4:
				this.entrerSalle(this.salles[salle.getX()][salle.getY() - 1][salle.getZ()]);
				break;
			}
			break;
		case 2: // Door locked by a key
			joueur.unlock(porte);
			break;
		case 3: // Door locked by an enigma
			porte.unlock(porte.getEnigme());
			break;
		}

	}

	/**
	 * Allows the player to move from a room to another using stairs
	 * 
	 * @param salle is the room where you are
	 * @param escalier is the stairs you want to use
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void changerEtage(Salle salle, Escalier escalier) throws InterruptedException {
		if (escalier.getDirection() == 1)
			this.entrerSalle(this.salles[salle.getX()][salle.getY()][salle.getZ() + 1]);
		else
			this.entrerSalle(this.salles[salle.getX()][salle.getY()][salle.getZ() - 1]);

	}

	/**
	 * Checks if a door exists in the room or not and try to use it
	 * 
	 * @param actCode is the door id you want to test
	 * @param salle is the room where you want to test the door
	 * @param isHere is to avoids errors by being on 2 rooms simultaneously
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void testPorte(int actCode, Salle salle, boolean isHere) throws InterruptedException {
		
		for (Porte portes : salle.getPortes()) { // Checks the door's presence
			if (portes != null) { // Avoid crash
				if (portes.getDirection() == actCode) { // If the door exists
					if (portes.getCat() != 0) { // If the door is locked
						this.changerSalle(salle, portes);
						if (portes.getCat() == 0) // If the door is correctly unlocked
							System.out.print("Vous pouvez maintenant l'emprunter\n");
					} else { // if the door is unlocked
						Utilitaire.lettreParLettre("Vous changez de salle");
						isHere = false;
						this.changerSalle(salle, portes);
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
	 * @param salle is the room where you want to test the stairs
	 * @param isHere is to avoids errors by being on 2 rooms simultaneously
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void testEscalier(int actCode, Salle salle, boolean isHere) throws InterruptedException {
		for (Escalier escalier : salle.getEscaliers()) { // Check the stairs's presence
			if (escalier != null) { // Avoid crash
				if (escalier.getDirection() == actCode - 4) { // If the stairs exists
					Utilitaire.lettreParLettre("Vous changez de salle");
					isHere = false;
					this.changerEtage(salle, escalier);
					return;
				}
			}
		}
		Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer."); // Displays if the stairs doesn't exist

	}

}