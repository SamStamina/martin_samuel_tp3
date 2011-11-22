package ets.log120.tp3.cartes;

/**
 * Classe représentant une carte.
 * @author Martin Desharnais
 */
public class Carte
	implements Comparable<Carte>{

	public static final Carte JOKER = new Carte(Denomination.JOKER, CouleurCarte.JOKER);
	
	// --------------------------------------------------
	// Constructeur(s)
	// --------------------------------------------------

	/**
	 * Constructeur créant une carte à partir d'une dénomination et d'une couleur.
	 */
	public Carte(Denomination d, CouleurCarte c) {
		this.denomination = d;
		this.couleur = c;
	}
	
	// --------------------------------------------------
	// Accesseur(s)
	// --------------------------------------------------

	/**
	 * Retourne la couleur de la carte.
	 */
	public CouleurCarte getCouleur() {
		return couleur;
	}
	
	/**
	 * Retourne la dénomination de la carte.
	 */
	public Denomination getDenomination() {
		return denomination;
	}
	
	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", denomination=" + denomination + "]";
	}
	
	@Override
	public int compareTo(Carte obj) {
		if(obj == null)
				throw new NullPointerException();
		
		if (getDenomination().compareTo(obj.getDenomination()) > 0)
			return 1;
		else if (getDenomination().compareTo(obj.getDenomination()) < 0)
			return -1;
		else {
			if (getCouleur().compareTo(obj.getCouleur()) > 0)
				return 1;
			else if (getCouleur().compareTo(obj.getCouleur()) < 0)
				return -1;
			else
				return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result
				+ ((denomination == null) ? 0 : denomination.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (denomination == null) {
			if (other.denomination != null)
				return false;
		} else if (!denomination.equals(other.denomination))
			return false;
		return true;
	}
	
	// --------------------------------------------------
	// Attribut(s)
	// --------------------------------------------------
	
	private CouleurCarte couleur;
	private Denomination denomination;
}
