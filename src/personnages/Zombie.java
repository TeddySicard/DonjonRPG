package personnages;

public class Zombie extends Monstre {
	public Zombie() {
		super(16, 5, 2);

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
