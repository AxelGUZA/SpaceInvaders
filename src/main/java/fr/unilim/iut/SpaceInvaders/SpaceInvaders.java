package fr.unilim.iut.SpaceInvaders;

public class SpaceInvaders {
	
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		StringBuilder espacedeJeu = new StringBuilder();
		for(int x = 0; x < hauteur;x++) {
			for(int y = 0;y < longueur;y++)
			{
				if(vaisseau.occupeLaPosition(x,y))
				{
					espacedeJeu.append('V');
				}
				
				else {
					espacedeJeu.append('.');
				}
			}
			espacedeJeu.append('\n');
		}
		return espacedeJeu.toString();
	}

	public void positionnerUnNouveauVaisseau(int x, int y) {
		this.vaisseau = new Vaisseau(x,y);
	}
	
}
