import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Yousif Aluobaidy
 * Junit tests for Smoothie class.
 */
public class SmoothieTestStudent {
	Smoothie s1, s2, s3, s4;

	@Before
	public void setUp() throws Exception {
		// No extras
		s1 = new Smoothie("Banana", Size.SMALL, 0, false);
		// 2 Fruits
		s2 = new Smoothie("Strawberry", Size.MEDIUM, 2, false);
		// 3 Fruits + Protein
		s3 = new Smoothie("Green", Size.LARGE, 3, true);
		// For equality
		s4 = new Smoothie("Banana", Size.SMALL, 0, false);
	}

	@After
	public void tearDown() throws Exception {
		s1 = s2 = s3 = s4 = null;
	}

	@Test
	public void testCalcPrice() {
		// Small (2.0) = 2.0
		assertEquals(2.0, s1.calcPrice(), 0.01);
		
		// Medium (2.5) + 2 Fruits (1.0) = 3.5
		assertEquals(3.5, s2.calcPrice(), 0.01);
		
		// Large (3.0) + 3 Fruits (1.5) + Protein (1.5) = 6.0
		assertEquals(6.0, s3.calcPrice(), 0.01);
	}

	@Test
	public void testToString() {
		assertTrue(s1.toString().contains("Banana"));
		assertTrue(s3.toString().contains("Protein: true"));
		assertTrue(s2.toString().contains("Fruits: 2"));
	}

	@Test
	public void testEquals() {
		assertTrue(s1.equals(s4));
		assertFalse(s1.equals(s2));
	}
	
	@Test
	public void testGetters() {
		assertEquals(2, s2.getNumOfFruits());
		assertTrue(s3.getAddProtein());
	}
}