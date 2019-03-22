package personnages;

public class Golem extends Monstre {

	public Golem() {
		super(100, 3, 0);

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
