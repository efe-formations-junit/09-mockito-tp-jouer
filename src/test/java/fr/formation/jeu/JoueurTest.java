package fr.formation.jeu;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class JoueurTest {

    Joueur p;
    
    @Test
    public void lastValueNonInitialisee() {
        p = new Joueur("Jeanne Legrand", new De(new Random()));
        assertFalse(p.getLastValue().isPresent());
    }

    @Test
    public void lastValueInitialisee() {
        p = new Joueur("Jeanne Legrand", new De(new Random()));
        p.play();
        assertTrue(p.getLastValue().isPresent());
    }

    @Test
    public void leDeEstLanceExactementDeuxFoisParJeu() {
        De d = mock(De.class);
        p = new Joueur("Jeanne Legrand", d);
        p.play();
        verify(d, times(2)).lancer();
    }
    
    @Test
    public void testMaximumSurJeu() {
        De d = mock(De.class);
        p = new Joueur("Jeanne Legrand", d);

        when(d.lancer()).thenReturn(2,5);
        p.play();
        assertEquals(p.getLastValue().get(), new Resultat(5));
        
        when(d.lancer()).thenReturn(6).thenReturn(1);
        p.play();
        assertEquals(p.getLastValue().get(), new Resultat(6));
        
    }
    
}