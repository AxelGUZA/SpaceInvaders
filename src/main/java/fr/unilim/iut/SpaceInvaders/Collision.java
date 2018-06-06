package fr.unilim.iut.SpaceInvaders;

public class Collision {
	private Sprite entiter1;
	private Sprite entiter2;
	
	public Collision(Sprite entiter1,Sprite entiter2){
		this.entiter1 =  entiter1;
		this.entiter2 = entiter2;
		
	}

	
	public boolean detecterCollision() {
		
		
		return collisionEntreEntiter1EtEntiter2();
	}


	private boolean collisionEntreEntiter1EtEntiter2() {
		if(comparerCoinBas() && entiter1.abscisseLaPlusADroite() <= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() >= entiter2.abscisseLaPlusAGauche()) {
			return true;
		}
		
		if(comparerCoinHaut() && entiter1.abscisseLaPlusADroite() >= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() <= entiter2.abscisseLaPlusAGauche())
		{
			return true;
		}
		/*if(comparerCoinBas() && entiter1.abscisseLaPlusADroite() <= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() >= entiter2.abscisseLaPlusAGauche()) {
            return true;
        }*/
        
        if(comparerCoinBas() && entiter1.abscisseLaPlusADroite() <= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() <= entiter2.abscisseLaPlusAGauche())
        {
            return true;
        }
		/*if( comparerCoinHaut() && entiter1.abscisseLaPlusADroite() >= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() >= entiter2.abscisseLaPlusAGauche())
		{
			return true;
		}
		
		if(comparerCoinHaut() && entiter1.abscisseLaPlusADroite() <= entiter2.abscisseLaPlusADroite() && entiter1.abscisseLaPlusAGauche() >= entiter2.abscisseLaPlusAGauche())
		{
			return true;
		}*/
		
		return false;
	}


	private boolean comparerCoinHaut() {
		return entiter1.ordonneeLaPlusHaute() >= entiter2.ordonneeLaPlusHaute();
	}


	private boolean comparerCoinBas() {
		return entiter1.ordonneeLaPlusHaute() <= entiter2.ordonneeLaPlusHaute();
	}

	
}
