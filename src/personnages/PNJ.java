package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public interface PNJ {
		
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;

}
