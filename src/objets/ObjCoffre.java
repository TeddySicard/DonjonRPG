package objets;

import donjon.Chest;
import personnages.PersonnagePrincipal;

/**
 * This class represents every object than can be found in a chest
 * 
 * @author Ted
 *
 */
public interface ObjCoffre {

	public void trouverObjCoffre(Chest coffre, PersonnagePrincipal joueur) throws InterruptedException;

}
