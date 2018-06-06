package fr.unilim.iut.SpaceInvaders;


import PackException.DebordementEspaceJeuException;
import PackException.HorsEspaceJeuException;
import PackException.MissileException;
import fr.unilim.iut.SpaceInvaders.moteurjeu.Commande;
import fr.unilim.iut.SpaceInvaders.moteurjeu.Jeu;


public class SpaceInvaders implements Jeu {

	int longueur;
	int hauteur;
	Vaisseau vaisseau;
	Missile missile;
	Envahisseur envahisseur;
	Collision collision;
	

	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}
	
	  public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
			
		   if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
			
		   if(!this.aUnMissile()){
			   this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
		   }
      }
   

	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau,Constante.VAISSEAU_VITESSE);
		Position positionEnvahisseur = new Position(this.longueur/2,Constante.POSITION_ORIGINE_ENVAHISEUR);
		Dimension dimensionEnvahisseur= new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
		
		positionnerUnNouveauEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
	}
	//ancien toString
	

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque = '.';
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			marque= Constante.MARQUE_VAISSEAU;
		else if (this.aUnMissileQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_MISSILE;
		else if(this.aUnEnvahisseurQuiOccupeLaPosition(x,y))
			marque=Constante.MARQUE_ENVAHISSEUR;
		else 
			marque=Constante.MARQUE_VIDE;
		return marque;
	}


	private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return aUnMissile() && missile.occupeLaPosition(x, y);
	}
	

	public boolean aUnMissile() {
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

				if (0 < vaisseau.abscisseLaPlusAGauche())
					vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);;
				if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
					vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
				}
		 	}
	public void deplacerVaisseauVersLaDroite() {

	if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
		vaisseau.deplacerHorizontalementVers(Direction.DROITE);;
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


		if (commandeUser.gauche) {
			deplacerVaisseauVersLaGauche();
		}

		if (commandeUser.droite) {
			deplacerVaisseauVersLaDroite();
		}
		
		if (commandeUser.tir){
			tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
		}
		
		if (this.aUnMissile()){
			deplacerMissile();
			}
		
		
		
		if(this.aUnEnvahisseur()){
			if(envahisseur.doitSeDeplacerVersLaGauche()){
				deplacerEnvahisseurVersLaGauche();
				if(envahisseur.abscisseLaPlusAGauche() == 0){
					envahisseur.ChangementDeDirection();
				}
			}else {
				deplacerEnvahisseurVersLaDroite();
				if(envahisseur.abscisseLaPlusADroite() == this.longueur-1){
					envahisseur.ChangementDeDirection();
				}
			}
			
		}
		
		if(this.aUnMissile() && this.aUnEnvahisseur()) {
			envahisseurTouche();
		}
		
	}

	public void envahisseurTouche() {
		collision = new Collision(missile,envahisseur);
		if(collision.detecterCollision()) {
			envahisseur = null;
			missile = null;
		}

	}

	public boolean emplacementADroite() {
		return envahisseur.abscisseLaPlusADroite() < (longueur - 2);
	}

	public boolean emplacementAGauche() {
		return 1 < envahisseur.abscisseLaPlusAGauche();
	}
	

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


	@Override
	public boolean etreFini() {
		return false;

	}
	
	public void deplacerMissile() {
		missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		if ( missile.ordonneeLaPlusHaute() <= 0){
			this.missile =null;
		}
		
	}

	public Missile recupererMissile() {
		return this.missile;
	}




	/*
	 * 
	 * Modification ENVAHISSEUR
	 * 
	 */
	
	public boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
		return aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	public boolean aUnEnvahisseur() {
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
			envahisseur.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
		}
	}

	public void deplacerEnvahisseurVersLaDroite() {
		if (envahisseur.abscisseLaPlusADroite() < (longueur - 1)) {
			envahisseur.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
				envahisseur.positionner(longueur - envahisseur.longueur(), envahisseur.ordonneeLaPlusHaute());
			}
		}
	}
	
	
	public Envahisseur recupererEnvahisseur() {
		return this.envahisseur;
	}
	
	
}
