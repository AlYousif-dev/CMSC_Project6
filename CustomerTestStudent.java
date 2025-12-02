import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Yousif Aluobaidy
 * Junit tests for Customer class.
 */
public class CustomerTestStudent {
	Customer c1, c2;

	@Before
	public void setUp() throws Exception {
		c1 = new Customer("John", 25);
		c2 = new Customer(c1); // Test copy constructor
	}

	@After
	public void tearDown() throws Exception {
		c1 = c2 = null;
	}

	@Test
	public void testConstructorsAndGetters() {
		assertEquals("John", c1.getName());
		assertEquals(25, c1.getAge());
		
		// Copy constructor check
		assertEquals("John", c2.getName());
		assertEquals(25, c2.getAge());
	}
	
	@Test
	public void testSetters() {
		c1.setName("Alex");
		c1.setAge(30);
		assertEquals("Alex", c1.getName());
		assertEquals(30, c1.getAge());
		
		// Ensure c2 (copy) didn't change
		assertEquals("John", c2.getName());
	}

	@Test
	public void testToString() {
		assertTrue(c1.toString().contains("John"));
		assertTrue(c1.toString().contains("25"));
	}
}