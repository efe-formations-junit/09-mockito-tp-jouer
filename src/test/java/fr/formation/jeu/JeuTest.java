package fr.formation.jeu;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class JeuTest {

	Jeu g;
	
    @Test
    public void pasDeGagnantApres5Essais() {
        De leDe = mock(De.class);
        when(leDe.lancer()).thenReturn(1);

        Joueur p1 =  spy(new Joueur("Jeanne Legrand", leDe));
        Joueur p2 =  spy(new Joueur("Anne Lepetit", leDe));

        g = new Jeu(p1,p2);
        assertFalse(g.jouer().isPresent());
        verify(p1, times(5)).play();
        verify(p2, times(5)).play();
    }


    @Test
    public void andTheWinnerIsP1() {

        Joueur p1 = mock(Joueur.class);
        when(p1.getLastValue()).thenReturn(Optional.of(new Resultat(5)));

        Joueur p2 = mock(Joueur.class);
        when(p2.getLastValue()).thenReturn(Optional.of(new Resultat(2)));

        g = new Jeu(p1,p2);
        assertEquals(p1, g.jouer().get());
    }
    
    @Test
    public void andTheWinnerIsP2() {

        Joueur p1 = mock(Joueur.class);
        when(p1.getLastValue()).thenReturn(Optional.of(new Resultat(1)));

        Joueur p2 = mock(Joueur.class);
        when(p2.getLastValue()).thenReturn(Optional.of(new Resultat(6)));

        g = new Jeu(p1,p2);
        assertEquals(p2, g.jouer().get());
    }
}
