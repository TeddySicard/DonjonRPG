package objets;

public class Chest {

	private int cat;
	private Object contenu;

	public Chest(Object contenu, int cat) {
		this.cat = cat;
		this.contenu = contenu;
	}

	public Chest(Object contenu) {
		this(contenu, 0);
	}

	public int getCat() {
		return cat;
	}

	public void setCat(int cat) {
		this.cat = cat;
	}

	public Object getContenu() {
		return contenu;
	}

	public boolean isLocked() {
		if (this.cat == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean unlock(Key key) {
		if (this.getCat() == 1) {
			if (key.getCat() == this.cat) {
				this.cat = 0;
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void setContenu(Object contenu) {
		this.contenu = contenu;
	}

}
