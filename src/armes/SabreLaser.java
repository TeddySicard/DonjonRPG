package armes;

/**
 * 
 * @author Ted
 *
 */
public class SabreLaser extends Arme {

	public final static int FOR = 40; // Strength of a lightsaber

	public SabreLaser() {
		super(FOR);
	}

	@Override
	public String toString() {
		return "un sabre-laser";
	}

}
