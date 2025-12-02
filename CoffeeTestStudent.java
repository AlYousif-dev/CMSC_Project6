import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Yousif Aluobaidy
 * Junit tests for Coffee class.
 */
public class CoffeeTestStudent {
	Coffee c1, c2, c3, c4;

	@Before
	public void setUp() throws Exception {
		// Plain
		c1 = new Coffee("Latte", Size.SMALL, false, false);
		// Extra Shot only
		c2 = new Coffee("Mocha", Size.MEDIUM, true, false);
		// Extra Shot + Extra Syrup
		c3 = new Coffee("Espresso", Size.LARGE, true, true);
		// For equality check
		c4 = new Coffee("Latte", Size.SMALL, false, false);
	}

	@After
	public void tearDown() throws Exception {
		c1 = c2 = c3 = c4 = null;
	}

	@Test
	public void testCalcPrice() {
		// Small (2.0) = 2.0
		assertEquals(2.0, c1.calcPrice(), 0.01);
		
		// Medium (2.5) + Shot (0.5) = 3.0
		assertEquals(3.0, c2.calcPrice(), 0.01);
		
		// Large (3.0) + Shot (0.5) + Syrup (0.5) = 4.0
		assertEquals(4.0, c3.calcPrice(), 0.01);
	}

	@Test
	public void testToString() {
		assertTrue(c1.toString().contains("Latte"));
		assertTrue(c2.toString().contains("Extra Shot: true"));
		assertTrue(c3.toString().contains("Extra Syrup: true"));
	}

	@Test
	public void testEquals() {
		assertTrue(c1.equals(c4));
		assertFalse(c1.equals(c2));
	}
	
	@Test
	public void testGetters() {
		assertTrue(c2.getExtraShot());
		assertFalse(c2.getExtraSyrup());
	}
}