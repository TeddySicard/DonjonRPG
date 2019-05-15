package armes;

/**
 * Dague is a class instantiating a specific weapon, with final values
 * 
 * @author Ted
 *
 */
public class Dague extends Arme {

	public final static int FOR = 10; // Strength of a dagger

	public Dague() {
		super(FOR);
	}

	@Override
	public String toString() {
		return "une dague";
	}

}
