package fr.unilim.iut.SpaceInvaders;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpaceInvadersTest {
	
	 private SpaceInvaders spaceinvaders;

	    @Before
	    public void initialisation() {
		    spaceinvaders = new SpaceInvaders(15, 10);
	    }

	@Test
	public void test_AuDebut_JeuSpaceIncvaderEstVide() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15,10);
			assertEquals("" + 
					"...............\n" + 
					"...............\n" +
					"...............\n" + 
					"...............\n" + 
					"...............\n" + 
					"...............\n" + 
					"...............\n" + 
					"...............\n" + 
					"...............\n" + 
					"...............\n" , spaceinvaders.toString());
		
	}
	
	@Test
	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(15,9);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(-1,9);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,10);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(14,-1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
			
	}
	
	
}
