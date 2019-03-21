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
import personnages.BossFinal;
import personnages.Golem;
import personnages.Monstre;
import personnages.PersonnagePrincipal;
import personnages.Sorcier;
import personnages.Support;
import personnages.Zombie;
import util.Utilitaire;

public class Donjon {
	public PersonnagePrincipal joueur;
	public Salle[][] salles;
	private int coordX;
	private int coordY;

	public Donjon(int x, int y) {
		this.salles = new Salle[x][y];
		this.joueur = new PersonnagePrincipal();
	}

	public Donjon() {
		this(11, 18);
	}

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

	// GENERER DONJON//
	public void generer() {
		// GENERATION DES CLES//
		Key cle25 = new Key(1);
		Key cle34 = new Key(2);
		Key cle517 = new Key(2);
		Key cle614 = new Key(1);
		Key cle811 = new Key(2);
		Key cle117 = new Key(2);
		// GENERATION DES POTIONS//
		Potion healPot33 = new HealingPot();
		Potion atkPot33 = new AtkPot();
		Potion hpGainPot416 = new HPGainPot();
		Potion hpGainPot57 = new HPGainPot();
		Potion healPot65 = new HealingPot();
		Potion atkPot78 = new AtkPot();
		Potion healPot711 = new HealingPot();
		Potion atkPot713 = new AtkPot();
		Potion healPot107 = new HealingPot();
		// GENERATION DES ARMES//
		Arme dague414 = new Dague();
		Arme sabreLaser59 = new SabreLaser();
		Arme doubleLame914 = new DoubleLame();
		Arme sabre117 = new Sabre();
		// GENERATION DES PIEGES//
		Piege trap15 = new Piege();
		Piege trap316 = new Piege();
		Piege trap45 = new Piege();
		Piege trap418 = new Piege();
		Piege trap514 = new Piege();
		Piege trap79 = new Piege();
		// GENERATION DE L'ENIGME//
		Enigme enigme87 = new Enigme(1);
		// GENERATION DES COFFRES//
		Chest coffre33 = new Chest(healPot33);
		Chest coffre45 = new Chest(trap45);
		Chest coffre414 = new Chest(dague414);
		Chest coffre59 = new Chest(sabreLaser59, 1);
		Chest coffre514 = new Chest(trap514);
		Chest coffre517 = new Chest(cle517, 1);
		Chest coffre614 = new Chest(cle614);
		Chest coffre79 = new Chest(trap79);
		Chest coffre117 = new Chest(cle117);
		// GENERATION DES PORTES//
		Porte porteNord = new Porte(1);
		Porte porteSud = new Porte(2);
		Porte porteEst = new Porte(3);
		Porte porteOuest = new Porte(4);
		Porte lockOuest33 = new Porte(4, 2);
		Porte lockOuest76 = new Porte(4, 2);
		Porte lockNorth811 = new Porte(1, 2);
		Porte lockOuest711 = new Porte(4, 2);
		Porte lockSouthEn87 = new Porte(2, enigme87);
		// GENERATION DES MONSTRES//
		Monstre bossFinal32 = new BossFinal();
		Monstre zombie33 = new Zombie();
		Monstre golem35 = new Golem();
		Monstre sorcier415 = new Sorcier();
		Monstre zombie416 = new Zombie();
		Monstre sorcier56 = new Sorcier();
		Monstre zombie57 = new Zombie();
		Monstre golem58 = new Golem();
		Monstre zombie75 = new Zombie();
		Monstre zombie78 = new Zombie();
		Monstre golem710 = new Golem();
		Monstre zombie711 = new Zombie();
		Monstre sorcier814 = new Sorcier();
		Monstre sorcier97 = new Sorcier();
		Monstre zombie1014 = new Zombie();
		// GENERATION DU SUPPORT//
		Support laya1114 = new Support();
		// GENERATION DES SALLES//
		Salle salle15 = new Salle(0, 4, porteSud, trap15);
		Salle salle25 = new Salle(1, 4, porteNord, porteSud, cle25);
		Salle salle31 = new Salle(2, 0, true);
		Salle salle32 = new Salle(2, 1, porteEst, porteOuest, bossFinal32);
		Salle salle33 = new Salle(2, 2, porteEst, lockOuest33, coffre33, zombie33, atkPot33);
		Salle salle34 = new Salle(2, 3, porteEst, porteOuest, cle34);
		Salle salle35 = new Salle(2, 4, porteNord, porteSud, porteOuest, golem35);
		Salle salle316 = new Salle(2, 15, porteSud, trap316);
		Salle salle45 = new Salle(3, 4, porteNord, porteSud, coffre45);
		Salle salle414 = new Salle(3, 13, porteSud, porteEst, coffre414);
		Salle salle415 = new Salle(3, 14, porteEst, porteOuest, sorcier415);
		Salle salle416 = new Salle(3, 15, porteNord, porteEst, porteOuest, zombie416, hpGainPot416);
		Salle salle417 = new Salle(3, 16, porteSud, porteOuest, porteOuest);
		Salle salle418 = new Salle(3, 17, porteOuest, trap418);
		Salle salle55 = new Salle(4, 4, porteNord, porteSud, porteEst);
		Salle salle56 = new Salle(4, 5, porteEst, porteOuest, sorcier56);
		Salle salle57 = new Salle(4, 6, porteEst, porteOuest, zombie57, hpGainPot57);
		Salle salle58 = new Salle(4, 7, porteEst, porteOuest, golem58);
		Salle salle59 = new Salle(4, 8, porteOuest, coffre59);
		Salle salle514 = new Salle(4, 13, porteNord, porteSud, coffre514);
		Salle salle517 = new Salle(4, 16, porteNord, coffre517);
		Salle salle65 = new Salle(5, 4, porteNord, porteSud, healPot65);
		Salle salle614 = new Salle(5, 13, porteNord, porteSud, coffre614);
		Salle salle75 = new Salle(6, 4, porteNord, porteEst, zombie75);
		Salle salle76 = new Salle(6, 5, lockOuest76, porteEst);
		Salle salle77 = new Salle(6, 6, porteSud, porteEst, porteOuest);
		Salle salle78 = new Salle(6, 7, porteEst, porteOuest, zombie78, atkPot78);
		Salle salle79 = new Salle(6, 8, porteEst, porteOuest, coffre79);
		Salle salle710 = new Salle(6, 9, porteEst, porteOuest, golem710);
		Salle salle711 = new Salle(6, 10, porteSud, porteEst, lockOuest711, zombie711, healPot711);
		Salle salle712 = new Salle(6, 11, porteEst, porteOuest);
		Salle salle713 = new Salle(6, 12, porteEst, porteOuest, atkPot713);
		Salle salle714 = new Salle(6, 13, porteNord, porteSud, porteOuest);
		Salle salle87 = new Salle(7, 6, porteNord, lockSouthEn87);
		Salle salle811 = new Salle(true, 7, 10, lockNorth811, cle811);
		Salle salle814 = new Salle(7, 13, porteNord, porteSud, sorcier814);
		Salle salle97 = new Salle(8, 6, porteNord, porteSud, sorcier97);
		Salle salle914 = new Salle(8, 13, porteNord, porteSud, doubleLame914);
		Salle salle107 = new Salle(9, 6, porteNord, porteSud, healPot107);
		Salle salle1014 = new Salle(9, 13, porteNord, porteSud, zombie1014);
		Salle salle117 = new Salle(10, 6, porteNord, coffre117, sabre117);
		Salle salle1114 = new Salle(10, 13, porteNord, laya1114);
		//// IMPLEMENTATION DES SALLES DANS LA MATRICE//
		this.ajouterSalle(salle15);
		this.ajouterSalle(salle25);
		this.ajouterSalle(salle31);
		this.ajouterSalle(salle32);
		this.ajouterSalle(salle33);
		this.ajouterSalle(salle34);
		this.ajouterSalle(salle35);
		this.ajouterSalle(salle316);
		this.ajouterSalle(salle45);
		this.ajouterSalle(salle414);
		this.ajouterSalle(salle415);
		this.ajouterSalle(salle416);
		this.ajouterSalle(salle417);
		this.ajouterSalle(salle418);
		this.ajouterSalle(salle55);
		this.ajouterSalle(salle56);
		this.ajouterSalle(salle57);
		this.ajouterSalle(salle58);
		this.ajouterSalle(salle59);
		this.ajouterSalle(salle514);
		this.ajouterSalle(salle517);
		this.ajouterSalle(salle65);
		this.ajouterSalle(salle614);
		this.ajouterSalle(salle75);
		this.ajouterSalle(salle76);
		this.ajouterSalle(salle77);
		this.ajouterSalle(salle78);
		this.ajouterSalle(salle79);
		this.ajouterSalle(salle710);
		this.ajouterSalle(salle711);
		this.ajouterSalle(salle712);
		this.ajouterSalle(salle713);
		this.ajouterSalle(salle714);
		this.ajouterSalle(salle87);
		this.ajouterSalle(salle811);
		this.ajouterSalle(salle814);
		this.ajouterSalle(salle97);
		this.ajouterSalle(salle914);
		this.ajouterSalle(salle107);
		this.ajouterSalle(salle1014);
		this.ajouterSalle(salle117);
		this.ajouterSalle(salle1114);

	}
	
