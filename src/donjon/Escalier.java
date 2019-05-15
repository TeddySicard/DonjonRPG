package donjon;

/**
 * 
 * @author Ted
 *
 */
public class Escalier {
	private int direction;

	/**
	 * Create stairs going up or down
	 * 
	 * @param direction is an int representing the stairs's direction, 1 is for
	 *                  going up 2 is for going down
	 */
	public Escalier(int direction) {
		this.setDirection(direction);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Create a string showing the stairs's specs
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("escalier ");
		switch (this.getDirection()) { // Looks at the stairs's direction
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
