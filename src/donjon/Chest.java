package donjon;

import objets.Key;
import objets.ObjCoffre;

public class Chest {

	private int cat;// Tells if the chest is locked or not (0 for unlocked, 1 for locked)
	private ObjCoffre contenu;

	public Chest(ObjCoffre contenu, int cat, Salle salle) { // Locked chest constructor
		salle.setCoffre(this);
		this.cat = cat;
		this.contenu = contenu;
	}

	public Chest(ObjCoffre contenu, Salle salle) { // Unlocked chest constructor
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

	public boolean unlock(Key key) { // Unlock chest
		if (key.getCat() == this.cat) { // If the key is compatible
			this.cat = 0;
			return true;
		} else
			return false;
	}

}
