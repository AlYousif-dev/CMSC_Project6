import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    BevShop shop;

    @Before
    public void setUp() throws Exception {
        shop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        shop = null;
    }

    @Test
    public void testStartNewOrderAndGetCurrentOrder() {
        shop.startNewOrder(10, Day.MONDAY, "Alex", 25);
        assertNotNull(shop.getCurrentOrder());
        assertEquals("Alex", shop.getCurrentOrder().getCustomer().getName());
        assertEquals(10, shop.getCurrentOrder().getOrderTime());
        assertEquals(Day.MONDAY, shop.getCurrentOrder().getOrderDay());
    }

    @Test
    public void testIsValidTime() {
        assertTrue(shop.isValidTime(8));
        assertTrue(shop.isValidTime(23));
        assertFalse(shop.isValidTime(7));
        assertFalse(shop.isValidTime(24));
    }

    @Test
    public void testIsValidAge() {
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(18));
    }

    @Test
    public void testProcessCoffeeOrder() {
        shop.startNewOrder(12, Day.TUESDAY, "Sam", 30);
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);

        Beverage b = shop.getCurrentOrder().getBeverage(0);
        assertEquals(Type.COFFEE, b.getType());
        assertEquals("Latte", b.getBevName());
    }

    @Test
    public void testProcessSmoothieOrder() {
        shop.startNewOrder(9, Day.FRIDAY, "Kelly", 19);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        Beverage b = shop.getCurrentOrder().getBeverage(0);
        assertEquals(Type.SMOOTHIE, b.getType());
        assertEquals("Berry Blast", b.getBevName());
    }

    @Test
    public void testProcessAlcoholOrder_Valid() {
        shop.startNewOrder(20, Day.SATURDAY, "Mike", 30);

        shop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(Type.ALCOHOL, shop.getCurrentOrder().getBeverage(0).getType());
    }

    @Test
    public void testProcessAlcoholOrder_InvalidAge() {
        shop.startNewOrder(20, Day.SATURDAY, "Jake", 18);

        shop.processAlcoholOrder("Beer", Size.SMALL);

        // Should NOT add because age < 21
        assertEquals(0, shop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testIsEligibleForMoreAlcohol() {
        shop.startNewOrder(20, Day.SATURDAY, "Mark", 35);

        shop.processAlcoholOrder("Beer1", Size.SMALL);
        shop.processAlcoholOrder("Beer2", Size.SMALL);
        shop.processAlcoholOrder("Beer3", Size.SMALL);

        // Now at max
        assertFalse(shop.isEligibleForMore());
    }

    @Test
    public void testFindOrder() {
        shop.startNewOrder(12, Day.SUNDAY, "Sara", 22);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        assertEquals(0, shop.findOrder(orderNo));
        assertEquals(-1, shop.findOrder(99999)); 
    }

    @Test
    public void testTotalOrderPrice() {
        shop.startNewOrder(12, Day.SUNDAY, "Sara", 22);
        shop.processCoffeeOrder("Mocha", Size.SMALL, false, false);
        shop.processAlcoholOrder("Beer", Size.SMALL);

        double expected = 
            new Coffee("Mocha", Size.SMALL, false, false).calcPrice() +
            new Alcohol("Beer", Size.SMALL, shop.getCurrentOrder().isWeekend()).calcPrice();


        assertEquals(expected, shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()), 0.01);
    }

    @Test
    public void testTotalMonthlySale() {
        shop.startNewOrder(12, Day.SUNDAY, "Sara", 22);
        shop.processCoffeeOrder("Mocha", Size.SMALL, false, false);

        shop.startNewOrder(13, Day.MONDAY, "Bob", 45);
        shop.processSmoothieOrder("Green", Size.MEDIUM, 2, false);

        double total = 0;
        for (Order ord : shop.orderList) {
            total += ord.calcOrderTotal();
        }

        assertEquals(total, shop.totalMonthlySale(), 0.01);
    }

    @Test
    public void testSortOrders() {
        shop.startNewOrder(10, Day.MONDAY, "A", 30);
        shop.startNewOrder(12, Day.TUESDAY, "B", 30);
        shop.startNewOrder(14, Day.WEDNESDAY, "C", 30);

        int first = shop.getOrderAtIndex(0).getOrderNo();
        int second = shop.getOrderAtIndex(1).getOrderNo();
        int third = shop.getOrderAtIndex(2).getOrderNo();

        shop.sortOrders();

        int sorted1 = shop.getOrderAtIndex(0).getOrderNo();
        int sorted2 = shop.getOrderAtIndex(1).getOrderNo();
        int sorted3 = shop.getOrderAtIndex(2).getOrderNo();

        assertTrue(sorted1 <= sorted2);
        assertTrue(sorted2 <= sorted3);
    }
}
