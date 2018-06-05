package fr.unilim.iut.SpaceInvaders;

public class Envahisseur extends Sprite {
	private boolean doitSeDeplacerVersGauche;

	public Envahisseur(Dimension dimension,Position origine, int vitesse) {
		super(dimension,origine,vitesse);
		this.doitSeDeplacerVersGauche = true;
	}

	public void seDeplacerVersLeBas() {
		this.origine.y += 1;
		
	}
	
	public boolean  doitSeDeplacerVersLaGauche(){
		return this.doitSeDeplacerVersGauche;
	}
	
	public void  ChangementDeDirection(){
		 this.doitSeDeplacerVersGauche = !doitSeDeplacerVersGauche;
	}
	
}
