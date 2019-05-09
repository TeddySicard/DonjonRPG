package donjon;

import objets.Key;
import objets.ObjCoffre;

/**
 * 
 * @author Ted
 *
 */
public class Chest {

	private int cat;// Tells if the chest is locked or not (0 for unlocked, 1 for locked)
	private ObjCoffre contenu;

	/**
	 * Create a chest
	 * 
	 * @param contenu is the object inside the chest
	 * @param cat tells if the chest is locked or not
	 * @param salle is the room where the chest will be located
	 */
	public Chest(ObjCoffre contenu, int cat, Salle salle) {
		salle.setCoffre(this);
		this.cat = cat;
		this.contenu = contenu;
	}

	/**
	 * Create an unlocked chest
	 * 
	 * @param contenu is the object inside the chest
	 * @param salle is the room where the chest will be located
	 */
	public Chest(ObjCoffre contenu, Salle salle) {
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
	/**
	 * Checks if the chest is locked or not
	 * 
	 * @return true if locked and false if unlocked
	 */
	public boolean isLocked() {
		if (this.cat == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Unlock the chest if possible
	 * 
	 * @param key is the key we use to unlock the chest
	 * @return true if it succeed, false if it didn't
	 */
	public boolean unlock(Key key) {
		if (key.getCat() == this.cat) {
			this.cat = 0;
			return true;
		} else
			return false;
	}

}
