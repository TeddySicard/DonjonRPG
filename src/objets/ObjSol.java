package objets;

import donjon.Salle;
import personnages.PersonnagePrincipal;

public interface ObjSol {
	
	public void trouverObjSol(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;
	
}
