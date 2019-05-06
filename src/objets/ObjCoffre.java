package objets;

import donjon.Chest;
import personnages.PersonnagePrincipal;

public interface ObjCoffre {
	
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException;

}
