package fr.unilim.iut.SpaceInvaders;

import java.util.*;
import Exepections.MissileException;

public class Vaisseau extends Sprite {

<<<<<<< HEAD
<<<<<<< HEAD
	private Position origine;
	private Dimension dimension;
    private int vitesse;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
=======


	public Vaisseau(Dimension dimension, Position positionOrigine,int vitesse) {
		super(dimension, positionOrigine, vitesse);
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git
	}
	
	

	public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		if(dimensionMissile.longueur > this.dimension.longueur)
			throw new MissileException("La longueur du missile est supérieure à celle du vaisseau");

			Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);

			return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
		
	}
		
		
	private Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

		int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		return new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
	}
	
	

	public Vaisseau(int longueur, int hauteur, int x, int y) {
		this(new Dimension(longueur, hauteur), new Position(x, y));
	}


    public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
	    this.dimension = dimension;
	    this.origine = positionOrigine;
	    this.vitesse = vitesse;
    }
    
    public Vaisseau(Dimension dimension, Position positionOrigine) {
		this(dimension, positionOrigine, 1);
    }
    public Vaisseau(Dimension dimension, Position positionOrigine,int vitesse) {
		super(dimension, positionOrigine, vitesse);
    }
	public boolean occupeLaPosition(int x, int y) {
		return estAbscisseCouverte(x) && estOrdonneeCouverte(y);
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int ordonneeLaPlusBasse() {
		return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	public int ordonneeLaPlusHaute() {
		return this.origine.ordonnee();
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse() + this.dimension.longueur() - 1;
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

   public void seDeplacerVersLaDroite() {
	   this.origine.changerAbscisse(this.origine.abscisse() + vitesse);
   }

   public void seDeplacerVersLaGauche() {
	   this.origine.changerAbscisse(this.origine.abscisse() - vitesse);
   }


	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}


	public int longueur() {
	
		return this.dimension.longueur;
	}
	
	public int hauteur() {
	
		return this.dimension.hauteur;
	}
}