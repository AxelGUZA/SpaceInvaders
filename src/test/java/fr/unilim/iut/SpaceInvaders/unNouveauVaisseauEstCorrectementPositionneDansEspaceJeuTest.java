package fr.unilim.iut.SpaceInvaders;

import static org.junit.Assert.assertEquals;

import org.junit.Test;




public class unNouveauVaisseauEstCorrectementPositionneDansEspaceJeuTest {
	
	
	 @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropADroite_UneExceptionEstLevee() throws Exception {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(15,9));
	 }


}
