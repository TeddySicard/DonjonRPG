package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public class BossFinal extends Monstre {
	
	public final static int HP = 300;
	public final static int ATK = 15;
	public final static int CRIT = 1;

	public BossFinal(Salle salle) {
		super(HP, ATK, CRIT, salle);
	}

	@Override
	public String toString() {
		return "Gardien du donjon";
	}

	@Override
	public String crier() {
		return "MOUAHAHAHAHA";
	}

}
