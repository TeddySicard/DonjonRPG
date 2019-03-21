package donjon;


import main.Main;
import objets.Enigme;
import objets.Key;
import util.Utilitaire;

public class Porte {
	private int cat;
	private int direction;
	private Enigme enigme;

	public Porte(int direction, int cat) {
		this.direction = direction;
		this.cat = cat;
		this.setEnigme(null);
	}

	public Porte(int direction) {
		this(direction, 0);
	}

	public Porte(int direction, Enigme enigme) {
		this(direction, 3);
		this.setEnigme(enigme);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("porte ");
		if (this.getCat() == 2)
			res.append("verouillée ");
		else if (this.getCat() == 3)
			res.append("avec énigme ");
		res.append("en direction ");
		switch (this.getDirection()) {
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

	public int getDirection() {
		return direction;
	}

	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public boolean unlock(Key key) {
		if (this.getCat() == 2) {
			if (key.getCat() == this.cat) {
				this.cat = 0;
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void unlock(Enigme enigme) throws InterruptedException {
		String prop;
		// PEUT PERMETTRE DE CREER D'AUTRES ENIGMES SI ENVIE //
		switch (enigme.getNumero()) {
		case 1:
			String answer = "42";
			Utilitaire.affiche("Je suis la réponse à cette énigme\nJe suis la réponse aux questionnements\nJe suis la réponse à la vie\nJe suis les salles de ce donjon");
			prop = Main.sc2.nextLine();
			System.out.println("\n\n\n\n\n\n\n");
			if (!prop.equals(answer))
				System.out.println("Mauvaise réponse, rien ne se passe");
			else {
				System.out.println("Vous avez trouvé la bonne réponse, vous pouvez passer");
				this.cat = 0;
			}
			break;
		}

	}

	public Enigme getEnigme() {
		return enigme;
	}

	public void setEnigme(Enigme enigme) {
		this.enigme = enigme;
	}

}