	public void demarrer() throws InterruptedException {
		this.entrerSalle(this.salles[this.getCoordX()][this.getCoordY()]);
	}

	public void ajouterSalle(Salle salle) {
		this.salles[salle.getX()][salle.getY()] = salle;
		if (salle.isDepart()) {
			this.setCoordX(salle.getX());
			this.setCoordY(salle.getY());
		}
	}


	public void entrerSalle(Salle salle) throws InterruptedException {
		boolean isHere = true;
		int actCode;
		if (salle.isVictoire()) {
			System.out.println("Vous �tes sorti du donjon...");
			System.out.println("Vous avez gagn�");
			System.exit(1);	
		}
		if (salle.getPiege() != null) {
			System.out.println("La porte contenait un m�canisme vous tirant des fl�ches dessus");
			salle.getPiege().triggerTrap(joueur);
			System.out.println("Vous retournez dans la salle pr�c�dente");
			this.changerSalle(salle, salle.getPortes().get(0));
		} else {
			if (salle.getMonstre() != null) {
				System.out.println(salle.getMonstre().crier());
				System.out.println("Un " + salle.getMonstre().toString() + " se trouve dans la salle");
				Combat.combattre(joueur, salle.getMonstre());
				salle.setMonstre(null);
			}
			if (salle.getLaya() != null) {
				actCode = Utilitaire.yesNoQuestions("Dans la salle se trouve une personne myst�rieuse, � l'air inqui�tant, qui se propose de vous aider � vous �chapper\nAcceptez-vous ?\n1 pour Oui\n2 pour Non");
				if (actCode == 1) {
					System.out.println("Vous faites connaissance avec la personne myst�rieuse");
					System.out.println(
							"Vous apprenez qu'elle s'appelle Laya et qu'elle poss�de des pouvoirs de gu�rison");
					System.out.println("Laya vous � rejoint, elle pourra vous soigner lors de vos futurs combats\n\n");
					joueur.setMateFollow(salle.getLaya());
					salle.setLaya(null);
				} else {
					System.out.println("Vous refusez l'aide de la personne myst�rieuse, contrari�e, elle s'en va\n\n");
					salle.setLaya(null);
				}
			}
			if (salle.getCoffre() != null) {
				if (salle.getCoffre().isLocked()) 
					actCode = Utilitaire.yesNoQuestions("Dans la salle se trouve un coffre verrouill�\nSouhaitez-vous le deverrouiller ?\n1 pour le d�verrouiller\n2 pour le laisser");
				 else
					actCode = Utilitaire.yesNoQuestions("Dans la salle se trouve un coffre\nSouhaitez-vous l'ouvrir ?\n1 pour l'ouvrir\n2 pour le laisser");
				if (actCode == 1) {
					joueur.open(salle.getCoffre());
				} else {
					if (salle.getCoffre().isLocked())
						System.out.println("Vous laissez le coffre verrouill�");
					else
						System.out.println("Vous laissez le coffre ferm�");
				}
			}
			do {
				StringBuilder str = new StringBuilder("\nDans la salle se trouve :");
				for (Porte porte : salle.getPortes()) {
					if (porte != null)
						str.append("\nUne " + porte.toString());
				}
				str.append("\n\nQue souhaitez-vous faire ?\n");
				for (Porte porte : salle.getPortes()) {
					if (porte != null) {
						if (porte.getCat()==0)
							str.append("\n" + porte.getDirection() + " pour emprunter la " + porte.toString());
						else
							str.append("\n" + porte.getDirection() + " pour d�verrouiller la " + porte.toString());
					}
				}
				str.append("\n5 pour examiner la pi�ce");
				actCode = Utilitaire.recupererInt(str.toString());
				System.out.println("\n\n\n\n\n\n\n");
				while (actCode != 1 && actCode != 2 && actCode != 3 && actCode != 4 && actCode != 5) {
					System.out.println("Saisie invalide, veuillez r�essayer.");
					actCode = Utilitaire.recupererInt(str.toString());
					System.out.println("\n\n\n\n\n\n\n");
				}
				if (actCode == 1 || actCode==2 || actCode==3 || actCode == 4) 
					this.testPorte(actCode, salle, isHere);
				else
					this.exam(salle);	
			} while (isHere); 
		}
	}		
	
