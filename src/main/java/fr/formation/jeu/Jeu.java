package fr.formation.jeu;

import java.util.Optional;

public class Jeu {

    private Joueur gauche;
    private Joueur droit;

    public Jeu(Joueur gauche, Joueur droit) {
        this.gauche = gauche;
        this.droit = droit;
    }

    public Optional<Joueur> jouer() {
        int counter = 0;
        while(counter < 5) {
            gauche.play();  Resultat l = gauche.getLastValue().get();
            droit.play(); Resultat r = droit.getLastValue().get();

            int cmp = l.compareTo(r);
            
            if(cmp > 0 )      { return Optional.of(gauche);  }
            else if (cmp < 0) { return Optional.of(droit); }

            counter++;
        }
        return Optional.empty();
    }
    
}

