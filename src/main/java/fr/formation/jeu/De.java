package fr.formation.jeu;

import java.util.Random;

public class De {

    private final static int FACES = 6;
    private Random rand;

    public De(Random rand) { this.rand = rand; }

    public int lancer() {
        int result = rand.nextInt(FACES) + 1;
        if (result < 1 || result > FACES)
            throw new RuntimeException("Le dé a renvoyé une valeur incompatible");
        return result;
    }
    
    
    
    
}
