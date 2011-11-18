package ets.log120.tp3.mains;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.CouleurCarte;
import ets.log120.tp3.cartes.Denomination;
import junit.framework.TestCase;

public class RangPokerPaireTest extends TestCase {
	public void testDifferentePaire()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		mainSuperieure.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.DEUX,  CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		mainInferieure.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.HUIT,  CouleurCarte.PIQUE));
		mainInferieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Paire().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Paire().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
	public void testPairesMemePaireDifferentKicker()
	{
		Main mainSuperieure = new Main();
		mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		mainSuperieure.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		mainSuperieure.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		mainSuperieure.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
		
		Main mainInferieure = new Main();
		mainInferieure.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		mainInferieure.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		mainInferieure.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		mainInferieure.add(new Carte(Denomination.HUIT,  CouleurCarte.PIQUE));
		
		ReqAnalyseMain requeteMainSuperieure = new ReqAnalyseMain(mainSuperieure);
		ReqAnalyseMain requeteMainInferieure = new ReqAnalyseMain(mainInferieure);
		
		assertTrue(new Paire().reconnaitreMain(requeteMainSuperieure));
		assertTrue(new Paire().reconnaitreMain(requeteMainInferieure));
		
		RangPoker rangMainSuperieure = requeteMainSuperieure.getRangReconnu();
		RangPoker rangMainInferieure = requeteMainInferieure.getRangReconnu();
		
		assertTrue(rangMainSuperieure.compareTo(rangMainInferieure) > 0);
		assertTrue(rangMainInferieure.compareTo(rangMainSuperieure) < 0);
	}
	
	public void testMemePaireMemeKicker()
	{
		Main main1 = new Main();
		main1.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main1.add(new Carte(Denomination.TROIS, CouleurCarte.PIQUE));
		main1.add(new Carte(Denomination.DEUX,  CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.SEPT,  CouleurCarte.COEUR));
		main1.add(new Carte(Denomination.DIX,   CouleurCarte.TREFLE));
		
		Main main2 = new Main();
		main2.add(new Carte(Denomination.TROIS, CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.TROIS, CouleurCarte.COEUR));
		main2.add(new Carte(Denomination.CINQ,  CouleurCarte.TREFLE));
		main2.add(new Carte(Denomination.SIX,   CouleurCarte.CARREAU));
		main2.add(new Carte(Denomination.DIX,   CouleurCarte.PIQUE));
		
		ReqAnalyseMain requeteMain1 = new ReqAnalyseMain(main1);
		ReqAnalyseMain requeteMain2 = new ReqAnalyseMain(main2);
		
		assertTrue(new Paire().reconnaitreMain(requeteMain1));
		assertTrue(new Paire().reconnaitreMain(requeteMain2));
		
		RangPoker rangMain1 = requeteMain1.getRangReconnu();
		RangPoker rangMain2 = requeteMain2.getRangReconnu();
		
		assertTrue(rangMain1.compareTo(rangMain2) == 0);
		assertTrue(rangMain2.compareTo(rangMain1) == 0);
	}
}
