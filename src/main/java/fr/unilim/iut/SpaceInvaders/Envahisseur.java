package fr.unilim.iut.SpaceInvaders;

public class Envahisseur extends Sprite {

	public Envahisseur(Dimension dimension,Position origine, int vitesse) {
		super(dimension,origine,vitesse);
	}

	public void seDeplacerVersLeBas() {
		this.origine.y += 1;
		
	}
	
}