	public void exam(Salle salle) throws InterruptedException {
		if (salle.getObjSol() == null)
			System.out.println("Vous ne trouvez rien d'int�ressant dans la salle");
		else {
			int actCode;
			if (salle.getObjSol() instanceof Arme) {
				System.out.println("Vous avez trouv� " + salle.getObjSol().toString()+" dans la salle");
				joueur.equipWeapon((Arme) salle.getObjSol());
				salle.setObjSol(null);
			} else if (salle.getObjSol() instanceof Potion) {
				actCode = Utilitaire.yesNoQuestions("Vous avez trouv� une " + salle.getObjSol()
						+ " dans la salle\nSouhaitez-vous la boire ?\n1 pour boire la potion\n2 pour la laisser");
				if (actCode == 1) {
					joueur.drink((Potion) salle.getObjSol());
					salle.setObjSol(null);
				} else {
					System.out.println("Vous laissez la potion sur place");
				}
			} else if (salle.getObjSol() instanceof Key) {
				if (((Key) salle.getObjSol()).getCat() == 1)
					System.out
							.println("Vous trouvez une cl� de coffre dans la salle. Vous l'ajoutez � votre trousseau de cl�.");
				else
					System.out
							.println("Vous trouvez une cl� de porte dans la salle. Vous l'ajoutez � votre trousseau de cl�.");
				joueur.earnKey((Key) salle.getObjSol());
				salle.setObjSol(null);
			}
		}
	}

