package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public class Sorcier extends Monstre {

	public final static int HP = 24;
	public final static int ATK = 7;
	public final static int CRIT = 1;
	
	public Sorcier(Salle salle) {
		super(HP, ATK, CRIT, salle);
	}

	@Override
	public String toString() {
		return "sorcier";
	}

	public String crier() {
		return "Skibiidi skibida !!!!";
	}

}
