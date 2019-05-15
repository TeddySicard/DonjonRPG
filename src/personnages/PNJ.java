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
	 * @throws InterruptedException
	 */
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;

}