	public void changerSalle(Salle salle, Porte porte) throws InterruptedException {
		switch (porte.getCat()) {
		case 0:
			switch (porte.getDirection()) {
			case 1:
				this.entrerSalle(this.salles[salle.getX() - 1][salle.getY()]);
				break;
			case 2:
				this.entrerSalle(this.salles[salle.getX() + 1][salle.getY()]);
				break;
			case 3:
				this.entrerSalle(this.salles[salle.getX()][salle.getY() + 1]);
				break;
			case 4:
				this.entrerSalle(this.salles[salle.getX()][salle.getY() - 1]);
				break;
			}
			break;
		case 2 :
			joueur.unlock(porte);
			break;
		case 3 :
			porte.unlock(porte.getEnigme());
		}
		
	}
	
	public void testPorte(int actCode, Salle salle, boolean isHere) throws InterruptedException {
		Porte porte = null;
		boolean dir = false;
		for (Porte portes : salle.getPortes()) {
			if (portes != null) {
				if (portes.getDirection() == actCode) {
					porte = portes;
					dir = true;
					break;
				}
			}
		}
		if (!dir) 
			System.out.println("Saisie invalide, veuillez r�essayer.");
		else {
			if (porte.getCat()!=0) {
				this.changerSalle(salle, porte);
				if (porte.getCat()==0)
					System.out.print("Vous pouvez maintenant l'emprunter");

			}
			else {
				System.out.println("Vous changez de salle");
				isHere = false;
				this.changerSalle(salle, porte);
			}
		}
	}
	
}