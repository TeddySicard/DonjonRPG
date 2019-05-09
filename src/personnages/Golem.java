package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public class Golem extends Monstre {

	public final static int HP = 100;
	public final static int ATK = 3;
	public final static int CRIT = 0;
	
	public Golem(Salle salle) {
		super(HP, ATK, CRIT, salle);

	}

	@Override
	public String toString() {
		return "Golem";
	}

	@Override
	public String crier() {

		return "GRGRGGRGRGR !!!!";
	}

}
