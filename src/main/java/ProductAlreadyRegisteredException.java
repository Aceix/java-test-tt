public class ProductAlreadyRegisteredException extends Exception {
    ProductAlreadyRegisteredException() {
        super();
    }

    ProductAlreadyRegisteredException(String msg) {
        super(msg);
    }

    ProductAlreadyRegisteredException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
