package personnages;

import donjon.Salle;

public interface PNJ {
		
	public void rencontrer(Salle salle, PersonnagePrincipal joueur) throws InterruptedException;

}
