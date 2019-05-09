package objets;

import donjon.Chest;
import personnages.PersonnagePrincipal;

/**
 * 
 * @author Ted
 *
 */
public interface ObjCoffre {
	
	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException;

}
