import java.time.LocalDate;
import java.util.*;
import java.util.stream.DoubleStream;

public class MontrealTradedProducts implements TradedProducts {

    private final Set<Product> trackedProducts;
    private final Map<LocalDate, List<Trade>> tradeLog;

    public MontrealTradedProducts() {
        this.trackedProducts = new HashSet<>();
        this.tradeLog = new HashMap<>();
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (!this.trackedProducts.add(product)) {
            throw new ProductAlreadyRegisteredException("Product is already being tracked: " + product);
        }
    }

    @Override
    public void trade(Product product, int quantity) {
        // log the trade under today's trades only if product is tracked
        this.trackedProducts.stream()
                .filter(product1 -> product1.equals(product))
                .findAny()
                .ifPresent(product1 -> {
                    var today = LocalDate.now();
                    if(!this.tradeLog.containsKey(today)) {
                        this.tradeLog.put(today, new ArrayList<>());
                    }
                    this.tradeLog.get(today).add(new Trade(product, quantity));
                });
    }

    @Override
    public int totalTradeQuantityForDay() {
        var today = LocalDate.now();
        int total = 0;

        if(this.tradeLog.containsKey(today)) {
            total = this.tradeLog.get(today).stream()
                    .mapToInt(Trade::getQuantity)
                    .sum();
        }

        return total;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double total = 0.0;

        // calculate the total value of all logged trades
        total = this.tradeLog.values().stream()
                .flatMap(Collection::stream)
                .flatMapToDouble(trade -> DoubleStream.of(trade.getQuantity() * trade.getProduct().getValue()))
                .sum();

        return total;
    }

    public boolean isProductTracked(Product product) {
        return this.trackedProducts.contains(product);
    }
}
