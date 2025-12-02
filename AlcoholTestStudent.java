import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Yousif Aluobaidy
 * Junit tests for Alcohol class.
 */
public class AlcoholTestStudent {
	Alcohol a1, a2, a3, a4;

	@Before
	public void setUp() throws Exception {
		// Weekend false
		a1 = new Alcohol("Vodka", Size.SMALL, false);
		// Weekend true
		a2 = new Alcohol("Gin", Size.MEDIUM, true);
		// Large + Weekend
		a3 = new Alcohol("Whiskey", Size.LARGE, true);
		// For equality check
		a4 = new Alcohol("Vodka", Size.SMALL, false);
	}

	@After
	public void tearDown() throws Exception {
		a1 = a2 = a3 = a4 = null;
	}

	@Test
	public void testCalcPrice() {
		// Small (2.0) + No Weekend = 2.0
		assertEquals(2.0, a1.calcPrice(), 0.01);
		
		// Medium (2.5) + Weekend (0.6) = 3.1
		assertEquals(3.1, a2.calcPrice(), 0.01);
		
		// Large (3.0) + Weekend (0.6) = 3.6
		assertEquals(3.6, a3.calcPrice(), 0.01);
	}

	@Test
	public void testToString() {
		assertTrue(a1.toString().contains("Vodka"));
		assertTrue(a1.toString().contains("SMALL"));
		assertTrue(a1.toString().contains("2.0"));
		
		assertTrue(a2.toString().contains("Gin"));
		assertTrue(a2.toString().contains("Weekend: true"));
	}

	@Test
	public void testEquals() {
		assertTrue(a1.equals(a4));
		assertFalse(a1.equals(a2));
	}
	
	@Test
	public void testIsWeekend() {
		assertFalse(a1.isWeekend());
		assertTrue(a2.isWeekend());
	}
}