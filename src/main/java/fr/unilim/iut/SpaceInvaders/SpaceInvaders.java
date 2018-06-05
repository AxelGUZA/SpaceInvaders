package fr.unilim.iut.SpaceInvaders;

import Exepections.DebordementEspaceJeuException;
import Exepections.HorsEspaceJeuException;
<<<<<<< HEAD
import fr.unilim.iut.SpaceInvaders.moteurjeu.Commande;
import fr.unilim.iut.SpaceInvaders.moteurjeu.Constante;
import fr.unilim.iut.SpaceInvaders.moteurjeu.Jeu;
=======
import Exepections.MissileException;
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git

<<<<<<< HEAD

public class SpaceInvaders implements Jeu {

	private static final char MARQUE_FIN_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
=======
public class SpaceInvaders {
	
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
	int longueur;
	int hauteur;
	Vaisseau vaisseau;
<<<<<<< HEAD

=======
	Missile missile;
	Envahisseur envahisseur;
	
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	
	  public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
			
		   if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
							
		   this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
      }
   

	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau,3);
	}
	//ancien toString
	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
<<<<<<< HEAD
			marque = MARQUE_VAISSEAU;
=======
			marque= Constante.MARQUE_VAISSEAU;
		else if (this.aUnMissileQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_MISSILE;
		else if(this.aUnEnvahisseurQuiOccupeLaPosition(x,y))
			marque = Constante.MARQUE_ENVAHISSEUR;
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
		else
<<<<<<< HEAD
			marque = MARQUE_VIDE;
=======
			marque=Constante.MARQUE_VIDE;
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
		return marque;
	}

	private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
		return aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	private boolean aUnEnvahisseur() {
		return envahisseur!=null;
	}

	private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return aUnMissile() && missile.occupeLaPosition(x, y);
	}
	

	private boolean aUnMissile() {
		return missile!=null;
	}

	private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return vaisseau != null;
	}

	  public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {
			
			int x = position.abscisse();
			int y = position.ordonnee();
			
			if (nEstPasDansEspaceDeJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			int longueurVaisseau = dimension.longueur();
			int hauteurVaisseau = dimension.hauteur();
			
			if (debordeADroite(x, y, longueurVaisseau))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
			if (debordeAGauche(x, y, hauteurVaisseau))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

			vaisseau = new Vaisseau(dimension,position,vitesse);
		}
	  
	private boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}



	public void deplacerVaisseauVersLaGauche() {
				 if (vaisseau.abscisseLaPlusAGauche()< (longueur-1)) 
					 vaisseau.seDeplacerVersLaGauche();
				
				if (0 < vaisseau.abscisseLaPlusAGauche())
					vaisseau.seDeplacerVersLaGauche();
				if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
					vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
				}
		 	}
	public void deplacerVaisseauVersLaDroite() {
	if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
		vaisseau.seDeplacerVersLaDroite();
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
			vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
			}
		}
	}
	public Vaisseau recupererVaisseau() {
		return this.vaisseau;
	
		}
	
	@Override
	public void evoluer(Commande commandeUser) {

<<<<<<< HEAD
		if (commandeUser.gauche) {
			deplacerVaisseauVersLaGauche();
		}
=======
	public String recupererEspaceJeuDansChaineASCII() {
        StringBuilder espaceDeJeu = new StringBuilder();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < longueur; x++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git

		if (commandeUser.droite) {
			deplacerVaisseauVersLaDroite();
		}
	}
	
<<<<<<< HEAD
	@Override
	public boolean etreFini() {
		return false;

	}

}
=======
	/*
	 * 
	 * Modification ENVAHISSEUR
	 * 
	 */
	
	private boolean aUnEnvahisseurQuiOccupeLaPosition1(int x, int y) {
		return aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	private boolean aUnEnvahisseur1() {
		return envahisseur!=null;
	}

	public void positionnerUnNouveauEnvahisseur(Dimension dimension, Position position, int vitesse) {
		int x = position.abscisse();
		int y = position.ordonnee();
		
		if (nEstPasDansEspaceDeJeu(x, y))
			throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

		int longueurEnvahisseur = dimension.longueur();
		int hauteurEnvahisseur = dimension.hauteur();
		
		if (debordeADroite(x, y, longueurEnvahisseur))
			throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (debordeAGauche(x, y, hauteurEnvahisseur))
			throw new DebordementEspaceJeuException("L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");

		envahisseur = new Envahisseur(dimension,position,vitesse);
		
	}

	private boolean debordeAGauche(int x, int y, int hauteurEnvahisseur) {
		return !estDansEspaceJeu(x, y - hauteurEnvahisseur + 1);
	}

	private boolean debordeADroite(int x, int y, int longueurEnvahisseur) {
		return !estDansEspaceJeu(x + longueurEnvahisseur - 1, y);
	}

	private boolean nEstPasDansEspaceDeJeu(int x, int y) {
		return !estDansEspaceJeu(x, y);
	}

	public void deplacerEnvahisseurVersLaGauche() {
		if (0 < envahisseur.abscisseLaPlusAGauche())
			envahisseur.seDeplacerVersLaGauche();
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
		}
		else  if(envahisseur.abscisseLaPlusAGauche() <= 0)
		{
			envahisseur.seDeplacerVersLeBas();
			
		}
		
	}

	public void deplacerEnvahisseurVersLaDroite() {
		if (envahisseur.abscisseLaPlusADroite() < (longueur - 1)) {
			envahisseur.seDeplacerVersLaDroite();
			if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
				envahisseur.positionner(longueur - envahisseur.longueur(), envahisseur.ordonneeLaPlusHaute());
			}
		}else  if(envahisseur.abscisseLaPlusADroite() > longueur)
		{
			envahisseur.seDeplacerVersLeBas();
			
		}
		
	}

	public void automatiquementDeplacerEnvahisseur() {
		
	}
	
	
	
	
}
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
