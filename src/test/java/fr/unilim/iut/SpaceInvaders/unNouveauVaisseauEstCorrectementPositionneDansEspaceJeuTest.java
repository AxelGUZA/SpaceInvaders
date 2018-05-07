package fr.unilim.iut.SpaceInvaders;

import org.junit.Test;

public class unNouveauVaisseauEstCorrectementPositionneDansEspaceJeuTest {
	
	@Test
	public void unNouveauVaisseauEstCorrectementPositionneDansEspaceJeuTest()
	{
		SpaceInvaders spaceunvaders = new SpaceInvaders(15,10);
		spaceinvaders.positionnerUnNouveauVaisseau(7,9);
		assertEquals("" + "...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......V.......\n" , spaceinvaders.toString());
	}

}
