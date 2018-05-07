package fr.unilim.iut.SpaceInvaders;

public class SpaceInvaders {
	
	int longueur;
	int hauteur;
	
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		StringBuilder espacedeJeu = new StringBuilder();
		for(int i = 0; i < hauteur;i++) {
			for(int j = 0;j < longueur;j++)
			{
				espacedeJeu.append('.');
			}
			espacedeJeu.append('\n');
		}
		return espacedeJeu.toString();
	}
	
}
