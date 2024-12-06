public class OutOfMaxValueException extends RuntimeException{
    public OutOfMaxValueException() {
        System.out.println("Выход за 1024");
    }

    public OutOfMaxValueException(String message) {
        super(message);
    }

    public OutOfMaxValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfMaxValueException(Throwable cause) {
        super(cause);
    }

    public OutOfMaxValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
