package fr.unilim.iut.SpaceInvaders;

public class Vaisseau {
	int x;
	int y;
	
	public Vaisseau(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean occupeLaPosition(int x2, int y2) {
		return(this.x==x) && (this.y==y);
	}

}
