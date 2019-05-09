package armes;

/**
 * 
 * @author Ted
 *
 */
public class Sabre extends Arme {

	public final static int FOR = 20; // Strength of a saber

	public Sabre() {
		super(FOR);
	}

	@Override
	public String toString() {
		return "un sabre";
	}

}
