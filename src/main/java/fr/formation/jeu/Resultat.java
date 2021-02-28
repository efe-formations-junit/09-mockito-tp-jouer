package fr.formation.jeu;

public class Resultat implements Comparable<Resultat> {

	private int valeur;
	
	public Resultat(int val) {
		this.valeur = val;
	}

	public int get() { // int -> dette technique si on veut s'abstraire de Dice
		return valeur;
	}
	
	public int compareTo(Resultat o) {
		int otherVal = o.get();
		return valeur < otherVal ? -1 : valeur > otherVal ? +1 : 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Resultat)
			return (valeur == ((Resultat)obj).get());
		return false;
	}
	
	

}
