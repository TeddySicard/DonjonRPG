package objets;

public class Chest {

	private int cat;
	private Object contenu;

	public Chest(Object contenu, int cat) { // Constructeur d'un coffre verrouill�
		this.cat = cat;
		this.contenu = contenu;
	}

	public Chest(Object contenu) { // Constructeur d'un coffre d�verrouill�
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

	public void setContenu(Object contenu) {
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
