package personnages;

public class BossFinal extends Monstre{

	public BossFinal() {
		super(300, 15, 1);
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
