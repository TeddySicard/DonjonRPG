package donjon;

/**
 * 
 * @author Ted
 *
 */
public class Escalier {
	private int direction;
	
	public Escalier (int direction) {
		this.setDirection(direction);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() { // Permet d'afficher les spécificités de l'escalier
		StringBuilder res = new StringBuilder("escalier ");
		switch (this.getDirection()) { // Détermine la direction de la porte
		case 1:
			res.append("montant");
			break;
		case 2:
			res.append("descendant");
			break;
		}
		return res.toString();
	}
}
