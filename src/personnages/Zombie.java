package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public class Zombie extends Monstre {
	
	public final static int HP = 16;
	public final static int ATK = 5;
	public final static int CRIT = 2;
	
	public Zombie(Salle salle) {
		super(HP, ATK, CRIT, salle);

	}

	@Override
	public String toString() {
		return "Zombie";
	}

	@Override
	public String crier() {
		return "Grahahaahha !!!!";
	}

}
