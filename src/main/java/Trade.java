import java.util.Date;
import java.util.Random;

public class Trade {
    private final String id;
    private final Product product;
    private final int quantity;

    public Trade(Product product, int quantity) {
        var r = new Random();

        this.id = ((Integer) r.nextInt(Integer.MAX_VALUE)).toString();
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
