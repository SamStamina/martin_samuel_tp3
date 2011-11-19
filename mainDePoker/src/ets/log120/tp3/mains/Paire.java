package ets.log120.tp3.mains;

import java.util.Map;
import java.util.TreeMap;

import ets.log120.tp3.cartes.Carte;
import ets.log120.tp3.cartes.Denomination;

public class Paire extends AbstractAnalyseurRang {
	@Override
	protected boolean reconnaitreMain(ReqAnalyseMain contexte) {
		TreeMap<Denomination, Integer> map = AnalyseurUtil.compterDenominations(contexte.getMain());
		
		Denomination paire = null;
		Denomination kicker = null;

		Integer nombreJoker = map.remove(Denomination.JOKER);
		if (nombreJoker == null)
			nombreJoker = 0;
		
		for (Map.Entry<Denomination, Integer> entry : map.entrySet()) {
			
			if (paire == null && (entry.getValue() >= 2
					|| (entry.getValue() == 1 && nombreJoker-- >= 1)))
				paire = entry.getKey();
			else if (kicker == null)
				kicker = entry.getKey();
			
			if (paire != null && kicker != null) {
				contexte.setRangReconnu(new RangPokerPaire(paire, kicker));
				return true;
			}
		}
		
		return false;
	}
	
}