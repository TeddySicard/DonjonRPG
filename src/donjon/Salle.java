package donjon;

import objets.Chest;
import personnages.Monstre;
import personnages.Support;
import java.util.ArrayList;
import java.util.List;
public class Salle {
	private int x;
	private int y;
	private List<Porte> portes;
	private Chest coffre;
	private Monstre monstre;
	private Support laya;
	private Piege piege;
	private Object objSol;
	private boolean victoire = false;
	private boolean depart = false;
	public boolean isVictoire() {
		return victoire;
	}

	public void setVictoire(boolean victoire) {
		this.victoire = victoire;
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Porte porte3, Porte porte4, Chest coffre, Monstre monstre,
			Support laya, Piege piege, Object objSol) {
		this.x = x;
		this.y = y;
		portes = new ArrayList<>();
		portes.add(porte1);
		portes.add(porte2);
		portes.add(porte3);
		portes.add(porte4);
		this.coffre = coffre;
		this.monstre = monstre;
		this.laya = laya;
		this.piege = piege;
		this.objSol = objSol;
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Chest coffre, Monstre monstre, Object objSol) {
		this(x, y, porte1, porte2, null, null, coffre, monstre, null, null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Porte porte3, Monstre monstre,
			Object objSol) {
		this(x,y,porte1,porte2, porte3, null, null, monstre, null, null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Monstre monstre, Object objSol) {
		this(x,y, porte1, porte2,null, null, null, monstre,null, null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Porte porte3, Monstre monstre) {
		this(x,y,porte1, porte2, porte3, monstre, null);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Object objSol) {
		this(x, y, porte1, porte2, null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Chest coffre) {
		this(x, y, porte1, porte2, coffre, null, null);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Monstre monstre) {
		this(x, y, porte1, porte2, monstre, null);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2, Porte porte3) {
		this(x, y, porte1, porte2, porte3, null);
	}

	public Salle(int x, int y, Porte porte1, Chest coffre, Object objSol) {
		this(x ,y ,porte1 ,null, coffre, null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Chest coffre) {
		this(x, y, porte1, coffre, null);
	}

	public Salle(int x, int y, Porte porte1, Porte porte2) {
		this(x, y, porte1, porte2, null, null, null, null, null, null, null);
	}

	public Salle(int x, int y, Porte porte1, Object objSol) {
		this(x, y, porte1, null,null, objSol);
	}

	public Salle(int x, int y, Porte porte1, Support laya) {
		this(x, y, porte1, null, null, null, null, null, laya, null, null);
	}

	public Salle(int x, int y, Porte porte1, Piege piege) {
		this(x, y, porte1, null, null, null, null, null, null, piege, null);
	}

	public Salle(int x, int y, Porte porte1) {
		this(x, y, porte1, null, null, null, null, null, null, null, null);
	}

	public Salle(int x, int y, boolean victoire) {
		this(x, y, null);
		this.setVictoire(victoire);
	}

	public Salle(boolean depart, int x, int y, Porte porte1, Object objsol) {
		this(x, y, porte1, objsol);
		this.setDepart(depart);
	}

	public List<Porte> getPortes() {
		return portes;
	}

	public void setPortes(List<Porte> portes) {
		this.portes = portes;
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

	public Support getLaya() {
		return laya;
	}

	public void setLaya(Support laya) {
		this.laya = laya;
	}

	public Piege getPiege() {
		return piege;
	}

	public void setPiege(Piege piege) {
		this.piege = piege;
	}

	public Object getObjSol() {
		return objSol;
	}

	public void setObjSol(Object objSol) {
		this.objSol = objSol;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isDepart() {
		return depart;
	}

	public void setDepart(boolean depart) {
		this.depart = depart;
	}

}
