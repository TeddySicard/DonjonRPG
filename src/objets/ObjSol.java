package objets;

import donjon.Salle;
import personnages.PersonnagePrincipal;

/**
 * 
 * @author Ted
 *
 */
public interface ObjSol {
	
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;
	
}
