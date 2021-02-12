import junit.framework.TestCase;

public class MontrealTradedProductsTest extends TestCase {

    private MontrealTradedProducts trader;
    private Product p1;
    private Product p2;

    public void setUp() throws Exception {
        super.setUp();

        this.trader = new MontrealTradedProducts();
    }

    public void testAddNewProductShouldSucceed() {
        this.p1 = new Stock();

        try {
            this.trader.addNewProduct(p1);
            assertTrue(this.trader.isProductTracked(p1));
        } catch (ProductAlreadyRegisteredException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testAddNewProductShouldFail() {
        this.p1 = new Stock();

        try {
            this.trader.addNewProduct(p1);
            this.trader.addNewProduct(p1);

            System.out.println("Duplicate tracking is illegal! You should not see this message.");
            fail("Duplicate product illegally tracked");
        } catch (ProductAlreadyRegisteredException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testTrade() {
    }

    public void testTotalTradeQuantityForDay() {
    }

    public void testTotalValueOfDaysTradedProducts() {
    }
}