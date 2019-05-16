package personnages;

import donjon.Salle;

/**
 * 
 * @author Ted
 *
 */
public interface PNJ {

	/**
	 * Represent the event of a NPC meeting the player
	 * 
	 * @param salle  is the room where the player meets the NPC
	 * @param joueur is the player met by the NPC
	 * @throws InterruptedException to avoid errors (It should never get into this
	 *                              exception)
	 */
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;

}
