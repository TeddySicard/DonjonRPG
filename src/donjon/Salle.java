package donjon;

import objets.ObjSol;
import personnages.Monstre;
import personnages.PNJ;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ted
 *
 */
public class Salle {
	private int x;
	private int y;
	private int z;
	private List<Porte> portes;
	private List<Escalier> escaliers;
	private Chest coffre;
	private Monstre monstre;
	private PNJ pnj;
	private Piege piege;
	private ObjSol objSol;
	private boolean victoire = false;
	private boolean depart = false;

	/**
	 * Create a room including several elements
	 * 
	 * @param x         is the horizontal pointer
	 * @param y         is the vertical pointer
	 * @param z         is the level pointer
	 * @param porte1    is a door in the room
	 * @param porte2    is a door in the room
	 * @param porte3    is a door in the room
	 * @param porte4    is a door in the room
	 * @param escalier1 are stairs in the room
	 * @param escalier2 are stairs in the room
	 * @param objSol    is an object inside of the room
	 */
	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Porte porte4, Escalier escalier1,
			Escalier escalier2, ObjSol objSol) {
		this.x = x;
		this.y = y;
		this.z = z;
		portes = new ArrayList<>();
		portes.add(porte1);
		portes.add(porte2);
		portes.add(porte3);
		portes.add(porte4);
		escaliers = new ArrayList<>();
		escaliers.add(escalier1);
		escaliers.add(escalier2);
		this.objSol = objSol;
	}

	////// Constructors (Created depending of the dungeons's need)///////
	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Porte porte4) {
		this(x, y, z, porte1, porte2, porte3, porte4, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3) {
		this(x, y, z, porte1, porte2, porte3, null, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2) {
		this(x, y, z, porte1, porte2, null, null, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1) {
		this(x, y, z, porte1, null, null, null, null, null, null);
	}

	public Salle(int x, int y, int z, boolean victoire) {
		this(x, y, z, null);
		this.setVictoire(victoire);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, ObjSol objsol) {
		this(x, y, z, porte1, porte2, porte3, null, null, null, objsol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, ObjSol objsol) {
		this(x, y, z, porte1, porte2, null, objsol);
	}

	public Salle(int x, int y, int z, Porte porte1, ObjSol objsol) {
		this(x, y, z, porte1, null, null, objsol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Escalier escalier1) {
		this(x, y, z, porte1, porte2, null, null, escalier1, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Escalier escalier1) {
		this(x, y, z, porte1, null, escalier1);
	}

	public Salle(int x, int y, int z, Porte porte1, Escalier escalier1, ObjSol objsol) {
		this(x, y, z, porte1, null, null, null, escalier1, null, objsol);
	}

	public Salle(int x, int y, int z, Escalier escalier1, ObjSol objsol) {
		this(x, y, z, null, escalier1, objsol);
	}

	public Salle(boolean depart, int x, int y, int z, Porte porte1, ObjSol objsol) {
		this(x, y, z, porte1, objsol);
		this.setDepart(depart);
	}

	/////////////////////////////////// Getters &&
	/////////////////////////////////// Setters////////////////////////////////////////
	public List<Porte> getPortes() {
		return portes;
	}

	public void setPortes(List<Porte> portes) {
		this.portes = portes;
	}

	public List<Escalier> getEscaliers() {
		return escaliers;
	}

	public void setEscaliers(List<Escalier> escaliers) {
		this.escaliers = escaliers;
	}

	public Chest getCoffre() {
		return coffre;
	}

	public void setCoffre(Chest coffre) {
		this.coffre = coffre;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public PNJ getPnj() {
		return pnj;
	}

	public void setPnj(PNJ pnj) {
		this.pnj = pnj;
	}

	public Piege getPiege() {
		return piege;
	}

	public void setPiege(Piege piege) {
		this.piege = piege;
	}

	public ObjSol getObjSol() {
		return objSol;
	}

	public void setObjSol(ObjSol objSol) {
		this.objSol = objSol;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public boolean isDepart() {
		return depart;
	}

	public void setDepart(boolean depart) {
		this.depart = depart;
	}

	public boolean isVictoire() {
		return victoire;
	}

	public void setVictoire(boolean victoire) {
		this.victoire = victoire;
	}

}
