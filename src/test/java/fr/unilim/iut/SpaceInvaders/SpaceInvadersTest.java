package fr.unilim.iut.SpaceInvaders;

import org.junit.Test;

public class SpaceInvadersTest {

	@Test
	public void test_AuDebut_JeuSpaceIncvaderEstVide() {
		SpaceInvadersTest spaceinvaders = new SpaceInvadersTest(15,10);
		asserEquals("" + 
		"....................\n"+
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"+ 
		"....................\n"), spaceinvaders.toString());
		
	}
}
