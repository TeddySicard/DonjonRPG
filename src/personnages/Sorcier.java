package personnages;

public class Sorcier extends Monstre {

	public Sorcier() {
		super(24, 7, 1);
	}

	@Override
	public String toString() {
		return "sorcier";
	}


	public String crier() {
		return "Skibiidi skibida !!!!";
	}

}
