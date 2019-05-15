package armes;

/**
 * DoubleLame is a class instantiating a specific weapon, with final values
 *
 * @author Ted
 *
 */
public class DoubleLame extends Arme {

	public final static int FOR = 14; // Strength of a double blade

	public DoubleLame() {
		super(FOR);

	}

	@Override
	public String toString() {
		return "une double lame";
	}

}
