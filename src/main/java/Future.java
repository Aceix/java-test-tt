public class Future extends Product {

    private String exchange;
    private String contractCode;
    private int month;
    private int year;

    public Future() {
        super();
    }

    public Future(String id, String exchange) {
        super(id);
        this.exchange = exchange;
    }

    public Future(String id, String exchange, String contractCode) {
        super(id);
        this.exchange = exchange;
        this.contractCode = contractCode;
    }

    public Future(String id, String exchange, String contractCode, int month) {
        super(id);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
    }

    public Future(String id, String exchange, String contractCode, int month, int year) {
        super(id);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

    public Future(
            String id,
            String exchange,
            String contractCode,
            int month,
            int year,
            ProductPricingService ps)
    {
        super(id, ps.price(exchange, contractCode, month, year));
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
