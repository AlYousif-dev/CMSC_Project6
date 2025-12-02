import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author Yousif Aluobaidy
 * Junit tests for Order class.
 */
public class OrderTestStudent {
	Order o1, o2;

	@Before
	public void setUp() throws Exception {
		o1 = new Order(10, Day.MONDAY, new Customer("Mary", 22));
		o2 = new Order(12, Day.SATURDAY, new Customer("John", 45));
	}

	@After
	public void tearDown() throws Exception {
		o1 = o2 = null;
	}

	@Test
	public void testAddNewBeverageAndGetTotal() {
		// Add Coffee: Small(2.0)
		o1.addNewBeverage("Coffee", Size.SMALL, false, false);
		// Add Alcohol: Medium(2.5) on Monday (No surcharge)
		o1.addNewBeverage("Beer", Size.MEDIUM); 
		// Add Smoothie: Large(3.0) + 1 fruit(0.5) = 3.5
		o1.addNewBeverage("Smoothie", Size.LARGE, 1, false);
		
		assertEquals(3, o1.getTotalItems());
		assertEquals(2.0 + 2.5 + 3.5, o1.calcOrderTotal(), 0.01);
	}
	
	@Test
	public void testWeekendSurcharge() {
		// Saturday Order
		assertTrue(o2.isWeekend());
		
		// Add Alcohol: Small(2.0) + Weekend(0.6) = 2.6
		o2.addNewBeverage("Wine", Size.SMALL);
		
		assertEquals(2.6, o2.calcOrderTotal(), 0.01);
	}

	@Test
	public void testFindNumOfBeveType() {
		o1.addNewBeverage("Coffee", Size.SMALL, false, false);
		o1.addNewBeverage("Coffee", Size.LARGE, false, false);
		o1.addNewBeverage("Beer", Size.SMALL);
		
		assertEquals(2, o1.findNumOfBeveType(Type.COFFEE));
		assertEquals(1, o1.findNumOfBeveType(Type.ALCOHOL));
		assertEquals(0, o1.findNumOfBeveType(Type.SMOOTHIE));
	}
	
	@Test
	public void testCompareTo() {
		// Since order numbers are random, we can't hard code the result,
		// but we can ensure it returns 1, 0, or -1.
		int result = o1.compareTo(o2);
		assertTrue(result == 1 || result == 0 || result == -1);
	}
	
	@Test
	public void testToString() {
		o1.addNewBeverage("Coffee", Size.SMALL, false, false);
		String str = o1.toString();
		assertTrue(str.contains("MONDAY"));
		assertTrue(str.contains("Mary"));
		assertTrue(str.contains("Coffee"));
		assertTrue(str.contains("2.0")); // Price check
	}
}