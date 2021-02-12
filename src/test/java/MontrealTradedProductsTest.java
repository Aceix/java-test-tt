import junit.framework.TestCase;
import org.mockito.Mockito;

public class MontrealTradedProductsTest extends TestCase {

    private MontrealTradedProducts trader;
    private Product p1;
    private Product p2;
    private final ProductPricingService mockService = Mockito.mock(ProductPricingService.class);

    public void setUp() throws Exception {
        super.setUp();

        this.trader = new MontrealTradedProducts();

        Mockito.when(mockService.price(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(3.0);
        Mockito.when(mockService.price(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(3.0);
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
        this.p1 = new Stock();
        this.p2 = new Future();


    }

    public void testTotalValueOfDaysTradedProducts() {
    }
}