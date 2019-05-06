package donjon;

import objets.Key;
import objets.ObjCoffre;

public class Chest {

	private int cat;
	private ObjCoffre contenu;

	public Chest(ObjCoffre contenu, int cat, Salle salle) { // Constructeur d'un coffre verrouill�
		salle.setCoffre(this);
		this.cat = cat;
		this.contenu = contenu;
	}

	public Chest(ObjCoffre contenu, Salle salle) { // Constructeur d'un coffre d�verrouill�
		this(contenu, 0, salle);
	}

	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public ObjCoffre getContenu() {
		return contenu;
	}

	public void setContenu(ObjCoffre contenu) {
		this.contenu = contenu;
	}

	public boolean isLocked() {
		if (this.cat == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean unlock(Key key) { // D�verrouiller un coffre
		if (key.getCat() == this.cat) { // Si la cl� est compatible
			this.cat = 0;
			return true;
		} else
			return false;
	}

}
