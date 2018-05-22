package fr.unilim.iut.SpaceInvaders;

public class Vaisseau {

	int x;
	int y;

	public Vaisseau(int x, int y) {
		this.x = x;
		this.y = y;
	}
<<<<<<< HEAD

	public boolean occupeLaPosition(int x, int y) {
		return(this.x==x && this.y==y);
	}
	public int abscisse() {
        return this.x;
	}
	public void seDeplacerVersLaDroite() {
	      this.x = this.x + 1 ;
}

	public void seDeplacerVersLaGauche() {
		this.y = this.y + 1;
	}
	public int ordonnee() {
        return this.y;
	}
=======
	
	 public boolean occupeLaPosition(int x, int y) {
			return (this.x==x) && (this.y==y);
		}
>>>>>>> branch 'master' of https://github.com/AxelGUZA/SpaceInvaders.git

}
