package fr.formation.jeu;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultatTest {
	
	Resultat pr1;
	Resultat pr2;
	
	@BeforeEach
	public void setUp() {
	  pr1 = new Resultat(5);
	  pr2 = new Resultat(2);
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(pr1.compareTo(pr2) > 0);
		assertTrue(pr2.compareTo(pr1) < 0);
		assertTrue(pr1.compareTo(pr1) == 0);
		assertTrue(pr1.compareTo(new Resultat(5)) == 0);
	}
	
	@Test
	public void testEquals() {
		assertEquals(pr1,pr1);
		assertEquals(pr1,new Resultat(5));
		assertNotEquals(pr1,pr2);		
	}

}
