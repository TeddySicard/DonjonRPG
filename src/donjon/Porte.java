package donjon;

import main.Main;
import objets.Enigme;
import objets.Key;
import util.Utilitaire;

/**
 * 
 * @author Ted
 *
 */
public class Porte {
	private int cat;
	private int direction;
	private Enigme enigme;

	/**
	 * Create a door
	 * 
	 * @param direction is an int representing the door's direction, 1 is for going
	 *                  north 2 is for going south 3 is for going east and 4 is for
	 *                  going east
	 * @param cat       is an int representing the door's state : 0 is unlocked 2 is
	 *                  locked by a key
	 */
	public Porte(int direction, int cat) {
		this.direction = direction;
		this.cat = cat;
		this.setEnigme(null);
	}

	/**
	 * Create an unlocked door
	 * 
	 * @param direction is an int representing the door's direction, 1 is for going
	 *                  north 2 is for going south 3 is for going east and 4 is for
	 *                  going east
	 */
	public Porte(int direction) {
		this(direction, 0);
	}

	/**
	 * Create a door locked by an enigma
	 * 
	 * @param direction is an int representing the door's direction, 1 is for going
	 *                  north 2 is for going south 3 is for going east and 4 is for
	 *                  going east
	 * @param enigme    is the enigma attached to the door
	 */
	public Porte(int direction, Enigme enigme) {
		this(direction, 3);
		this.setEnigme(enigme);
	}

///////////////////////////////////////////Getters && Setters/////////////////////////////
	public int getDirection() {
		return direction;
	}

	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public Enigme getEnigme() {
		return enigme;
	}

	public void setEnigme(Enigme enigme) {
		this.enigme = enigme;
	}

	/**
	 * Create a door showing the door's specs
	 */
	@Override
	public String toString() { //
		StringBuilder res = new StringBuilder("porte ");
		if (this.getCat() == 2) // If locked by a key
			res.append("verouillée ");
		else if (this.getCat() == 3) // If locked by an enigma
			res.append("avec énigme ");
		res.append("en direction ");
		switch (this.getDirection()) { // Looks at the door's direction
		case 1:
			res.append("du nord");
			break;
		case 2:
			res.append("du sud");
			break;
		case 3:
			res.append("de l'est");
			break;
		case 4:
			res.append("de l'ouest");
			break;
		}
		return res.toString();
	}

	/**
	 * Unlocks a door using a key
	 * 
	 * @param key is the key you use to try to unlock the door
	 * @return true if the door is unlocked false if it's locked
	 */
	public boolean unlock(Key key) {
		if (key.getCat() == this.cat) { // If the key is a door key
			this.cat = 0; // Unlocks the door
			return true;
		} else
			return false;
	}

	/**
	 * Unlocks the door by resolving the enigma
	 * 
	 * @param enigme is the enigma you want to launch
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void unlock(Enigme enigme) throws InterruptedException {
		String prop;
		switch (enigme) { // Select the right enigma
		case fourtytwo:
			String answer = "42";
			Utilitaire.lettreParLettre(
					"Je suis la réponse à cette énigme\nJe suis la réponse aux questionnements\nJe suis la réponse à la vie\nJe suis les salles de ce donjon");
			prop = Main.caractere.nextLine();
			Utilitaire.sautDeLignes();
			if (!prop.equals(answer)) // If bad answer
				Utilitaire.lettreParLettre("Mauvaise réponse, rien ne se passe");
			else { // If correct answer
				Utilitaire.lettreParLettre("\n\n\n    444    22222222\r\n" + "   444    222    222\r\n"
						+ "  444 444       222\r\n" + " 444  444     222\r\n" + "44444444444 222\r\n"
						+ "      444  222\r\n" + "      444 2222222222");
				Thread.sleep(1000 * Utilitaire.getVitessetxt());
				Utilitaire.lettreParLettre("\n\n\nVous avez trouvé la bonne réponse, vous pouvez passer");
				this.cat = 0; // Unlocks the door
			}
			break;
		case today:
			answer = "Aujourd'hui";
			Utilitaire.lettreParLettre("Je serai hier, j'étais demain");
			prop = Main.caractere.nextLine();
			Utilitaire.sautDeLignes();
			if (!prop.equalsIgnoreCase(answer)) // If bad answer
				Utilitaire.lettreParLettre("Mauvaise réponse, rien ne se passe");
			else { // If correct answer
				Utilitaire.lettreParLettre(" ____________________\r\n" + "|27|28|29|30|________|\r\n"
						+ "|____MAY____|_1|_2|_3|\r\n" + "|_4|_5|_6|_7|_8|_9|10|\r\n" + "|11|12|13|14|15|16|17|\r\n"
						+ "|18|19|20|21|22|23|24|\r\n" + "|25|26|27|28|29|30|31|\r\n" + "|_____2__0__1__9_____|\r\n"
						+ "");
				Utilitaire.lettreParLettre("Vous avez trouvé la bonne réponse, vous pouvez passer");
				this.cat = 0; // Unlocks the door
			}
		}

	}

}
