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

	public Porte(int direction, int cat) { // Constructeur pour une porte verrouillée par clé
		this.direction = direction;
		this.cat = cat;
		this.setEnigme(null);
	}

	public Porte(int direction) { // Constructeur pour une porte déverrouillée
		this(direction, 0);
	}

	public Porte(int direction, Enigme enigme) { // Constructeur pour une porte verrouillée par enigme
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

	@Override
	public String toString() { // Permet d'afficher les spécificités de la porte
		StringBuilder res = new StringBuilder("porte ");
		if (this.getCat() == 2) // Si verrouillée par clé
			res.append("verouillée ");
		else if (this.getCat() == 3) // Si verrouillée par énigme
			res.append("avec énigme ");
		res.append("en direction ");
		switch (this.getDirection()) { // Détermine la direction de la porte
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

	public boolean unlock(Key key) {// Déverrouille la porte verrouillée par une clé
		if (key.getCat() == this.cat) { // Si la clé est une clé de porte
			this.cat = 0;
			return true;
		} else
			return false;
	}

	public void unlock(Enigme enigme) throws InterruptedException { // Lance l'énigme
		String prop;
		switch (enigme.getNumero()) { // Permet de selectionner l'énigme voulue
		case 1:
			String answer = "42";
			Utilitaire.lettreParLettre(
					"Je suis la réponse à cette énigme\nJe suis la réponse aux questionnements\nJe suis la réponse à la vie\nJe suis les salles de ce donjon");
			prop = Main.caractere.nextLine();
			Utilitaire.sautDeLignes();
			if (!prop.equals(answer)) // Si réponse incorrecte
				Utilitaire.lettreParLettre("Mauvaise réponse, rien ne se passe");
			else { // Si réponse correcte
				Utilitaire.lettreParLettre("\n\n\n    444    22222222\r\n" + "   444    222    222\r\n"
						+ "  444 444       222\r\n" + " 444  444     222\r\n" + "44444444444 222\r\n"
						+ "      444  222\r\n" + "      444 2222222222");
				Thread.sleep(1000 * Utilitaire.getVitessetxt());
				Utilitaire.lettreParLettre("\n\n\nVous avez trouvé la bonne réponse, vous pouvez passer");
				this.cat = 0; // Déverrouille la porte
			}
			break;
		case 2:
			answer = "Aujourd'hui";
			Utilitaire.lettreParLettre("Je serai hier, j'étais demain");
			prop = Main.caractere.nextLine();
			Utilitaire.sautDeLignes();
			if (!prop.equalsIgnoreCase(answer)) // Si réponse incorrecte
				Utilitaire.lettreParLettre("Mauvaise réponse, rien ne se passe");
			else { // Si réponse correcte
				Utilitaire.lettreParLettre(" ____________________\r\n" + "|27|28|29|30|________|\r\n"
						+ "|____MAY____|_1|_2|_3|\r\n" + "|_4|_5|_6|_7|_8|_9|10|\r\n" + "|11|12|13|14|15|16|17|\r\n"
						+ "|18|19|20|21|22|23|24|\r\n" + "|25|26|27|28|29|30|31|\r\n" + "|_____2__0__1__9_____|\r\n"
						+ "");
				Utilitaire.lettreParLettre("Vous avez trouvé la bonne réponse, vous pouvez passer");
				this.cat = 0; // Déverrouille la porte
			}
		}

	}

}
