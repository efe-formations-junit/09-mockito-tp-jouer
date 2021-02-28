
package fr.formation.jeu;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DeTest {

	De leDe;

	@Test
	public void rollReturnsAValue() {
		leDe = new De(new Random());
		for (int i = 0; i < 100; i++) {
			int result = leDe.lancer();
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}

	@Test
	public void identifyBadValuesGreaterThanNumberOfFaces() {
		Random tooMuch = mock(Random.class);
		when(tooMuch.nextInt(anyInt())).thenReturn(7);
		leDe = new De(tooMuch);
		assertThrows(RuntimeException.class, () -> {
			leDe.lancer();
		} );
	}
	
    @Test
    public void identifyBadValuesLesserThanOne() {
        Random notEnough = mock(Random.class);
        when(notEnough.nextInt(anyInt())).thenReturn(-1);
        leDe = new De(notEnough);
		assertThrows(RuntimeException.class, () -> {
			leDe.lancer();
		} );
    }
	

}
