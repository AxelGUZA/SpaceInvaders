package fr.unilim.iut.SpaceInvaders;

public class SpaceInvaders {
	
	private static final char MARQUE_FIN_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	private static final char MARQUE_VAISSEAU = 'V';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_ESPACE = '\n';
	
	
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	@Override
	public String toString() {
		StringBuilder espaceDeJeu = new StringBuilder();
<<<<<<< HEAD
=======
		
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
<<<<<<< HEAD
			espaceDeJeu.append(MARQUE_FIN_LIGNE);
=======
			    
			espaceDeJeu.append(MARQUE_ESPACE);
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
		}
		return espaceDeJeu.toString();
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			marque=MARQUE_VAISSEAU;
		else
<<<<<<< HEAD
			marque=MARQUE_VIDE;
=======
		      marque=MARQUE_VIDE;
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
		return marque;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	private boolean aUnVaisseau() {
		return vaisseau!=null;
	}

	public void positionnerUnNouveauVaisseau(int x, int y) {
		if (  !estDansEspaceJeu(x, y) )
<<<<<<< HEAD
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 
	}

	private boolean estDansEspaceJeu(int x, int y) {
		return (x >= 0) && (x < longueur) && (y >= 0) && (y < hauteur);
	}

	public void deplacerVaisseauVersLaDroite() {
	        if (vaisseau.abscisse()< (longueur-1)) vaisseau.seDeplacerVersLaDroite();
	}

	public Object recupererEspaceJeuDansChaineASCII() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deplacerVaisseauVersLaGauche() {
		 if (vaisseau.ordonnee()< (longueur-1)) vaisseau.seDeplacerVersLaGauche();
		
=======
			throw new HorsEspaceJeuException("Vous êtes en dehors de l'espace jeu");
	
		vaisseau = new Vaisseau(x, y); 
	}

	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
	}
	
}
