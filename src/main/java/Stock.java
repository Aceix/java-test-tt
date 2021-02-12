public class Stock extends Product {

    private String ticker;
    private String exchange;

    public Stock() {}

    public Stock(String id) {
        super(id);
    }

    public Stock(String id, String ticker) {
        super(id);

        this.ticker = ticker;
    }

    public Stock(String id, String ticker, String exchange) {
        super(id);

        this.ticker = ticker;
        this.exchange = exchange;
    }

    public Stock(String id, String ticker, String exchange, ProductPricingService ps) {
        super(id, ps.price(exchange, ticker));

        this.ticker = ticker;
        this.exchange = exchange;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
}
