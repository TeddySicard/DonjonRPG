package donjon;

import armes.Arme;
import armes.Dague;
import armes.DoubleLame;
import armes.Sabre;
import armes.SabreLaser;
import combat.Combat;
import objets.AtkPot;
import objets.Chest;
import objets.Enigme;
import objets.HPGainPot;
import objets.HealingPot;
import objets.Key;
import objets.Potion;
import personnages.Bandit;
import personnages.BossFinal;
import personnages.Golem;
import personnages.Monstre;
import personnages.PersonnagePrincipal;
import personnages.Sorcier;
import personnages.Support;
import personnages.Zombie;
import util.Utilitaire;

public class Donjon {
	private String nom;
	private int num;
	public PersonnagePrincipal joueur;
	public Salle[][][] salles; // Terrain dans lequel le donjon sera stocké (3 dimensions)
	private int coordX;// Coordonnées de la salle de départ qui sera initialisée lors de la génération
						// du donjon
	private int coordY;//
	private int coordZ;//

	public Donjon(int num) {
		this.salles = new Salle[20][20][5];
		this.setNum(num);
		switch (num) {
		case 1:
			this.setNom("DORLYS");
			break;
		case 2:
			this.setNom("AROUF");
		}
		this.joueur = new PersonnagePrincipal();// Créé le joueur en même temps que le terrain du donjon
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

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// DONJON//

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

	// GENERER DONJON//
	public void generer() {
		switch (this.getNum()) {
		case 1:
			// GENERATION DES CLES//
			Key cle250 = new Key(1);
			Key cle340 = new Key(2);
			Key cle5170 = new Key(2);
			Key cle6140 = new Key(1);
			Key cle8110 = new Key(2);
			Key cle1170 = new Key(2);
			// GENERATION DES POTIONS//
			Potion healPot330 = new HealingPot();
			Potion atkPot330 = new AtkPot();
			Potion hpGainPot4160 = new HPGainPot();
			Potion hpGainPot570 = new HPGainPot();
			Potion healPot650 = new HealingPot();
			Potion atkPot780 = new AtkPot();
			Potion healPot7110 = new HealingPot();
			Potion atkPot7130 = new AtkPot();
			Potion healPot1070 = new HealingPot();
			// GENERATION DES ARMES//
			Arme dague4140 = new Dague();
			Arme sabreLaser590 = new SabreLaser();
			Arme doubleLame9140 = new DoubleLame();
			Arme sabre1170 = new Sabre();
			// GENERATION DES PIEGES//
			Piege trap150 = new Piege();
			Piege trap3160 = new Piege();
			Piege trap450 = new Piege();
			Piege trap4180 = new Piege();
			Piege trap5140 = new Piege();
			Piege trap790 = new Piege();
			// GENERATION DE L'ENIGME//
			Enigme enigme870 = new Enigme(1);
			// GENERATION DES COFFRES//
			Chest coffre330 = new Chest(healPot330);
			Chest coffre450 = new Chest(trap450);
			Chest coffre4140 = new Chest(dague4140);
			Chest coffre590 = new Chest(sabreLaser590, 1);
			Chest coffre5140 = new Chest(trap5140);
			Chest coffre5170 = new Chest(cle5170, 1);
			Chest coffre6140 = new Chest(cle6140);
			Chest coffre790 = new Chest(trap790);
			Chest coffre1170 = new Chest(cle1170);
			// GENERATION DES PORTES//
			Porte porteNord = new Porte(1);
			Porte porteSud = new Porte(2);
			Porte porteEst = new Porte(3);
			Porte porteOuest = new Porte(4);
			Porte lockOuest330 = new Porte(4, 2);
			Porte lockOuest760 = new Porte(4, 2);
			Porte lockNorth8110 = new Porte(1, 2);
			Porte lockOuest7110 = new Porte(4, 2);
			Porte lockSouthEn870 = new Porte(2, enigme870);
			// GENERATION DES MONSTRES//
			Monstre bossFinal320 = new BossFinal();
			Monstre zombie330 = new Zombie();
			Monstre golem350 = new Golem();
			Monstre sorcier4150 = new Sorcier();
			Monstre zombie4160 = new Zombie();
			Monstre sorcier560 = new Sorcier();
			Monstre zombie570 = new Zombie();
			Monstre golem580 = new Golem();
			Monstre zombie750 = new Zombie();
			Monstre zombie780 = new Zombie();
			Monstre golem7100 = new Golem();
			Monstre zombie7110 = new Zombie();
			Monstre sorcier8140 = new Sorcier();
			Monstre sorcier970 = new Sorcier();
			Monstre zombie10140 = new Zombie();
			// GENERATION DU SUPPORT && BANDIT//
			Bandit bandit760 = new Bandit();
			Support laya11140 = new Support();
			// GENERATION DES SALLES//
			Salle salle150 = new Salle(0, 4, 0, porteSud, trap150);
			Salle salle250 = new Salle(1, 4, 0, porteNord, porteSud, cle250);
			Salle salle310 = new Salle(2, 0, 0, true);
			Salle salle320 = new Salle(2, 1, 0, porteEst, porteOuest, bossFinal320);
			Salle salle330 = new Salle(2, 2, 0, porteEst, lockOuest330, coffre330, zombie330, atkPot330);
			Salle salle340 = new Salle(2, 3, 0, porteEst, porteOuest, cle340);
			Salle salle350 = new Salle(2, 4, 0, porteNord, porteSud, porteOuest, golem350);
			Salle salle3160 = new Salle(2, 15, 0, porteSud, trap3160);
			Salle salle450 = new Salle(3, 4, 0, porteNord, porteSud, coffre450);
			Salle salle4140 = new Salle(3, 13, 0, porteSud, porteEst, coffre4140);
			Salle salle4150 = new Salle(3, 14, 0, porteEst, porteOuest, sorcier4150);
			Salle salle4160 = new Salle(3, 15, 0, porteNord, porteEst, porteOuest, zombie4160, hpGainPot4160);
			Salle salle4170 = new Salle(3, 16, 0, porteSud, porteEst, porteOuest);
			Salle salle4180 = new Salle(3, 17, 0, porteOuest, trap4180);
			Salle salle550 = new Salle(4, 4, 0, porteNord, porteSud, porteEst);
			Salle salle560 = new Salle(4, 5, 0, porteEst, porteOuest, sorcier560);
			Salle salle570 = new Salle(4, 6, 0, porteEst, porteOuest, zombie570, hpGainPot570);
			Salle salle580 = new Salle(4, 7, 0, porteEst, porteOuest, golem580);
			Salle salle590 = new Salle(4, 8, 0, porteOuest, coffre590);
			Salle salle5140 = new Salle(4, 13, 0, porteNord, porteSud, coffre5140);
			Salle salle5170 = new Salle(4, 16, 0, porteNord, coffre5170);
			Salle salle650 = new Salle(5, 4, 0, porteNord, porteSud, healPot650);
			Salle salle6140 = new Salle(5, 13, 0, porteNord, porteSud, coffre6140);
			Salle salle750 = new Salle(6, 4, 0, porteNord, porteEst, zombie750);
			Salle salle760 = new Salle(6, 5, 0, porteEst, lockOuest760);
			Salle salle770 = new Salle(6, 6, 0, porteSud, porteEst, porteOuest);
			Salle salle780 = new Salle(6, 7, 0, porteEst, porteOuest, zombie780, atkPot780);
			Salle salle790 = new Salle(6, 8, 0, porteEst, porteOuest, coffre790);
			Salle salle7100 = new Salle(6, 9, 0, porteEst, porteOuest, golem7100);
			Salle salle7110 = new Salle(6, 10, 0, porteSud, porteEst, lockOuest7110, zombie7110, healPot7110);
			Salle salle7120 = new Salle(6, 11, 0, porteEst, porteOuest);
			Salle salle7130 = new Salle(6, 12, 0, porteEst, porteOuest, atkPot7130);
			Salle salle7140 = new Salle(6, 13, 0, porteNord, porteSud, porteOuest);
			Salle salle870 = new Salle(7, 6, 0, porteNord, lockSouthEn870, bandit760);
			Salle salle8110 = new Salle(true, 7, 10, 0, lockNorth8110, cle8110);
			Salle salle8140 = new Salle(7, 13, 0, porteNord, porteSud, sorcier8140);
			Salle salle970 = new Salle(8, 6, 0, porteNord, porteSud, sorcier970);
			Salle salle9140 = new Salle(8, 13, 0, porteNord, porteSud, doubleLame9140);
			Salle salle1070 = new Salle(9, 6, 0, porteNord, porteSud, healPot1070);
			Salle salle10140 = new Salle(9, 13, 0, porteNord, porteSud, zombie10140);
			Salle salle1170 = new Salle(10, 6, 0, porteNord, coffre1170, sabre1170);
			Salle salle11140 = new Salle(10, 13, 0, porteNord, laya11140);
			//// IMPLEMENTATION DES SALLES DANS LA MATRICE//
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
			////// GENERATION DES CLES////
			Key cle390 = new Key(1);
			Key cle640 = new Key(2);
			Key cle381 = new Key(1);
			Key cle531 = new Key(1);
			Key cle741 = new Key(2);
			Key cle761 = new Key(2);
			Key cle7101 = new Key(1);
			///// GENERATION DES POTIONS////
			Potion healPot340 = new HealingPot();
			Potion atkPot440 = new AtkPot();
			Potion healPot480 = new HealingPot();
			Potion atkPot520 = new AtkPot();
			Potion healPot550 = new HealingPot();
			Potion hpGainPot560 = new HPGainPot();
			Potion healPot631 = new HealingPot();
			Potion hpGainPot791 = new HPGainPot();
			////////// GENERATION DES ARMES///////////
			Arme sabreLaser340 = new SabreLaser();
			Arme dague570 = new Dague();
			Arme doubleLame531 = new DoubleLame();
			Arme sabre781 = new Sabre();
			////////// GENERATION DES PIEGES/////////////
			Piege trap370 = new Piege();
			Piege trap510 = new Piege();
			Piege trap281 = new Piege();
			Piege trap431 = new Piege();
			////////// GENERATION DE L'ENIGME////////////
			Enigme enigme751 = new Enigme(2);
			////////// GENERATION DES COFFRES////////////
			Chest coffre340 = new Chest(healPot340);
			Chest coffre510 = new Chest(trap510);
			Chest coffre570 = new Chest(dague570);
			Chest coffre281 = new Chest(trap281);
			Chest coffre531 = new Chest(cle531);
			Chest coffre741 = new Chest(cle741, 1);
			Chest coffre761 = new Chest(cle761, 1);
			Chest coffre781 = new Chest(sabre781, 1);
			Chest coffre7101 = new Chest(cle7101);
			////////// GENERATION SUPPORT && BANDIT/////////
			Bandit bandit390 = new Bandit();
			Bandit bandit530 = new Bandit();
			Support laya7101 = new Support();
			// GENERATION DES PORTES/ESCALIERS//
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
			////////// GENERATION DES MONSTRES////////////
			BossFinal bossFinal240 = new BossFinal();
			Sorcier sorcier340 = new Sorcier();
			Golem golem440 = new Golem();
			Zombie zombie510 = new Zombie();
			sorcier560 = new Sorcier();
			Zombie zombie531 = new Zombie();
			Sorcier sorcier581 = new Sorcier();
			Sorcier sorcier631 = new Sorcier();
			Zombie zombie781 = new Zombie();
			Golem golem791 = new Golem();
			/////////// GENERATION DES SALLES/////////////
			Salle salle140 = new Salle(0, 3, 0, porteSud, true);
			Salle salle240 = new Salle(1, 3, 0, porteNord, porteSud, bossFinal240);
			salle340 = new Salle(2, 3, 0, porteNord, porteSud, coffre340, sorcier340, sabreLaser340);
			Salle salle370 = new Salle(2, 6, 0, porteSud, trap370);
			Salle salle390 = new Salle(2, 8, 0, escalierMontant, bandit390, cle390);
			Salle salle440 = new Salle(3, 3, 0, lockNorth440, porteSud, golem440, atkPot440);
			Salle salle470 = new Salle(3, 6, 0, porteSud, porteEst);
			Salle salle480 = new Salle(3, 7, 0, porteOuest, escalierMontant, healPot480);
			Salle salle510 = new Salle(4, 0, 0, porteSud, porteEst, coffre510, zombie510);
			Salle salle520 = new Salle(4, 1, 0, porteEst, porteOuest, atkPot520);
			Salle salle530 = new Salle(4, 2, 0, porteEst, porteOuest, bandit530);
			Salle salle540 = new Salle(4, 3, 0, lockNorth540, porteSud, porteEst, porteOuest);
			salle550 = new Salle(4, 4, 0, porteEst, porteOuest, healPot550);
			salle560 = new Salle(4, 5, 0, porteEst, porteOuest, sorcier560, hpGainPot560);
			salle570 = new Salle(4, 6, 0, porteNord, porteOuest, coffre570);
			Salle salle610 = new Salle(5, 0, 0, porteNord, porteSud);
			Salle salle640 = new Salle(true, 5, 3, 0, lockNorth640, cle640);
			Salle salle710 = new Salle(6, 0, 0, porteNord, escalierMontant);
			Salle salle281 = new Salle(1, 7, 1, porteSud, coffre281);
			Salle salle381 = new Salle(2, 7, 1, porteNord, porteSud, porteEst, cle381);
			Salle salle391 = new Salle(2, 8, 1, porteOuest, escalierDescendant);
			Salle salle431 = new Salle(3, 2, 1, porteSud, trap431);
			Salle salle481 = new Salle(3, 7, 1, porteNord, porteSud, escalierDescendant);
			Salle salle531 = new Salle(4, 2, 1, porteNord, porteSud, coffre531, zombie531, doubleLame531);
			Salle salle581 = new Salle(4, 7, 1, porteNord, porteSud, sorcier581);
			Salle salle631 = new Salle(5, 2, 1, porteNord, porteSud, sorcier631, healPot631);
			Salle salle681 = new Salle(5, 7, 1, porteNord, porteSud);
			Salle salle711 = new Salle(6, 0, 1, porteEst, escalierDescendant);
			Salle salle721 = new Salle(6, 1, 1, porteEst, porteOuest);
			Salle salle731 = new Salle(6, 2, 1, porteNord, porteEst, porteOuest);
			Salle salle741 = new Salle(6, 3, 1, porteEst, porteOuest, coffre741);
			Salle salle751 = new Salle(6, 4, 1, lockEast751, porteOuest);
			Salle salle761 = new Salle(6, 5, 1, porteOuest, coffre761);
			Salle salle781 = new Salle(6, 7, 1, porteNord, porteEst, coffre781, zombie781);
			Salle salle791 = new Salle(6, 8, 1, porteEst, porteOuest, golem791, hpGainPot791);
			Salle salle7101 = new Salle(6, 9, 1, porteOuest, coffre7101, laya7101);
			//// IMPLEMENTATION DES SALLES DANS LA MATRICE//
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
		this.entrerSalle(this.salles[this.getCoordX()][this.getCoordY()][this.getCoordZ()]);// Récupère les coordonnées
																							// de la salle de
		// départ
	}

	public void ajouterSalle(Salle salle) {
		this.salles[salle.getX()][salle.getY()][salle.getZ()] = salle;// Permet d'ajouter les salles sur le terrain
																		// selon ses
		// coordonnées
		if (salle.isDepart()) { // Permet d'initialiser les coordonnées de départ
			this.setCoordX(salle.getX());
			this.setCoordY(salle.getY());
			this.setCoordZ(salle.getZ());
		}
	}

	public void entrerSalle(Salle salle) throws InterruptedException {// Permet d'enchaîner les actions du jeu, du
																		// départ jusqu'à la victoire/Game over
		boolean isHere = true; // Permet de vérifier que le joueur est toujours présent dans la salle
		int actCode;
		if (salle.isVictoire()) { // Regarde si la salle est la salle de victoire
			Utilitaire.lettreParLettre("Vous êtes sorti du donjon...");
			Utilitaire.lettreParLettre("Vous avez gagné");
			System.exit(0);
		}
		if (salle.getPiege() != null) {// Permet de vérifier la présence de piège dans la salle
			Utilitaire.lettreParLettre("La porte contenait un mécanisme vous tirant des flèches dessus");
			salle.getPiege().triggerTrap(joueur);
			Utilitaire.lettreParLettre("Vous retournez dans la salle précédente");
			Thread.sleep(600* Utilitaire.getVitessetxt());
			this.changerSalle(salle, salle.getPortes().get(0));// Retourne à la salle précédente
		}
		if (salle.getMonstre() != null) {// Permet de vérifier la présence de monstre dans la salle
			Utilitaire.lettreParLettre(salle.getMonstre().crier());
			Utilitaire.lettreParLettre("Un " + salle.getMonstre().toString() + " se trouve dans la salle");
			Combat.combattre(joueur, salle.getMonstre());
			salle.setMonstre(null);// Supprime le monstre de la salle
			Thread.sleep(600* Utilitaire.getVitessetxt());
		}
		if (salle.getLaya() != null || salle.getBandit() != null) {// Permet de vérifier la présence du support dans la
																	// salle
			actCode = Utilitaire.yesNoQuestions(
					"Dans la salle se trouve une personne mystérieuse, à l'air inquiétant, qui se propose de vous aider à vous échapper\nAcceptez-vous ?\n1 pour Oui\n2 pour Non");
			if (actCode == 1) {
				Utilitaire.lettreParLettre("Vous faites connaissance avec la personne mystérieuse");
				if (salle.getLaya() != null) {
					Utilitaire.lettreParLettre(
								"Vous apprenez qu'elle s'appelle Laya et qu'elle possède des pouvoirs de guérison");
					Utilitaire.lettreParLettre(
								"Laya vous à rejoint, elle pourra vous soigner lors de vos futurs combats\n\n");
					joueur.setMateFollow(salle.getLaya());// Ajoute le support en tant que co-équipier du joueur
				} else {
					Utilitaire.lettreParLettre(
							"La personne s'avère être un bandit, elle vous donne un coup de couteau avant de s'enfuir");
						salle.getBandit().useSkill(joueur);
				}
				
			} else {
				Utilitaire.lettreParLettre(
						"Vous refusez l'aide de la personne mystérieuse, contrariée, elle s'en va\n\n");
			}
			if (salle.getLaya() != null)
				salle.setLaya(null);// Supprime le support de la salle
			else
				salle.setBandit(null);
			Thread.sleep(600* Utilitaire.getVitessetxt());
		}
		if (salle.getCoffre() != null) {// Permet de vérifier la présence de coffre dans la salle
			if (salle.getCoffre().isLocked()) // Affiche la question en fonction de l'état du coffre (verrouillé ou non)
				actCode = Utilitaire.yesNoQuestions(
						"Dans la salle se trouve un coffre verrouillé\nSouhaitez-vous le deverrouiller ?\n1 pour le déverrouiller\n2 pour le laisser");
			else
				actCode = Utilitaire.yesNoQuestions(
						"Dans la salle se trouve un coffre\nSouhaitez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
			if (actCode == 1) {
				joueur.open(salle.getCoffre());// Ouvre/Essaye d'ouvrir le coffre
			} else {
				if (salle.getCoffre().isLocked())// Affiche le texte en fonction de l'état du coffre (verrouillé ou non)
					Utilitaire.lettreParLettre("Vous laissez le coffre verrouillé");
				else
					Utilitaire.lettreParLettre("Vous laissez le coffre fermé");
			}
			Thread.sleep(600* Utilitaire.getVitessetxt());
		}
		do { // Affiche ce texte tant que le joueur se trouve dans la salle
			StringBuilder str = new StringBuilder("\nDans la salle se trouve :");
			for (Porte porte : salle.getPortes()) { // Va tester toute les portes de la salle
				if (porte != null) // Vérifie si la porte existe
					str.append("\nUne " + porte.toString()); // Va afficher la présence de la porte
			}
			for (Escalier escalier : salle.getEscaliers()) {
				if (escalier != null)
					str.append("\nUn " + escalier.toString());
			}
			str.append("\n\nQue souhaitez-vous faire ?\n");
			for (Porte porte : salle.getPortes()) {// Va tester toute les portes de la salle
				if (porte != null) { // Vérifie si la porte existe
					if (porte.getCat() == 0)// Vérifie l'état de la porte (Verrouillée ou non)
						str.append("\n" + porte.getDirection() + " pour emprunter la " + porte.toString());
					else
						str.append("\n" + porte.getDirection() + " pour déverrouiller la " + porte.toString());
				}
			}
			for (Escalier escalier : salle.getEscaliers()) {
				if (escalier != null)
					str.append("\n" + (escalier.getDirection() + 4) + " pour emprunter l'" + escalier.toString());

			}
			str.append("\n7 pour examiner la pièce");
			actCode = Utilitaire.recupererInt(str.toString());
			System.out.println("\n\n\n\n\n\n\n");
			while (actCode != 1 && actCode != 2 && actCode != 3 && actCode != 4 && actCode != 5 && actCode != 6
					&& actCode != 7) { // Vérifier que la
				// commande rentrée
				// est possible
				Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");
				actCode = Utilitaire.recupererInt(str.toString());
				System.out.println("\n\n\n\n\n\n\n");
			}
			if (actCode == 1 || actCode == 2 || actCode == 3 || actCode == 4)
				this.testPorte(actCode, salle, isHere);
			else if (actCode == 5 || actCode == 6)
				this.testEscalier(actCode, salle, isHere);
			else
				this.exam(salle);
			Thread.sleep(600* Utilitaire.getVitessetxt());
		} while (isHere);
	}

	public void exam(Salle salle) throws InterruptedException {// Va permettre de vérifier le type d'objet présent dans
																// la salle
		if (salle.getObjSol() == null) // Aucun objet présent
			Utilitaire.lettreParLettre("Vous ne trouvez rien d'intéressant dans la salle");
		else {
			int actCode;
			if (salle.getObjSol() instanceof Arme) { // Une arme présente
				Utilitaire.lettreParLettre("Vous avez trouvé " + salle.getObjSol().toString() + " dans la salle");
				joueur.equipWeapon((Arme) salle.getObjSol());
				salle.setObjSol(null); // Supprime l'arme du sol
			} else if (salle.getObjSol() instanceof Potion) { // Une potion présente
				actCode = Utilitaire.yesNoQuestions("Vous avez trouvé une " + salle.getObjSol()
						+ " dans la salle\nSouhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
				if (actCode == 1) {
					joueur.drink((Potion) salle.getObjSol());
					salle.setObjSol(null); // Supprime la potion de la salle
				} else {
					Utilitaire.lettreParLettre("Vous laissez la potion sur place");
				}
			} else if (salle.getObjSol() instanceof Key) { // Une clé présente
				if (((Key) salle.getObjSol()).getCat() == 1) // Vérifie le type de clé (Clé de porte ou clé de coffre)
					Utilitaire.lettreParLettre(
							"Vous trouvez une clé de coffre dans la salle. Vous l'ajoutez à votre trousseau de clé.");
				else
					Utilitaire.lettreParLettre(
							"Vous trouvez une clé de porte dans la salle. Vous l'ajoutez à votre trousseau de clé.");
				joueur.earnKey((Key) salle.getObjSol());
				salle.setObjSol(null); // Supprime la clé de la place
			}
		}
	}

	public void changerSalle(Salle salle, Porte porte) throws InterruptedException { // Permet de se déplacer d'une
																						// salle à l'autre
		switch (porte.getCat()) { // Vérifie si la porte est verrouillée ou déverrouillée
		case 0: // Porte déverrouillée
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
		case 2: // Porte verrouillée par clé
			joueur.unlock(porte);
			break;
		case 3: // Porte verrouillée par énigme
			porte.unlock(porte.getEnigme());
			break;
		}

	}

	public void changerEtage(Salle salle, Escalier escalier) throws InterruptedException {
		if (escalier.getDirection() == 1)
			this.entrerSalle(this.salles[salle.getX()][salle.getY()][salle.getZ() + 1]);
		else
			this.entrerSalle(this.salles[salle.getX()][salle.getY()][salle.getZ() - 1]);

	}

	public void testPorte(int actCode, Salle salle, boolean isHere) throws InterruptedException { // Permet de vérifier
																									// si la porte
																									// existe ou pas
																									// dans la salle
		for (Porte portes : salle.getPortes()) { // Vérifie la présence de la porte demandée dans la salle
			if (portes != null) { // Evite le crash
				if (portes.getDirection() == actCode) { // Si la porte demandée existe bien
					if (portes.getCat() != 0) { // Si la porte est verrouillée
						this.changerSalle(salle, portes);
						if (portes.getCat() == 0) // Si la porte s'est correctement deverrouillée
							System.out.print("Vous pouvez maintenant l'emprunter\n");
					} else { // Si la porte est déverrouillée
						Utilitaire.lettreParLettre("Vous changez de salle");
						isHere = false;
						this.changerSalle(salle, portes);
					}
					return;
				}
			}
		}
		Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");

	}

	public void testEscalier(int actCode, Salle salle, boolean isHere) throws InterruptedException {
		for (Escalier escalier : salle.getEscaliers()) { // Vérifie la présence de l'escalier demandée dans la salle
			if (escalier != null) { // Evite le crash
				if (escalier.getDirection() == actCode - 4) { // Si l'escalier demandée existe bien
					Utilitaire.lettreParLettre("Vous changez de salle");
					isHere = false;
					this.changerEtage(salle, escalier);
					return;
				}
			}
		}
		Utilitaire.lettreParLettre("Saisie invalide, veuillez réessayer.");

	}

}