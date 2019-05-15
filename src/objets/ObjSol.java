package objets;

import donjon.Salle;
import personnages.PersonnagePrincipal;

/**
 * This class represents every object than can be found in a chest
 * 
 * @author Ted
 *
 */
public interface ObjSol {

	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;

}
