package fr.formation.jeu;
import java.util.Optional;

public class Joueur {

    private String nom;
    private De de;
    private Optional<Resultat> lastValue = Optional.empty();

    public Joueur(String nom, De de) {
        this.nom = nom;
        this.de = de;
    }

    public void play() {
    	int a = de.lancer();
    	int b = de.lancer();
        this.lastValue = Optional.of(new Resultat(Math.max(a, b)));
    }

    public Optional<Resultat> getLastValue() {
        return lastValue;
    }

}