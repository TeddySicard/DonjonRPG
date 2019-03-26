package donjon;

import objets.Chest;
import personnages.Bandit;
import personnages.Monstre;
import personnages.Support;
import java.util.ArrayList;
import java.util.List;

public class Salle {
	private int x;
	private int y;
	private int z;
	private List<Porte> portes;
	private List<Escalier> escaliers;
	private Chest coffre;
	private Monstre monstre;
	private Support laya;
	private Bandit bandit;
	private Piege piege;
	private Object objSol;
	private boolean victoire = false;
	private boolean depart = false;

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Porte porte4, Escalier escalier1,
			Escalier escalier2, Chest coffre, Monstre monstre, Support laya, Bandit bandit, Piege piege,
			Object objSol) {
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
		this.coffre = coffre;
		this.monstre = monstre;
		this.laya = laya;
		this.bandit = bandit;
		this.piege = piege;
		this.objSol = objSol;
	}

	/////////////////////////////////////Constructeurs (Créés selon besoin des donjons créés)//////////////////////////////
	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Chest coffre, Monstre monstre, Object objSol) {
		this(x, y, z, porte1, porte2, null, null, null, null, coffre, monstre, null, null, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Monstre monstre, Object objSol) {
		this(x, y, z, porte1, porte2, porte3, null, null, null, null, monstre, null, null, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Monstre monstre, Object objSol) {
		this(x, y, z, porte1, porte2, null, null, null, null, null, monstre, null, null, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Monstre monstre) {
		this(x, y, z, porte1, porte2, porte3, monstre, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Object objSol) {
		this(x, y, z, porte1, porte2, null, null, null, null, null, null, null, null, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Chest coffre) {
		this(x, y, z, porte1, porte2, coffre, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Monstre monstre) {
		this(x, y, z, porte1, porte2, monstre, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3) {
		this(x, y, z, porte1, porte2, porte3, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Chest coffre, Object objSol) {
		this(x, y, z, porte1, null, coffre, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Chest coffre) {
		this(x, y, z, porte1, coffre, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2) {
		this(x, y, z, porte1, porte2, null, null, null, null, null, null, null, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Object objSol) {
		this(x, y, z, porte1, null, null, null, null, null, null, null, null, null, null, objSol);
	}

	public Salle(int x, int y, int z, Porte porte1, Support laya) {
		this(x, y, z, porte1, null, null, null, null, null, null, null, laya, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Piege piege) {
		this(x, y, z, porte1, null, null, null, null, null, null, null, null, null, piege, null);
	}

	public Salle(int x, int y, int z, Porte porte1) {
		this(x, y, z, porte1, null, null, null, null, null, null, null, null, null, null, null);
	}

	public Salle(int x, int y, int z, boolean victoire) {
		this(x, y, z, null);
		this.setVictoire(victoire);
	}

	public Salle(boolean depart, int x, int y, int z, Porte porte1, Object objsol) {
		this(x, y, z, porte1, objsol);
		this.setDepart(depart);
	}

	public Salle(int x, int y, int z, Escalier escalier, Bandit bandit, Object objsol) {
		this(x, y, z, null, null, null, null, escalier, null, null, null, null, bandit, null, objsol);
	}

	public Salle(int x, int y, int z, Porte porte1, Escalier escalier, Object objsol) {
		this(x, y, z, porte1, null, null, null, escalier, null, null, null, null, null, null, objsol);

	}
	
	public Salle(int x, int y, int z, Porte porte1, Escalier escalier) {
		this(x, y, z, porte1,escalier, null);

	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Porte porte4) {
		this(x, y, z, porte1, porte2, porte3, porte4, null, null, null, null, null, null, null, null);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Porte porte3, Object objsol) {
		this(x, y, z, porte1, porte2, porte3, null, objsol);
	}

	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Chest coffre, Monstre monstre) {
		this(x, y, z, porte1, porte2, coffre, monstre, null);
	}
	
	public Salle(int x, int y, int z, Porte porte1, Porte porte2, Bandit bandit) {
		this(x, y, z, porte1, porte2, null, null, null, null, null, null, null, bandit, null, null);
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

	public Bandit getBandit() {
		return bandit;
	}

	public void setBandit(Bandit bandit) {
		this.bandit = bandit;
	}
	

	@Override
	public String toString() {
		return "Salle [x=" + x + ", y=" + y + ", z=" + z + ", portes=" + portes + ", escaliers=" + escaliers
				+ ", coffre=" + coffre + ", monstre=" + monstre + ", laya=" + laya + ", bandit=" + bandit + ", piege="
				+ piege + ", objSol=" + objSol + ", victoire=" + victoire + ", depart=" + depart + "]";
	}

}
