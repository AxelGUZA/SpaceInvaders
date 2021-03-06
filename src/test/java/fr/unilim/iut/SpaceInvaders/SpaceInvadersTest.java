package fr.unilim.iut.SpaceInvaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import PackException.DebordementEspaceJeuException;
import PackException.HorsEspaceJeuException;
import PackException.MissileException;

public class SpaceInvadersTest {
	  private SpaceInvaders spaceinvaders;
	 @Before
	    public void initialisation() {
		    spaceinvaders = new SpaceInvaders(15, 10);
	    }

	@Test
	public void test_AuDebut_JeuSpaceInvaderEstVide() {
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
					"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		
	}
	
	@Test(expected = HorsEspaceJeuException.class)
	public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,10), 1);
	}@Test
	public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(15,9), 1);
			fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(-1,9), 1);
			fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,10), 1);
			fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
		
		
		try {
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(14,-1), 1);
			fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
		} catch (final HorsEspaceJeuException e) {
		}
			
	}
	 
	 
	 @Test
		public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(1,1),new Position(7,9), 1);
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
			".......V.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
		@Test
		public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 1);
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			".......VVV.....\n" + 
			".......VVV.....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
		@Test
		public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(9,2),new Position(7,9), 1);
				fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,4),new Position(7,1), 1);
				fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
				
		}
		
		 @Test
			public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
				
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(10,9), 3);
				spaceinvaders.deplacerVaisseauVersLaDroite();
				assertEquals("" + 
				"...............\n" + 
				"...............\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"............VVV\n" + 
				"............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 @Test
			public void VaisseauAvance_DeplacerVaisseauVersLaGauche() {
				
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9), 1);
				spaceinvaders.deplacerVaisseauVersLaGauche();
			
				assertEquals("" + 
				"...............\n" + 
				"...............\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"......VVV......\n" + 
				"......VVV......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		    }
		 @Test
			public void VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
				
				spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(1,9), 1);
				spaceinvaders.deplacerVaisseauVersLaGauche();
				
				assertEquals("" + 
				"...............\n" + 
				"...............\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"VVV............\n" + 
				"VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {

		       spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(7,9),3);
		       spaceinvaders.deplacerVaisseauVersLaDroite();
		       assertEquals("" + 
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "..........VVV..\n" + 
		       "..........VVV..\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		   }
		 
		 @Test
		    public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {

			   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3,2),new Position(0,9), 3);
		       spaceinvaders.deplacerVaisseauVersLaGauche();

		       assertEquals("" + 
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       "VVV............\n" + 
		       "VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		     }
		 
		 @Test
	     public void test_MissileBienTireDepuisVaisseau_VaisseauLongueurImpaireMissileLongueurImpaire() {

		   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
		   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       ".......MMM.....\n" + 
	       ".......MMM.....\n" + 
	       ".....VVVVVVV...\n" + 
	       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
		 
		 @Test(expected = MissileException.class)
			public void test_PasAssezDePlacePourTirerUnMissile_UneExceptionEstLevee() throws Exception { 
			   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
			   spaceinvaders.tirerUnMissile(new Dimension(7,9),1);
			}
		 
		 
		 @Test
		    public void test_MissileAvanceAutomatiquement_ApresTirDepuisLeVaisseau() {

			   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
			   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

			   spaceinvaders.deplacerMissile();
			   
		       assertEquals("" + 
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" + 
		       "...............\n" + 
		       ".......MMM.....\n" + 
		       ".......MMM.....\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       ".....VVVVVVV...\n" + 
		       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		   }
		 
		 @Test
		   public void test_MissileDisparait_QuandIlCommenceASortirDeEspaceJeu() {

			   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
			   spaceinvaders.tirerUnMissile(new Dimension(3,2),1);
			   for (int i = 1; i <=6 ; i++) {
				   spaceinvaders.deplacerMissile();
			   }
			   
			   spaceinvaders.deplacerMissile();
			   
		       assertEquals("" +
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" +
		       "...............\n" + 
		       "...............\n" +
		       "...............\n" + 
		       ".....VVVVVVV...\n" + 
		       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		   }
		 
		 /*
		  * 
		  * ENVAHISSEUR TDD TEST
		  * 
		  */
		 
		 
		 @Test
			public void test_unNouveauEnvahisseurEstCorrectementPositionneDansEspaceJeu() {
				SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
				spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(1,1),new Position(7,1), 1);
				assertEquals("" + 
				"...............\n" + 
				".......e.......\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 
		 @Test
			public void test_unEnvahisseurDeplaceAvanceVersLaGAuche() {
				SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
				spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(1,1),new Position(14,1), 1);
				spaceinvaders.deplacerEnvahisseurVersLaDroite();
				assertEquals("" + 
				"...............\n" + 
				"..............e\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 @Test
			public void test_unEnvahisseurDeplaceAvanceVersLaDroite() {
				SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
				spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(1,1),new Position(14,1), 1);
				spaceinvaders.deplacerEnvahisseurVersLaGauche();
				assertEquals("" + 
				"...............\n" + 
				".............e.\n" +
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 @Test
			public void test_unEnvahisseurStatiqueAGAucheApresDeplacement() {
				SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
				spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(2,2),new Position(1,2), 1);
				spaceinvaders.deplacerEnvahisseurVersLaGauche();
				assertEquals("" + 
				"...............\n" + 
				"ee.............\n" +
				"ee.............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
	
		 
		 @Test
			public void test_unEnvahisseurStatiqueADroiteApresDeplacement() {
				SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
				spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(2,2),new Position(13,2), 1);
				spaceinvaders.deplacerEnvahisseurVersLaDroite();
				assertEquals("" + 
				"...............\n" + 
				".............ee\n" +
				".............ee\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" + 
				"...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
			}
		 
		 @Test
		    public void test_MissileAvanceAutomatiquement_ApresTirDepuisLeVaisseau_ToucheEnvahisseur() {

			   spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 2);
			   spaceinvaders.positionnerUnNouveauEnvahisseur(new Dimension(2,2),new Position(7,1), 1);
			   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

			   spaceinvaders.deplacerMissile();
			   
			   
		       assertEquals("" + 
		       ".......ee......\n" + 
		       ".......ee......\n" +
		       "...............\n" + 
		       "...............\n" + 
		       ".......MMM.....\n" + 
		       ".......MMM.....\n" + 
		       "...............\n" + 
		       "...............\n" + 
		       ".....VVVVVVV...\n" + 
		       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		   }
}
